package main;
import errorStreetException.*;
public interface CarInterface {

    void moveFroward() throws StreetLengthException;
    
    boolean leftLaneDetect(UltrasoundSensor r1,UltrasoundSensor r2,UltrasoundSensor r3,Lidar l1);
    
    void changeLane(UltrasoundSensor r1,UltrasoundSensor r2,UltrasoundSensor r3,Lidar l1) throws StreetLengthException;
    
    Position whereIs() throws StreetLengthException;
    

}