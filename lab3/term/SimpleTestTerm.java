package term;

public class SimpleTestTerm {
  protected Constant a = new Constant("a"); // a
  protected Variable x = new Variable("x"); // x
  protected Variable y = new Variable("y"); // y
  protected TermList xList = new TermList(x); // (x)
  protected Function fx = new Function("f", xList); // f(x)
  protected TermList yfxList = new TermList(y, fx); // (y, f(x))
  protected Function gyfx = new Function("g", yfxList); // g(y, f(x))

  protected void printBoth(Object input, Object output) {
    System.out.println(input + " = " + output);
  }

  public void testAll() {
    printBoth("a[x\\y]", a.substitute(x, y));
    printBoth("x[x\\y]", x.substitute(x, y));
    printBoth("y[y\\a]", y.substitute(y, a));
    printBoth("y[x\\y]", y.substitute(x, y));
    printBoth("(x)[x\\y]", xList.substitute(x, y));
    printBoth("f(x)[x\\f(x)]", fx.substitute(x, fx));
    printBoth("g(y, f(x))[x\\f(x)]", gyfx.substitute(x, fx));
  }

  public static void main(String[] args) {
    new SimpleTestTerm().testAll();
  }
}
