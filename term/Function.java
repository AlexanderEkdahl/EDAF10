package term;

import java.util.Set;

public class Function implements Term {
	private String name;
	private TermList list;

	public Function(String name, TermList list) {
		this.name = name;
		this.list = list;
	}

	public Set<Variable> collectVariables(Set<Variable> set) {
		return list.collectVariables(set);
	}

	public String toString() {
		return name + list;
	}

	public Term substitute(Variable x, Term term) {
		return new Function(name, list.substitute(x, term));
	}
}
