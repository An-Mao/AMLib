package anmao.mc.amlib.amlib.network.easy_net;

import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.network.tip$gui.TipGuiNetSTC;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EasyNetRegister {
    public static final ResourceLocation KEY = new ResourceLocation(AMLib.MOD_ID, "easy_net");
    public static final DeferredRegister<EasyNet> EASY_NET = DeferredRegister.create(KEY, AMLib.MOD_ID);
    public static final Supplier<IForgeRegistry<EasyNet>> REGISTRY = EASY_NET.makeRegistry(RegistryBuilder::new);

    public static final RegistryObject<EasyNet> TipGui = EASY_NET.register("tip_gui", TipGuiNetSTC::new);



    public static void register(IEventBus eventBus){
        EASY_NET.register(eventBus);
    }
}
