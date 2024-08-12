package anmao.mc.amlib.amlib.color.scheme;

import anmao.dev.core.color.ColorScheme;

public class CrimsonTide  extends ColorScheme {
    @Override
    public void pushColor() {
        Color c = new Color(0x99D32F2F, 0xCCB71C1C,0xFFB71C1C);
        addColor("border",c);
        addColor("element_border",c);
        c = new Color(0xFFFFEBEE, 0xFFF2F2F2,0xCCF2F2F2);
        addColor("background",c);
        addColor("element_background",c);
        c = new Color(0xFF000000, 0x99000000,0xCC000000);
        addColor("text",c);
        addColor("element_text",c);
    }
}
