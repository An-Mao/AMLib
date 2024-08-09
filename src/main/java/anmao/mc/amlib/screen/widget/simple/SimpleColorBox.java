package anmao.mc.amlib.screen.widget.simple;

import anmao.dev.core.color.ColorHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class SimpleColorBox extends SimpleWidgetCore<SimpleColorBox> {
    private int showColor;
    public SimpleColorBox(int x, int y, int w, int h, Component pMessage) {
        super(x, y, w, h, pMessage);
    }
    public SimpleColorBox setShowColor(String showColor) {
        this.showColor = ColorHelper.HexToColor(showColor);
        return self();
    }
    public SimpleColorBox setShowColor(int showColor) {
        this.showColor = showColor;
        return self();
    }

    public int getShowColor() {
        return showColor;
    }

    @Override
    protected void renderContent(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        guiGraphics.fill(getContentX(), getContentY(), getContentEndX(), getContentEndY(), getShowColor());
    }

}
