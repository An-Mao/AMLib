package anmao.mc.amlib.text;

import anmao.mc.amlib.Core;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

public class _ColorText extends Core {
    private static final TextColor[] TEXT_COLORS = {
            TextColor.fromRgb(0xff0000),//0
            TextColor.fromRgb(0xff7f00),//1
            TextColor.fromRgb(0xffff00),//2
            TextColor.fromRgb(0x00ff00),//3
            TextColor.fromRgb(0x00ffff),//4
            TextColor.fromRgb(0x0000ff),//5
            TextColor.fromRgb(0x8b00ff)//6
    };
    public static Style getRainbowStyle(int index){
        return Style.EMPTY.withColor(TEXT_COLORS[index]);
    }
    public static MutableComponent RainbowKey(String key){
        return RainbowStr(Component.translatable(key).getString());
    }

    /**
     *
     * @param str text
     * @return MutableComponent
     */
    public static MutableComponent RainbowStr(String str){
        long t;
        if (MC.level != null) {
            t = MC.level.dayTime();
        }else {
            t = 7777;
        }
        int strlen = str.length();
        MutableComponent put = Component.literal("");
        int index = (int) (t % 21) / 3;
        if (strlen < 7 ){
            return put.append(Component.literal(str).withStyle(getRainbowStyle(index)));
        }
        for (int i = 0; i <strlen ; i++) {
            int ii = index - i % 7;
            if (ii < 0){
                ii = ii +7;
            }
            put.append(Component.literal(str.substring(i, i + 1)).withStyle(getRainbowStyle(ii)));
        }
        return put;
    }
}
