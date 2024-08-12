package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class AmberBlaze extends ColorScheme {
    @Override
    public void pushColor() {
        Color c = new Color(0xFFFFB300, 0xFFFFA000,0xFFFF8F00);
        addColor("border",c);
        addColor("element_border",c);
        c = new Color(0xFFFFF3E0, 0x66FFCC80,0x4DFFB74D);
        addColor("background",c);
        addColor("element_background",c);
        c = new Color(0xFF4E342E, 0x994E342E,0xCC4E342E);
        addColor("text",c);
        addColor("element_text",c);
    }
}
