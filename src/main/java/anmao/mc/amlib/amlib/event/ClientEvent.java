package anmao.mc.amlib.amlib.event;

import anmao.dev.core.color.ColorScheme;
import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.color.ColorConfig;
import anmao.mc.amlib.amlib.color.ColorSchemeRegister;
import anmao.mc.amlib.amlib.color.ColorSchemes;
import anmao.mc.amlib.amlib.util.KeyBinding;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = AMLib.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        String scheme = ColorConfig.instance.getDatas().getColorScheme();
        ResourceLocation colorSchemeRes = ResourceLocation.tryParse(scheme);
        ColorScheme colorScheme = ColorSchemeRegister.REGISTRY.get(colorSchemeRes);
        ColorSchemes.setGlobal(colorScheme);
    }
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
        event.register(KeyBinding.OPEN_MENU);
    }
}
