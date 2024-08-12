package anmao.mc.amlib.amlib.event;

import anmao.dev.core.color.ColorHelper;
import anmao.dev.core.color.ColorScheme;
import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.color.ColorSchemeRegister;
import anmao.mc.amlib.amlib.color.ColorSchemes;
import anmao.mc.amlib.amlib.config.color.ColorConfig;
import anmao.mc.amlib.amlib.util.KeyBinding;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        String scheme = ColorConfig.instance.getDatas().getColorScheme();
        ResourceLocation colorSchemeRes = ResourceLocation.tryParse(scheme);
        ColorSchemeRegister.REGISTRY.get().forEach(colorScheme -> {

            System.out.println("f test:"+ ColorHelper.intToHexColor(colorScheme.getSelectColor("element_background")));
        });

        System.out.println("colorScheme::"+colorSchemeRes);
        ColorScheme colorScheme = ColorSchemeRegister.REGISTRY.get().getValue(colorSchemeRes);
        System.out.println("test:"+ ColorHelper.intToHexColor(colorScheme.getSelectColor("element_background")));
        ColorSchemes.setGlobal(colorScheme);
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.OPEN_MENU);

    }
}
