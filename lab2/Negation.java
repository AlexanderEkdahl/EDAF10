import java.util.Map;
import java.util.Set;

public class Negation extends Expr {
  private Expr expr;

    public Negation(Expr expr){
        this.expr = expr;
    }

    public String toString(){
        return "(¬" + expr.toString() + ")";
    }

    public boolean value(Map<Variable, Boolean> map) {
        return !(expr.value(map));
    }

    public void collectVariables(Set<Variable> set) {
        expr.collectVariables(set);
    }
}
