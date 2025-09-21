JC = javac
JVM = java
SRC = *.java
MAIN = Main

compile:
	$(JC) $(SRC)

run: compile
	$(JVM) $(MAIN)

clean:
	del *.class