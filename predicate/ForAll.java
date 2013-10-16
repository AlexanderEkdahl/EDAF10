package predicate;

import java.util.HashSet;

import term.Term;
import term.Variable;

public class ForAll implements Expr {
    private Variable x;
    private Expr expr;

    public ForAll(Variable x, Expr expr) {
        this.x = x;
        this.expr = expr;
    }

    public Expr substitute(Variable variable, Term term) {
        if (x.equals(variable)) {
            return this;
        } else if (!term.collectVariables(new HashSet<Variable>()).contains(x)) {
            return new ForAll(x, expr.substitute(variable, term));
        } else {
            Variable v = new Variable();
            return new ForAll(v, expr.substitute(x, v).substitute(variable, term));
        }
    }

    public String toString() {
        return "∀" + x + " . " + expr;
    }
}
