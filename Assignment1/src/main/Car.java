public class Car implements CarInterface {

    int[] position = new int[]{0, 0};

    @Override
    public void moveFroward() throws Exception{
        if (position[1] < 19){
            position[1] += 1;
        }else{
            throw new CarException(404);
        }
    }

    @Override
    public boolean leftLaneDetect() {
        //implement sensor code here, be default no car is on left
        return false;
    }

    @Override
    public void changeLane() throws Exception{
        if (leftLaneDetect()){
            moveFroward();
            throw new CarException(403);
        }else{
            moveFroward();
            if(position[0] == 0){
                position[0] = 1;
            }else if(position[0] == 1){
                position[0] = 2;
            }
        }
    }

    @Override
    public int[] whereIs() {
        return position;
    }
}
