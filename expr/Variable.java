package expr;

import java.util.Map;
import java.util.Set;

public class Variable extends Expr {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.hashCode() == other.hashCode();
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }

    protected void collectVariables(Set<Variable> set) {
        set.add(this);
    }

    public boolean value(Map<Variable, Boolean> map) {
        return map.get(this);
    }
}
