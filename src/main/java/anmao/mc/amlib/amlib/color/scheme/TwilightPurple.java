package anmao.mc.amlib.amlib.color.scheme;


import anmao.dev.core.color.ColorScheme;

public class TwilightPurple extends ColorScheme {
    public TwilightPurple() {
    }
    @Override
    public void pushColor() {
        Color c = new Color(0x805E4B8B, 0x995E4B8B,0xCC5E4B8B);
        addColor("border",c);
        addColor("element_border",c);
        c = new Color(0x4DE3D4F8, 0x66E3D4F8,0x80E3D4F8);
        addColor("background",c);
        addColor("element_background",c);
        c = new Color(0x803A2E75, 0x993A2E75,0xCC3A2E75);
        addColor("text",c);
        addColor("element_text",c);
    }
}
