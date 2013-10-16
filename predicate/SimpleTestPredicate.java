package predicate;

import term.SimpleTestTerm;
import term.TermList;
import term.Variable;

public class SimpleTestPredicate extends SimpleTestTerm {
    Variable z = new Variable("z"); // z
    Variable v0 = new Variable(); // v0
    Predicate px = new Predicate("P", xList); // P(x)
    Predicate py = new Predicate("P", new TermList(y)); // P(y)
    Predicate pz = new Predicate("P", new TermList(z)); // P(z)
    Predicate qxy = new Predicate("Q", new TermList(x, y)); // Q(x, y)
    Implies pxImpliesPy = new Implies(px, py); // P(x) -> P(y)
    ForAll forAllxPx = new ForAll(x, px); // ∀x . P(x)
    ForAll forAllxPy = new ForAll(x, py); // ∀x . P(y)
    ForAll forAllxPz = new ForAll(x, pz); // ∀x . P(z)
    ForAll forAllxQxy = new ForAll(x, qxy); // ∀x . Q(x, y)

    public void testAllExpr() {
        printBoth("P(x)[x\\y]", "P(x)[x\\y]");
        printBoth("(P(x) → P(y))[x\\y]", pxImpliesPy.substitute(x, y));
        printBoth("(∀x . P(x))[x\\y]", forAllxPx.substitute(x, y));
        printBoth("(∀x . P(y))[y\\z]", forAllxPy.substitute(y, z));
        Variable.resetCounter();
        printBoth("(∀x . Q(x,y)[y\\f(x)]", forAllxQxy.substitute(y, fx));
    }


    public static void main(String[] args) {
        new SimpleTestPredicate().testAllExpr();
    }
}
