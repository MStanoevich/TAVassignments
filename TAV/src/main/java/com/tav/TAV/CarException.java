package com.tav.TAV;

public class CarException extends Exception {
    int errorCode;

    CarException(int errorCode){
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        switch (this.errorCode){
            case 403:
                return "Failed to switch lane: Obstacle detected!";
            case 404:
                return "Failed to move car: End of road detected!";
        }
        return "";
    }
}
