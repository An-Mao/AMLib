package anmao.mc.amlib;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AMLib.MOD_ID)
public class AMLib {
    public static final String MOD_ID = "amlib";
    public AMLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        test();
    }
    private void test( ) {
    }

}
