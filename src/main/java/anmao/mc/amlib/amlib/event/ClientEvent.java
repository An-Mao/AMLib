package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.gui.TipGui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        event.registerAboveAll(TipGui.id, TipGui::render);
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
    }
}
