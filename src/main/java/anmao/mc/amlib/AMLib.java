package anmao.mc.amlib;

import anmao.mc.amlib.component.ComponentStyleCDT;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Arrays;

@Mod(AMLib.MOD_ID)
public class AMLib {
    public static final String MOD_ID = "amlib";
    public AMLib() {
        //IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //MinecraftForge.EVENT_BUS.register(this);
    }
}
