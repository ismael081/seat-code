# Mower
Current project implements a solution for SEAT:CODE technical challenge.

## Assumptions
- Java 11.
- Maven 3.
- Main class: com.seat.Main.
- If next movement of a mower is out of the limits of the plateau, it will not move.
- If planned next movement of a mower is occupied by another mower, the first mower will not move.
- If a mower do not move due to the fact that the planned next movement is not valid, the mower will discard that movement and try to do next instruction.
## Build
```bash
mvn clean package
```
## Run tests
```bash
mvn clean verify
```
## Run scenario
- Build project as described in previous section named Build. 
- Define scenario to be run in scenario.txt file.
- Then run following command:
```bash
java -jar ./target/mower-1.0-SNAPSHOT-jar-with-dependencies.jar
```
File with scenario (scenario.txt) must be where you run previous command.