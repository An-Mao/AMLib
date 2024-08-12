package anmao.mc.amlib.amlib.color.scheme;


import anmao.dev.core.color.ColorScheme;

public class FreshMint extends ColorScheme {
    public FreshMint() {
    }
    @Override
    protected void pushColor() {
        Color c = new Color(0x807CC37C, 0x997CC37C,0xCC7CC37C);
        addColor("border", c);
        addColor("element_border", c);
        c = new Color(0x4DE6FFE6, 0x66E6FFE6,0x80E6FFE6);
        addColor("background",c);
        addColor("element_background",c);
        c = new Color(0x80333333, 0x99333333,0xCC333333);
        addColor("text",c);
        addColor("element_text",c);
            /*
            addColor("border",
                    new ColorScheme.Color(0x807CC37C, 0x997CC37C,0xCC7CC37C));
            addColor("background",
                    new ColorScheme.Color(0x4DE6FFE6, 0x66E6FFE6,0x80E6FFE6));
            addColor("text",
                    new ColorScheme.Color(0x80333333, 0x99333333,0xCC333333));

             */
    }
}