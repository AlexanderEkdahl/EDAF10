.PHONY: lab2 lab3 lab4

all: lab2 lab3 lab4

lab2:
	@javac expr/*.java
	@java expr.Main

lab3:
	@javac predicate/*.java
	@javac term/*.java
	@java term.SimpleTestTerm
	@java predicate.SimpleTestPredicate

lab4:
	@javac parser/*.java
	@java parser.SimpleParserTest
