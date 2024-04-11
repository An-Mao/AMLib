package anmao.mc.amlib.screen.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class SquareImageButton extends RenderWidgetCore {
    private final OnPress onPress;
    protected int textUsualColor, textSelectColor;
    private  int dx = getX()+width/2;
    private  int dy = getY()+height/ 2 - font.lineHeight/2;
    public SquareImageButton(Font font, DT_XYWH dt_xywh, Component pMessage, OnPress onPress) {
        super(dt_xywh, pMessage);
        this.onPress = onPress;
        this.font = font;
    }
    public SquareImageButton(DT_XYWH dt_xywh, Component pMessage, OnPress onPress) {
        this(Minecraft.getInstance().font,dt_xywh,pMessage,onPress);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    public void setTextSelectColor(int textSelectColor) {
        this.textSelectColor = textSelectColor;
    }

    public void setTextUsualColor(int textUsualColor) {
        this.textUsualColor = textUsualColor;
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
                pGuiGraphics.setColor(1.0f,1.0f,1.0f,1.0f);
                pGuiGraphics.drawCenteredString(font,getMessage(),dx,dy,textSelectColor);
                //drawString(pGuiGraphics,getX() ,getY(),textSelectColor,getMessage());
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
                pGuiGraphics.setColor(1.0f,1.0f,1.0f,1.0f);
                pGuiGraphics.drawCenteredString(font,getMessage(),dx,dy,textUsualColor);
                //drawString(pGuiGraphics,getX(),getY(),textUsualColor,getMessage());
            }
        }
    }
}
