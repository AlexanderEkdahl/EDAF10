package expr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Expr> expressions = new ArrayList<Expr>();
        boolean test;

        // Variables
        Variable p = new Variable("p");
        Variable q = new Variable("q");
        Variable r = new Variable("r");

        // (((¬p) → (¬q)) → (((¬p) → q) → p))
        expressions.add(new Implication(new Implication(new Negation(p), new Negation(q)), new Implication(new Implication(new Negation(p), q), p)));

        // ((p → (¬q)) → (((¬p) → q) → p))
        expressions.add(new Implication(new Implication(p, new Negation(q)), new Implication(new Implication(new Negation(p), q), p)));

        // ((p → (q ⋁ r)) ↔ ((p → q) ⋁ (p → r)))
        expressions.add(new Equivalence(new Implication(p, new Disjunction(q, r)), new Disjunction(new Implication(p, q), new Implication(p, r))));

        // (((p ⋁ q) → r) ↔ ((p → r) ⋁ (p → q)))
        expressions.add(new Equivalence(new Implication(new Disjunction(p, q), r), new Disjunction(new Implication(p, r), new Implication(p, q))));

        // ((¬(p ⋁ q)) ↔ ((¬p) ⋀ (¬q)))
        expressions.add(new Equivalence(new Negation(new Disjunction(p, q)), new Conjunction(new Negation(p), new Negation(q))));

        // ((¬(p ⋀ q)) ↔ ((¬p) ⋁ (¬q)))
        expressions.add(new Equivalence(new Negation(new Conjunction(p, q)), new Disjunction(new Negation(p), new Negation(q))));

        // Run tests
        for (Expr e : expressions) {
          test = e.isTautology();
              System.out.println(e.toString() + (test ? " is " : " isn't ") + "a tautology.");
        }
    }
}
