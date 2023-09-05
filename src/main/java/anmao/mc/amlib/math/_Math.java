package anmao.mc.amlib.math;

import anmao.mc.amlib.Core;

public class _Math extends Core {
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
