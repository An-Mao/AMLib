package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;
import net.minecraftforge.registries.RegistryObject;

public class ColorSchemes{
    private static ColorScheme global = ColorSchemeRegister.DEFAULT.get();
    public static ColorScheme getGlobal() {
        return global;
    }


    public static void setGlobal(ColorScheme colorScheme) {
        global = colorScheme;
    }


    public static void setGlobal(RegistryObject<ColorScheme> colorScheme) {
        if (colorScheme == null){
            setGlobal(ColorSchemeRegister.DEFAULT.get());
        }else {
            setGlobal(colorScheme.get());
        }
    }
}
