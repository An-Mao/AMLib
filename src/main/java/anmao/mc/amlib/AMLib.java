package anmao.mc.amlib;

import anmao.mc.amlib.amlib.network.easy_net.EasyNetRegister;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Mod(AMLib.MOD_ID)
public class AMLib {
    public static final String MOD_ID = "amlib";
    public AMLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EasyNetRegister.register(modEventBus);
        test();
    }
    private void test(){
    }
}
