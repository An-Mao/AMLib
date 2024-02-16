package anmao.mc.amlib.test;

import anmao.mc.amlib.AMLib;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID)
public class RenderTest {
    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event){
        System.out.println(event.getEntity().getName()+"::"+event.getEntity().getMaxHealth());
    }
}
