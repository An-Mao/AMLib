package anmao.mc.amlib.screen.widget.image;

import anmao.mc.amlib.screen.widget.DT_XYWHUV;
import anmao.mc.amlib.screen.widget.RenderWidgetCore;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class ImageWidgetCore<T extends ImageWidgetCore<T>> extends RenderWidgetCore<T> {
    protected ResourceLocation texture;

    public ImageWidgetCore(int x, int y, int w, int h, Component pMessage) {
        super(x, y, w, h, pMessage);
    }
    public ImageWidgetCore(ResourceLocation texture,int x, int y, int w, int h, Component pMessage) {
        super(x, y, w, h, pMessage);
        setTexture(texture);
    }
    public ResourceLocation getTexture() {
        return texture;
    }
    public T setTexture(ResourceLocation texture) {
        this.texture = texture;
        return self();
    }

    public void drawImage(GuiGraphics guiGraphics, DT_XYWHUV xywhuv){
        guiGraphics.blit(texture,xywhuv.getX(),xywhuv.getY(),xywhuv.getUOffset(),xywhuv.getVOffset(),xywhuv.getWidth(),xywhuv.getHeight());
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        if (this.visible) {
            renderContent(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }
    }
    protected abstract void renderContent(GuiGraphics guiGraphics,int mouseX, int mouseY, float partialTick);
}
