package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Objects;

public class ColorSchemes{
    private static ColorScheme global = ColorSchemeRegister.DEFAULT.get();
    public static ColorScheme getGlobal() {
        return global;
    }


    public static void setGlobal(ColorScheme colorScheme) {
        global = colorScheme;
    }


    public static <I extends ColorScheme> void setGlobal(DeferredHolder<ColorScheme, I> colorScheme) {
        setGlobal(Objects.requireNonNullElse(colorScheme, ColorSchemeRegister.DEFAULT).get());
    }
}
