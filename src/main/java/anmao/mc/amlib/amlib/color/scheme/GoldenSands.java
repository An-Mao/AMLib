package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class GoldenSands  extends ColorScheme {
    @Override
    protected void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0xFFB300, 0xFFA000, 0xFF8F00);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0xFFF3E0, 0xFFE0B2, 0xFFCC80);
        addColor("background", c);
        addColor("element_background", c);
        c = new ColorScheme.Color(0x795548, 0x6D4C41, 0x5D4037);
        addColor("text", c);
        addColor("element_text", c);
    }
}
