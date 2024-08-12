package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class SoftLavender extends ColorScheme {
    @Override
    protected void pushColor() {
        Color c = new Color(0xFF9575CD, 0xFF7E57C2, 0xFF673AB7);
        addColor("border", c);
        addColor("element_border", c);
        c = new Color(0xFFEDE7F6, 0xFFD1C4E9, 0xFFB39DDB);
        addColor("background", c);
        addColor("element_background", c);
        c = new Color(0xFF311B92, 0xFF4527A0, 0xFF512DA8);
        addColor("text", c);
        addColor("element_text", c);
    }
}
