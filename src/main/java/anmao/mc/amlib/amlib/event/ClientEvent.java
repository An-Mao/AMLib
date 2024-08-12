package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.color.ColorSchemeRegister;
import anmao.mc.amlib.amlib.color.ColorSchemes;
import anmao.mc.amlib.amlib.config.color.ColorConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        String scheme = ColorConfig.instance.getDatas().getColoeScheme();
        ColorSchemes.setGlobal(ColorSchemeRegister.REGISTRY.get().getValue(ResourceLocation.tryParse(scheme)));
    }
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
    }
}
