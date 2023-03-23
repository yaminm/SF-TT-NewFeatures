package textblocks;

public class Example {
  public static void main(String[] args) {
    String multiLine = """     
           X\n
              Y\\
         Z          
              """;
    System.out.println("X is :" + multiLine + ":");
    System.out.println(Integer.toHexString(multiLine.charAt(1)));
    System.out.println(multiLine.length());

    String two = """
     one
           ""\"""\"two""
        three
        """.indent(-8);
    System.out.println(two);
  }
}
