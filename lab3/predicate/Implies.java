package predicate;

import term.Term;
import term.Variable;

public class Implies implements Expr {
  private Expr expr1, expr2;

  public Implies(Expr expr1, Expr expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }

  public Expr substitute(Variable variable, Term term) {
    return new Implies(expr1.substitute(variable, term), expr2.substitute(variable, term));
  }

  public String toString() {
    return expr1 + " → " + expr2;
  }
}
