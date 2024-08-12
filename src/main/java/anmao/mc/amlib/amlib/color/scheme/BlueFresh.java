package anmao.mc.amlib.amlib.color.scheme;


import anmao.dev.core.color.ColorScheme;

public class BlueFresh extends ColorScheme {
    public BlueFresh() {
    }
    @Override
    public void pushColor() {
        addColor("border",
                new Color(0x8044CCFF, 0xA63399CC,0xCC2266CC));
        addColor("background",
                new Color(0x4DE6F0FF, 0x66CCE0FF,0x8099C2FF));
        addColor("text",
                new Color(0x99113399, 0xB2000D66,0xCC000A33));
        addColor("element_border",
                new Color(0xA63366FF, 0xCC2266CC,0xFF113399));
        addColor("element_background",
                new Color(0x66D6E0FF, 0x80B3C2FF,0x998099FF));
        addColor("element_text",
                new Color(0xB2002666, 0xCC113399,0xFF000A1A));
    }
}