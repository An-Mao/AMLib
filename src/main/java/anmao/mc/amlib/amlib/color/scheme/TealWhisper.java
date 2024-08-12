package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class TealWhisper extends ColorScheme {
    @Override
    public void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x992E7D32, 0xCC388E3C,0xFF43A047);
        addColor("border",c);
        addColor("element_border",c);
        c = new ColorScheme.Color(0xB2DFDB, 0x80CBC4,0x4DB6AC);
        addColor("background",c);
        addColor("element_background",c);
        c = new ColorScheme.Color(0xCC004D40, 0x99004D40,0xFF004D40);
        addColor("text",c);
        addColor("element_text",c);
    }
}
