package main;
public interface CarInterface {

    boolean moveFroward();
    
    boolean leftLaneDetect(UltrasoundSensor r1,UltrasoundSensor r2,UltrasoundSensor r3,Lidar l);
    
    int changeLane();
    
    int[] whereIs();
    

}