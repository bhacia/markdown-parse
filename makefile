tests: labMDP.class MarkdownParseTest.class
	java -cp .:./lib/* org.junit.runner.JUnitCore MarkdownParseTest
 
MarkdownParse.class : labMDP.java
	javac -cp .:./lib/* labMDP.java
 
MarkdownParseTest.class: labMDP.java labMDP.class
	javac -cp .:./lib/* MarkdownParseTest.java
