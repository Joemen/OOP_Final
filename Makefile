all: 
	javac -d . -classpath . *.java
run:
	java Game
clean:
	rm -f *.class
