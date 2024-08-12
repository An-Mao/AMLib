package anmao.mc.amlib.amlib.event;

import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.util.KeyBinding;
import anmao.mc.amlib.item.ItemHelper;
import anmao.mc.amlib.screen.SettingScreen;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = AMLib.MOD_ID, value = Dist.CLIENT)
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

         */
        if (event.getKey() == KeyBinding.OPEN_MENU.getKey().getValue()) {
            Screen screen = Minecraft.getInstance().screen;
            if (event.getAction() == 1) {
                if (screen == null) {
                    Minecraft.getInstance().setScreen(new SettingScreen());
                }
            }
        }
    }
    public static void outputAttributes(){
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player != null){
            Multimap<Holder<Attribute>, AttributeModifier> modifiers = ItemHelper.getAttributeModifiers(player.getMainHandItem(), EquipmentSlot.MAINHAND);
            System.out.println(modifiers);
        }
    }
}
