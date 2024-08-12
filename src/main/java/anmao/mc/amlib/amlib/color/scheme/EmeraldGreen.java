package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class EmeraldGreen extends ColorScheme {
    @Override
    protected void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x2E7D32, 0x388E3C, 0x43A047);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0xE8F5E9, 0xC8E6C9, 0xA5D6A7);
        addColor("background", c);
        addColor("element_background", c);
        c = new ColorScheme.Color(0x004D40, 0x00695C, 0x00796B);
        addColor("text", c);
        addColor("element_text", c);
    }
}
