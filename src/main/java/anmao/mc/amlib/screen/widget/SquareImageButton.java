package anmao.mc.amlib.screen.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class SquareImageButton extends RenderWidgetCore {
    private final OnPress onPress;
    public SquareImageButton(Font font, DT_XYWH dt_xywh, Component pMessage, OnPress onPress) {
        super(dt_xywh, pMessage);
        this.onPress = onPress;
        this.font = font;
    }
    public SquareImageButton(DT_XYWH dt_xywh, Component pMessage, OnPress onPress) {
        this(Minecraft.getInstance().font,dt_xywh,pMessage,onPress);
    }
    @Override
    public void onClick(double pMouseX, double pMouseY) {
        this.onPress.onPress();
    }

    @Override
    protected void renderWidget(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        if (isMouseOver(pMouseX,pMouseY)){
            if (texture != null){
                DT_XYWHUV dt_xywhuv = bgSelect;
                if (dt_xywhuv != null) {
                    drawImage(pGuiGraphics,dt_xywhuv);
                }
            }else {
                drawSquare(pGuiGraphics,bgSelectColor);
                drawString(pGuiGraphics,getX() ,getY(),0x000000,getMessage());
            }
            pGuiGraphics.renderTooltip(font,getMessage(),pMouseX,pMouseY);
        }else {
            if (texture != null) {
                DT_XYWHUV dt_xywhuv = bgNormal;
                if (dt_xywhuv != null) {
                    drawImage(pGuiGraphics,dt_xywhuv);
                }
            }else {
                drawSquare(pGuiGraphics,bgUsualColor);
                drawString(pGuiGraphics,getX(),getY(),0x000000,getMessage());
            }
        }
    }
}
