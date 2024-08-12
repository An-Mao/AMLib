package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class SoftLavender extends ColorScheme {
    @Override
    protected void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x9575CD, 0x7E57C2, 0x673AB7);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0xEDE7F6, 0xD1C4E9, 0xB39DDB);
        addColor("background", c);
        addColor("element_background", c);
        c = new ColorScheme.Color(0x311B92, 0x4527A0, 0x512DA8);
        addColor("text", c);
        addColor("element_text", c);
    }
}
