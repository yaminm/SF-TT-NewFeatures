package improvingswitch;

public class Expression {
  public static void main(String[] args) {
    var x = true ? "Hello" : 99; // "if/else as an expression"

    int s = 1;
    // Old, kinda yukky way.
//    String message = null;
//    switch (s) {
//      case 1 -> message = "It's one";
//    }

    // anywhere an expression is expected to complete
    // the syntax
    String message = switch (s) {
      case 1 -> {
        String p1 = "It's";
        String res = p1 + " one";
        int yield = 99;
        yield res;
      }
      case 3 -> "threee!!!";
//      default -> "don't know what to do";
      default -> throw new IllegalArgumentException("That can't happen");
    };
    System.out.println("message is " + message);

    System.out.println("----------------------");
    s = 2;
    int v = 99;
    System.out.println(switch(s){
      case 1: yield "It's one again";
      case 2:
        v = 100;
      case 3:
        v += 10;
        yield v;
      default: yield "Unknown";
    });
  }
}
