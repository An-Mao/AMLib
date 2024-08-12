package anmao.mc.amlib;

import anmao.mc.amlib.amlib.color.ColorSchemeRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(AMLib.MOD_ID)
public class AMLib {
    public static final String MOD_ID = "amlib";
    public AMLib(IEventBus bus) {
        ColorSchemeRegister.register(bus);
        test();
    }
    private void test(){
    }
}
