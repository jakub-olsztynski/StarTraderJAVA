package service;

public class DistanceCalculator {

    public DistanceCalculator(int x, int y) {
        int result = 0;
        if (x>y){
            result = x-y;
        }else if (y>x){
            result = y-x;
        }
    }
}
