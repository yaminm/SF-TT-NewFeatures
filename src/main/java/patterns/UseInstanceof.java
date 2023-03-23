package patterns;

import java.util.List;

record Car(int seats, String color) {
  @Override
  public boolean equals(Object other) {
    return other instanceof Car oc
        && this.color.equals(oc.color)
        && this.seats == oc.seats;
  }
}

record Truck(int payload) {
}

public class UseInstanceof {
  public static void main(String[] args) {
    int packageWeight = 1000;

    List<?> resources = List.of(
        new Car(5, "Blue"),
        new Truck(5_000)
    );

    // find which resources can carry this package
    for (Object obj : resources) {
//      if (obj instanceof Car) {
//        Car c = (Car)obj;
//        // cast, extract seatCount...
//      }
      if (obj instanceof Car c) {
        if ((c.seats() - 1) * 80 > packageWeight) {
          System.out.println(c + " can carry the package");
        }
      } else if (obj instanceof Truck t) {
        if (t.payload() > packageWeight) {
          System.out.println(t + " can carry the package");
        }
      }
    }

    Object obj = resources.get(0);
    if (!(obj instanceof Car c)) {
      // c is out of scope
      System.out.println("there's no car.. ");
    } else {
      System.out.println("yup, it's a " + c.color() + " car");
    }

    do {
//      if (Math.random() > 0.5) break;
    } while (!(obj instanceof Car c));
    System.out.println("The car is " + c.color());

    Object x = List.of("Hello");

    // generic types are compile time only, so this is illegal
//    System.out.println(x instanceof List<String>);
// this
    System.out.println(x instanceof List<?>);

    // for this to work, generic type element must be
    // known at compile time
    Iterable<String> ls = List.of("Fred", "Jim");
    if (ls instanceof List<String> l) {
      String s = l.get(0);
    }
  }
}
