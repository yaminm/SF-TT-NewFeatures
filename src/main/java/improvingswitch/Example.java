package improvingswitch;

public class Example {
  public static void main(String[] args) {
    int x = 2;
    switch (x) {
      case 0:
        System.out.println("it's zero");
        break;
      case 1:
        int odd = 99;
        System.out.println("it's one");
        break;
      case 2:
        System.out.println("it's one or two");
      // comma separated alternation permitted here too (why use :)
      case 3, 4, 5:
        odd = 3;
        System.out.println("it's three" + odd);
    }

    System.out.println("-------------------");
    x = 0;
    switch (x) {
      case 0 -> {
        System.out.println("it's zero");
        if (Math.random() > 0.5) break; // Kinda ugly, but permitted
        System.out.println("and that's nought to you");
      }
      case 1, 2 ->
        System.out.println("it's one or two");
      case 3 ->
        System.out.println("it's three");
      case 4 -> System.out.println("good scoping :)");//int nope = 10;
    }

  }
}
