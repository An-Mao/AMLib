package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class MidnightBlue extends ColorScheme {
    @Override
    protected void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x1A237E, 0x283593, 0x303F9F);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0xE8EAF6, 0xC5CAE9, 0x9FA8DA);
        addColor("background", c);
        addColor("element_background", c);
        c = new ColorScheme.Color(0xFFFFFF, 0xFAFAFA, 0xF5F5F5);
        addColor("text", c);
        addColor("element_text", c);
    }
}
