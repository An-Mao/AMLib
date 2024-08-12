package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class CoralReef extends ColorScheme {
    @Override
    protected void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0xFF6F61, 0xFF8A80, 0xFF5252);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0xFFE0E0, 0xFFCDD2, 0xFF8A80);
        addColor("background", c);
        addColor("element_background", c);
        c = new ColorScheme.Color(0x212121, 0x424242, 0x616161);
        addColor("text", c);
        addColor("element_text", c);
    }
}
