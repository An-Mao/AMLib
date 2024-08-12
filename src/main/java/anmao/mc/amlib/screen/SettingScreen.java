package anmao.mc.amlib.screen;

import anmao.dev.core.color.ColorScheme;
import anmao.mc.amlib.amlib.color.ColorSchemeRegister;
import anmao.mc.amlib.amlib.color.ColorSchemes;
import anmao.mc.amlib.amlib.color.ColorConfig;
import anmao.mc.amlib.screen.widget.DT_ListBoxData;
import anmao.mc.amlib.screen.widget.simple.SimpleButton;
import anmao.mc.amlib.screen.widget.simple.SimpleDropDownSelectBox;
import anmao.mc.amlib.screen.widget.simple.SimpleLabel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class SettingScreen extends Screen {
    SimpleDropDownSelectBox colorSelectBox;
    SimpleButton saveButton;
    public SettingScreen( ) {
        super(Component.translatable("screen.amlib.settings.title"));
    }

    @Override
    protected void init() {
        super.init();
        int x = this.width / 2, y = this.height / 2;
        SimpleLabel label = new SimpleLabel(64, y - 8,16,16,Component.translatable("screen.amlib.settings.label.select_color"),true,false,true);
        addRenderableWidget(label);
        colorSelectBox = new SimpleDropDownSelectBox( label.getX()+label.getWidth()+5,label.getY(), 80, 16, ColorSchemeRegister.getSchemeComponent(ColorSchemes.getGlobal()),getRegColor())
                .setRadius(2);
        addRenderableWidget(colorSelectBox);

        saveButton = new SimpleButton(x - 32, this.height - 64, 64, 16, Component.translatable("screen.amlib.settings.button.save"),true,false,true,this::save);
        addRenderableWidget(saveButton);
    }

    private void save() {
        DT_ListBoxData d = colorSelectBox.getSelectData();
        if (d != null) {
            if (d.getValue() instanceof ColorScheme colorScheme){
                String key = ColorSchemeRegister.REGISTRY.getKey(colorScheme).toString();
                //System.out.println("key:"+key);
                ColorConfig.instance.getDatas().setColorScheme(key);
                ColorConfig.instance.save();
                ColorSchemes.setGlobal(colorScheme);
                if (this.minecraft != null) {
                    this.minecraft.setScreen(new SettingScreen());
                }
            }
        }
    }




    public List<DT_ListBoxData> getRegColor(){
        List<DT_ListBoxData> data = new ArrayList<>();
        ColorSchemeRegister.REGISTRY.forEach(colorScheme -> data.add(new DT_ListBoxData(ColorSchemeRegister.getSchemeComponent(colorScheme),colorScheme)));
        return data;
    }
}
