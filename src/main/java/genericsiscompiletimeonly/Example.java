package genericsiscompiletimeonly;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair<E> {
  private E left;
  private E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }
}

public class Example {
  public static void addToAListOfString(List<String> ls) {}
  public static void breakAList(List l) {
    l.add(0, LocalDate.now());
  }
  public static void main(String[] args) {
    List<String> ls = Collections.checkedList(
        new ArrayList<String>(), String.class);
    ls.add("Hello");
//    ls.add(LocalDate.now());
    breakAList(ls);
    // Includes a cast ANYWAY!!!
    String s = /*(String)*/ls.get(0);
    System.out.println(s);

    Pair<String> ps = new Pair<String>("Hello", "Bonjour");
  }
}
