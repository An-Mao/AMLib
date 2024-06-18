package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID, value = Dist.CLIENT)
public class ForgeClientEvent {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        /*
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            if (player.isAlive()) {
                System.out.println("event.getAction() ::" + event.getAction());
                if (KeyBinding.OPEN_MENU.consumeClick()) {
                    Minecraft.getInstance().setScreen(new TestScreen());
                }
            }
        }

        System.out.println("serverData:"+Minecraft.getInstance().isLocalServer());
        ServerData serverData = Minecraft.getInstance().getCurrentServer();
        if (serverData == null){
            System.out.println("serverData"+Minecraft.getInstance().getSingleplayerServer());
            return;
        }
        String ip = serverData.ip;
        System.out.println("serverData:" + ip);

         */
    }
}
