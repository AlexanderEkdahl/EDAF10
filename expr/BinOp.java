package expr;

import java.util.Map;
import java.util.Set;

public abstract class BinOp extends Expr {
    private Expr expr1, expr2;

    public BinOp(Expr expr1, Expr expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    protected abstract boolean op(Boolean one, Boolean two);

    protected abstract String symbol();

    public String toString(){
        return "(" + expr1.toString() + " " + this.symbol() + " " + expr2.toString() + ")";
    }

    public void collectVariables(Set<Variable> set) {
        expr1.collectVariables(set);
        expr2.collectVariables(set);
    }

    public boolean value(Map<Variable, Boolean> m) {
        return op(expr1.value(m), expr2.value(m));
    }
}
