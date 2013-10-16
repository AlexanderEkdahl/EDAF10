package predicate;

import term.Term;
import term.TermList;
import term.Variable;

public class Predicate implements Expr {
    private String name;
    private TermList termList;

    public Predicate(String string, TermList termList) {
        this.name = string;
        this.termList = termList;
    }

    public Expr substitute(Variable variable, Term term) {
        return new Predicate(name, termList.substitute(variable, term));
    }

    public String toString() {
        return name + termList;
    }
}
