import java.util.Map;
import java.util.Set;

public class Equivalence extends BinOp {
    public Equivalence(Expr expr1, Expr expr2){
        super(expr1, expr2);
    }

    public String symbol(){
        return "↔";
    }

    protected boolean op(Boolean one, Boolean two) {
        return one == two;
    }
}
