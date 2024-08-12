package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;

public class ColorSchemeDefault {
    public static class Default extends ColorScheme {
        @Override
        public void pushColor() {
            addColor("border",
                    new ColorScheme.Color(0xFF000000, 0xFF000000));
            addColor("text",
                    new ColorScheme.Color(0xFFFFFFFF, 0xFF0000FF));
            addColor("background",
                    new ColorScheme.Color(0x77000000, 0x77000000));
            addColor("element_border",
                    new ColorScheme.Color(0xFF000000, 0xFF000000));
            addColor("element_text",
                    new ColorScheme.Color(0xFFFFFFFF, 0xFF0000FF));
            addColor("element_background",
                    new ColorScheme.Color(0x77000000, 0x77000000));
        }
    }
    public static class ColdGray extends ColorScheme {
        @Override
        public void pushColor() {
            addColor("border",
                    new ColorScheme.Color(0x80CCCCCC, 0xA6999999,0xCC666666));
            addColor("background",
                    new ColorScheme.Color(0x4DFFFFFF, 0x66E6E6E6,0x80CCCCCC));
            addColor("text",
                    new ColorScheme.Color(0x99333333, 0xB2000000,0xCC000000));
            addColor("element_border",
                    new ColorScheme.Color(0xA6999999, 0xCC666666,0xFF333333));
            addColor("element_background",
                    new ColorScheme.Color(0x66F2F2F2, 0x80D9D9D9,0x99BFBFBF));
            addColor("element_text",
                    new ColorScheme.Color(0xB2666666, 0xCC333333,0xFF000000));
        }
    }
    public static class BlueFresh extends ColorScheme {
        @Override
        public void pushColor() {
            addColor("border",
                    new ColorScheme.Color(0x8044CCFF, 0xA63399CC,0xCC2266CC));
            addColor("background",
                    new ColorScheme.Color(0x4DE6F0FF, 0x66CCE0FF,0x8099C2FF));
            addColor("text",
                    new ColorScheme.Color(0x99113399, 0xB2000D66,0xCC000A33));
            addColor("element_border",
                    new ColorScheme.Color(0xA63366FF, 0xCC2266CC,0xFF113399));
            addColor("element_background",
                    new ColorScheme.Color(0x66D6E0FF, 0x80B3C2FF,0x998099FF));
            addColor("element_text",
                    new ColorScheme.Color(0xB2002666, 0xCC113399,0xFF000A1A));
        }
    }
    public static class NaturalGreenery extends ColorScheme {
        @Override
        public void pushColor() {
            addColor("border",
                    new ColorScheme.Color(0x8066CC66, 0xA655AA55,0xCC448844));
            addColor("background",
                    new ColorScheme.Color(0x4DE6FFE6, 0x66D9FFD9,0x80CCFFCC));
            addColor("text",
                    new ColorScheme.Color(0x99330033, 0xB2220022,0xCC110011));
            addColor("element_border",
                    new ColorScheme.Color(0xA699CC99, 0xCC77AA77,0xFF558855));
            addColor("element_background",
                    new ColorScheme.Color(0x66D9FFD9, 0x80BFFFBF,0x99A6FFA6));
            addColor("element_text",
                    new ColorScheme.Color(0xB2336633, 0xCC224422,0xFF112211));
        }
    }
    public static class OceanBreeze extends ColorScheme {
        @Override
        public void pushColor() {
            ColorScheme.Color c = new ColorScheme.Color(0x80489FB4, 0x99489FB4,0xCC489FB4);
            addColor("border", c);
            addColor("element_border", c);
            c = new ColorScheme.Color(0x4DE0F7FA, 0x66E0F7FA,0x80E0F7FA);
            addColor("background",c);
            addColor("element_background",c);
            c = new ColorScheme.Color(0x80334466, 0x99334466,0xCC334466);
            addColor("text",c);
            addColor("element_text",c);
        }
    }
    public static class SunsetGlow extends ColorScheme {
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
    public static class FreshMint extends ColorScheme {
        @Override
        public void pushColor() {
            ColorScheme.Color c = new ColorScheme.Color(0x807CC37C, 0x997CC37C,0xCC7CC37C);
            addColor("border", c);
            addColor("element_border", c);
            c = new ColorScheme.Color(0x4DE6FFE6, 0x66E6FFE6,0x80E6FFE6);
            addColor("background",c);
            addColor("element_background",c);
            c = new ColorScheme.Color(0x80333333, 0x99333333,0xCC333333);
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
    public static class AutumnLeaves extends ColorScheme {
        @Override
        public void pushColor() {
            ColorScheme.Color c = new ColorScheme.Color(0x80A0522D, 0x99A0522D,0xCCA0522D);
            addColor("border",c);
            addColor("element_border",c);
            c = new ColorScheme.Color(0x4DFFEEE0, 0x66FFEEE0,0x80FFEEE0);
            addColor("background",c);
            addColor("element_background",c);
            c = new ColorScheme.Color(0x80401A0A, 0x99401A0A,0xCC401A0A);
            addColor("text",c);
            addColor("element_text",c);
        }
    }
    public static class TwilightPurple extends ColorScheme {
        @Override
        public void pushColor() {
            ColorScheme.Color c = new ColorScheme.Color(0x805E4B8B, 0x995E4B8B,0xCC5E4B8B);
            addColor("border",c);
            addColor("element_border",c);
            c = new ColorScheme.Color(0x4DE3D4F8, 0x66E3D4F8,0x80E3D4F8);
            addColor("background",c);
            addColor("element_background",c);
            c = new ColorScheme.Color(0x803A2E75, 0x993A2E75,0xCC3A2E75);
            addColor("text",c);
            addColor("element_text",c);
        }
    }
}
