package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = AMLib.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Events {
    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
