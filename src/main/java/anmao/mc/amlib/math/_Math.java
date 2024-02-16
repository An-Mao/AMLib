package anmao.mc.amlib.math;

public class _Math {

    public static int maxToZero(int value , int max){
        value++;
        if (value > max){
            return 0;
        }
        return value;
    }
    public static float maxToZero(float value , float max){
        value++;
        if (value > max){
            return 0;
        }
        return value;
    }



    public static int log(Float number,int base) {
        int customBaseLog = 0;
        double powerOfBase = 1.0;

        while (powerOfBase < number) {
            powerOfBase *= base;
            customBaseLog++;
        }

        if (powerOfBase > number) {
            customBaseLog--;
        }
        return customBaseLog;
    }
    public static int log(Double number,int base) {
        int customBaseLog = 0;
        double powerOfBase = 1.0;

        while (powerOfBase < number) {
            powerOfBase *= base;
            customBaseLog++;
        }

        if (powerOfBase > number) {
            customBaseLog--;
        }
        return customBaseLog;
    }
    public static int log2Floor(int n){
        assert n >= 1;
        int log = 0;
        if(n > 0xffff){
            n >>>= 16;
            log = 16;
        }
        if(n > 0xff){
            n >>>= 8;
            log |= 8;
        }
        if(n > 0xf){
            n >>>= 4;
            log |= 4;
        }
        if(n > 0b11){
            n >>>= 2;
            log |= 2;
        }
        return log + (n >>> 1);
    }
}
