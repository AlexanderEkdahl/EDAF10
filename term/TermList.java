package term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;

public class TermList extends ArrayList<Term> {
    public TermList(Term... terms) {
        super(Arrays.asList(terms));
    }

    public Set<Variable> collectVariables(Set<Variable> set) {
        for (Term term : this) {
            term.collectVariables(set);
        }
        return set;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Term> it = super.iterator();

        builder.append('(');

        while (it.hasNext()) {
            builder.append(it.next());

            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append(')');

        return builder.toString();
    }

    public TermList substitute(Variable x, Term y) {
        TermList tempList = new TermList();
        for (Term t : this) {
            tempList.add(t.substitute(x, y));
        }
        return tempList;
    }
}
