package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class ColorSchemeDefault extends ColorScheme {

    public ColorSchemeDefault() {
    }
    @Override
    public void pushColor() {
        addColor("border",
                new ColorScheme.Color(0xFF000000, 0xFF000000));
        addColor("text",
                new ColorScheme.Color(0xFFFFFFFF, 0xFF0000FF));
        addColor("background",
                new ColorScheme.Color(0x77000000, 0x77000000));
        addColor("element_border",
                new ColorScheme.Color(0xFF000000, 0xFF000000));
        addColor("element_text",
                new ColorScheme.Color(0xFFFFFFFF, 0xFF0000FF));
        addColor("element_background",
                new ColorScheme.Color(0x77000000, 0x77000000));
    }

}
