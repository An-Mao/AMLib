package anmao.mc.amlib.amlib.gui;

import anmao.mc.amlib.screen.widget.CircularWidget;
import anmao.mc.amlib.screen.widget.DT_ListBoxData;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TestScreen extends Screen {
    public TestScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        super.init();
        addRenderableWidget(new CircularWidget(width/2,height/2,width,height,5,0,80,Component.empty(),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"123"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),
                new DT_ListBoxData(Component.literal("HHHHHHHHHHHHHHHHHHHHHHHHHHHH"),"HHHHHHHHHHHHHHHHHHHHHHHHHHHH")
        ));
    }
}
