package recordstuff;

//class Car {
//  private int seatCount;
//  private String color;
//  // constructor
//  // equals, hashCode, toString
//  // getters (maybe setters)
//}

// arguments enumerated here are called "components"
// a component creates of a final field of that type
// (varargs result in an array)
// and a getter method with the name of the component
// returning the field type
// cannot have components with names like wait, notify, hashCode
// CAN control the accessor methods
// records cannot use "extends", parent is java.lang.Record
// records are implicitly final
record Car(int seatCount, String color) {
//  private String infoData = "Hello"; // instance fields are NOT permitted
//  {
   // instance initializer NOT PERMITTED
//  }

  @Override // NOT really an overide, it's a replacement
  // MUST return the type of the component, take zero args
  // and declare no exceptions
  public String color() {
    // NOPE, not "super" method available
    return "The color is " + color;
//    return "The color is " + super.color();
  }
  public String getInfo() {
    return "Lots of secrets, from a " + color + " car";
  }
  private static int MAX_SPEED;
  static {
    MAX_SPEED = Math.random() > 0.5 ? 150 : 98;
  }
  public static int getMaxSpeed() {
    return MAX_SPEED;
  }

  // Explicit Canonical constructor
  // must not be less accessible than the class
// NAME as well as param type MUST match the components
//  Car(int seatCount, String color) {
//    if (seatCount < 1) throw new IllegalArgumentException("Silly seats");
//    this.seatCount = seatCount;
//    this.color = color;
//  }

  // compact constructor (implicitly takes the same arguments as
  // the components declared for the record) does not declare
  // its parameter list
  Car {
    if (seatCount < 1) throw new IllegalArgumentException("Silly seats");
    // compact constructor continues on (or "falls through")
    // to the regular canonical constructor -- Cannot manually
    // code a canonical constructor AND compact in the same record
    // When you have a compact constructor the auto-generated
    // canonical will simply initialize the record's final fields
  }

  Car(int s) {
    this(s, "Gold");
  }
}

public class Example {
  public static void main(String[] args) {
    Car c1 = new Car(2, "Red");
    Car c2 = new Car(2, "Red");
    Car c3 = new Car(5, "Blue");

    System.out.println("c1.equals(c2) " + c1.equals(c2));
    System.out.println("c1.hashCode() " + c1.hashCode());
    System.out.println("c2.hashCode() " + c2.hashCode());
    System.out.println("c3.hashCode() " + c3.hashCode());
    System.out.println("Car is " + c1);

    System.out.println("Car 1 color is " + c1.color());
    // No "setter" methods, intended to be "immutable"
    System.out.println(c1.getInfo());
  }
}
