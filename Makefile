all: 
	javac -classpath . src/*.java
run:
	java -cp ./src Game 1	
runterm:
	java -cp ./src Game 0
clean:
	rm -f src/*.class
