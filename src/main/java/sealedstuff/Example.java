package sealedstuff;

// declared sealed type and children in the same source
// we "assume" they're valid
// more commonly we will explicitly state the permitted subtypes
//sealed interface Carrier {}
sealed interface Carrier permits Car, Truck {}

record Car(int seats, String color) implements Carrier {}

// members of a sealed type hierarchy must be one of:
// sealed (which must declare permits), final (fairly normal)
// implicitly final or final-like (records, and enums), or
// break open the hierarchy below here by saying non-sealed
//non-sealed class Car implements Carrier {}
//final class Car implements Carrier {}

record Truck(int payload) implements Carrier {}
//record Bicycle(int bags) implements Carrier {}

public class Example {
  public static void main(String[] args) {
    Carrier thing = new Truck(5_000);
    if (thing instanceof Car c) {}
    else if (thing instanceof Truck t) {}
  }
}

class PatternMatchSwitch {
  public static void main(String[] args) {
    // can switch on object types
    Carrier c = new Car(5, "Blue");
    String msg = switch (c) {
      case Car(int seats, String col) -> c + " car with " + seats + " seats";
      default -> "Something else";
    };

    Object obj = "Hello";
    switch (obj) {
      // this case "dominates" the following one, if place here.
//      case String str ->
//          System.out.println("It's a string, probably short ish...");
      case String str when str.length() > 3 ->
          System.out.println("It's a longish string");
      case String str ->
          System.out.println("It's a string, probably short ish...");
      default -> System.out.println("something else");
    }
  }
}
