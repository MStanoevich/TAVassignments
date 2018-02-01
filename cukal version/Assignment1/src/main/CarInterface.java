package main;
import errorStreetException.*;
public interface CarInterface {

    boolean moveFroward() throws StreetLengthException;
    
    boolean leftLaneDetect(UltrasoundSensor r1,UltrasoundSensor r2,UltrasoundSensor r3,Lidar l);
    
    int changeLane() throws StreetLengthException;
    
    Position whereIs() throws StreetLengthException;
    

}