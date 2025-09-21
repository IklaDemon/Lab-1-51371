all: program.jar

Lab1.class: Lab1.java
	javac Lab1.java

program.jar: Lab1.class
	jar cfe program.jar Lab1 Lab1.class

run: program.jar
	java -jar program.jar

clean:
	rm program.jar
	rm Lab1.class

cleanWin:
	del program.jar
	del Lab1.class