package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID)
public class ForgeEvents {
    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event){
        if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            /*
            CompoundTag dat = new CompoundTag();
            dat.putString(Net.EASY_NET_KEY, NetTest.TipGui.getId().toString());
            dat.putString("tests","123");
            Net.EasyNetSTP(dat, serverPlayer);

             */
        }
    }
}
