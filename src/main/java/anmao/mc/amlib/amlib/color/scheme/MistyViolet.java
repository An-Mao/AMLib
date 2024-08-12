package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class MistyViolet  extends ColorScheme {
    @Override
    public void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x804A148C, 0x994A148C,0xCC4A148C);
        addColor("border",c);
        addColor("element_border",c);
        c = new ColorScheme.Color(0xEDE7F6, 0xC5CAE9,0xA5A4E4);
        addColor("background",c);
        addColor("element_background",c);
        c = new ColorScheme.Color(0xFF311B92, 0x99311B92,0xCC311B92);
        addColor("text",c);
        addColor("element_text",c);
    }
}
