package com.tav.TAV;

public interface CarInterface {

    void moveFroward() throws Exception;
    boolean leftLaneDetect();
    void changeLane() throws Exception;
    int[] whereIs();

}
