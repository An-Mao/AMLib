package anmao.mc.amlib.amlib.config;

import anmao.mc.amlib.amlib.config.general.GeneralConfig;
import anmao.mc.amlib.amlib.config.attribute.AttributeConfig;
import anmao.mc.amlib.amlib.config.the_world.TheWorldConfig;

public class Configs {
    public static final GeneralConfig general;
    public static final TheWorldConfig theWorld;
    public static final AttributeConfig attribute;
    static {
        general = new GeneralConfig();
        theWorld = new TheWorldConfig();
        attribute = new AttributeConfig();
    }
}
