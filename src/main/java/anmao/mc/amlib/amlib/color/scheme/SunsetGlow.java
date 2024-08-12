package anmao.mc.amlib.amlib.color.scheme;


import anmao.dev.core.color.ColorScheme;

public class SunsetGlow extends ColorScheme {
    public SunsetGlow() {
    }
    @Override
    public void pushColor() {
        ColorScheme.Color c = new ColorScheme.Color(0x80FF7043, 0x99FF7043,0xCCFF7043);
        addColor("border", c);
        addColor("element_border", c);
        c = new ColorScheme.Color(0x4DFFE6E6, 0x66FFE6E6,0x80FFE6E6);
        addColor("background",c);
        addColor("element_background",c);
        c = new ColorScheme.Color(0x803D1E1E, 0x993D1E1E,0xCC3D1E1E);
        addColor("text",c);
        addColor("element_text",c);
    }
}