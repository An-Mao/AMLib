package anmao.mc.amlib.math;

import java.util.Random;

public class _Random {
    public static int getRandomNumberH(int min ,int max){
        return getRandomNumber(min , max + 1);
    }
    public static int getRandomNumber(int min ,int max){
        //return RandomSource.createNewThreadLocalInstance().nextInt(min,max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static float getRandomFloat(){
        return (float) getRandomDouble();
    }
    public static double getRandomDouble(){
        Random random = new Random();
        return random.nextDouble();
    }
    public static int getIntRandomNumber(int min,int max){
        Random random = new Random();
        return random.nextInt(min,max+1);
    }
}
