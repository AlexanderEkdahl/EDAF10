package term;

import java.util.Set;

public class Constant implements Term {
    private String value;

    public Constant(String value) {
        this.value = value;
    }

    public Set<Variable> collectVariables(Set<Variable> set) {
        return set;
    }

    public String toString() {
        return value;
    }

    public Term substitute(Variable x, Term term) {
        return this;
    }
}
