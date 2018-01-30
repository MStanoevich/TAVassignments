public class Car implements CarInterface {

    int[] position = new int[]{2, 0};

    @Override
    public void moveFroward() {
        if (position[1] < 20){
            position[1] += 5;
        }
    }

    @Override
    public boolean leftLaneDetect() {
        return true;
    }

    @Override
    public int changeLane() {
        if (leftLaneDetect()){
            moveFroward();
            return 403;
        }else{
            moveFroward();
            if(position[0] == 2){
                position[0] = 1;
            }else if(position[0] == 1){
                position[0] = 0;
            }
            return 200;
        }
    }

    @Override
    public int[] whereIs() {
        return position;
    }
}
