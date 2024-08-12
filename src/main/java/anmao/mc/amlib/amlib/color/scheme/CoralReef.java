package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class CoralReef extends ColorScheme {
    @Override
    protected void pushColor() {
        Color c = new Color(0xFFFF6F61, 0xFFFF8A80, 0xFFFF5252);
        addColor("border", c);
        addColor("element_border", c);
        c = new Color(0xFFFFE0E0, 0xFFFFCDD2, 0xFFFF8A80);
        addColor("background", c);
        addColor("element_background", c);
        c = new Color(0xFF212121, 0xFF424242, 0xFF616161);
        addColor("text", c);
        addColor("element_text", c);
    }
}
