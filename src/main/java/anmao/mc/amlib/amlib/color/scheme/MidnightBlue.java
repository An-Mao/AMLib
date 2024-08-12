package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class MidnightBlue extends ColorScheme {
    @Override
    protected void pushColor() {
        Color c = new Color(0xFF1A237E, 0xFF283593, 0xFF303F9F);
        addColor("border", c);
        addColor("element_border", c);
        c = new Color(0xFFE8EAF6, 0xFFC5CAE9, 0xFF9FA8DA);
        addColor("background", c);
        addColor("element_background", c);
        c = new Color(0xFFFFFFFF, 0xFFFAFAFA, 0xFFF5F5F5);
        addColor("text", c);
        addColor("element_text", c);
    }
}
