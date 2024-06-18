package anmao.mc.amlib.net.netty;

import anmao.mc.amlib.AMLib;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

public class ClientEvent {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static NettyClient nettyClient;
    private static Thread clientThread;
    public static void onClientLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        nettyClient = new NettyClient();
        clientThread = new Thread(nettyClient);
        clientThread.start();
    }
    public static void onClientLogout(ClientPlayerNetworkEvent.LoggingOut event) {

    }
}
