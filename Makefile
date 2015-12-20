all: 
	javac -d . -classpath . *.java
run:
	java Game 0
runUI:
	java Game 1	
clean:
	rm -f *.class
