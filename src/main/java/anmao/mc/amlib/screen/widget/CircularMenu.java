package anmao.mc.amlib.screen.widget;

import anmao.mc.amlib.debug.DeBug;
import anmao.mc.amlib.math._Math;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import org.joml.AxisAngle4d;
import org.joml.Quaternionf;

import java.awt.*;
import java.util.List;

public class CircularMenu extends RenderWidgetCore {
    private FlipMode flipMode;
    private int sectors;
    private int textNormalColor , textSelectColor;
    private int innerRadius , outerRadius;
    private double addAngle;
    private double fanAngle , fanArc;
    private double fanTextAngle;
    private List<DT_ListBoxData> data ;
    private int index = -1;
    private int startIndex = 0;
    private int fanTextInnerSpace;
    public CircularMenu(int x, int y, int w, int h, Component message, DT_ListBoxData... data) {
        this(x, y, w, h,message, List.of(data));
    }
    public CircularMenu(int x, int y, int w, int h, Component message, List<DT_ListBoxData> data) {
        this(x, y, w, h,9,20,80, message,data);
    }
    public CircularMenu(int x, int y, int w, int h, int sectors, int innerRadius, int outerRadius, Component message, DT_ListBoxData... data) {
        this(x,y,w,h,sectors,innerRadius,outerRadius,message, List.of(data));
    }
    public CircularMenu(int x, int y, int w, int h, int sectors, int innerRadius, int outerRadius, Component message, List<DT_ListBoxData> data) {
        this(x,y,w,h,sectors,innerRadius,outerRadius,0x50646464,0x50898989,message,data);
    }
    public CircularMenu(int x, int y, int w, int h, int sectors, int innerRadius, int outerRadius, int highlightColor, int normalColor, Component message, DT_ListBoxData... data) {
        this(x,y,w,h,sectors,innerRadius,outerRadius,highlightColor,normalColor,message,List.of(data));
    }
    public CircularMenu(int x, int y, int w, int h, int sectors, int innerRadius, int outerRadius, int highlightColor, int normalColor, Component message, List<DT_ListBoxData> data) {
        super(x, y, w, h, message);
        if (sectors < 1){
            DeBug.ThrowError("error sectors");
        }
        setData(data);
        setSectors(sectors);
        setInnerRadius(innerRadius);
        setOuterRadius(outerRadius);
        setBgSelectColor(highlightColor);
        setBgUsualColor(normalColor);
        setTextNormalColor(Color.green.getRGB());
        setTextSelectColor(Color.YELLOW.getRGB());
        setFlipMode(FlipMode.tire);
        setAddAngle(Math.PI /  180);
        setFanTextInnerSpace(10);
    }

    public void setData(List<DT_ListBoxData> data) {
        this.data = data;
    }

    public void setFanTextInnerSpace(int fanTextInnerSpace) {
        this.fanTextInnerSpace = fanTextInnerSpace;
    }

    public void setFlipMode(FlipMode flipMode) {
        this.flipMode = flipMode;
    }

    public void setTextNormalColor(int textNormalColor) {
        this.textNormalColor = textNormalColor;
    }

    public void setTextSelectColor(int textSelectColor) {
        this.textSelectColor = textSelectColor;
    }

    public void setFanArc(double fanArc) {
        this.fanArc = fanArc;
    }

    public void setFanTextAngle(double fanTextAngle) {
        this.fanTextAngle = fanTextAngle;
    }

    public int getFanTextInnerSpace() {
        return Math.max(fanTextInnerSpace,innerRadius);
    }

    public void setFanAngle(double fanAngle) {
        this.fanAngle = fanAngle;
        //setFanTextAngle(fanAngle / 2 - getTextAngle(font.lineHeight / 2d,getFanTextInnerSpace()));
        setFanTextAngle(fanAngle / 2d);
    }

    public void setAddAngle(double addAngle) {
        this.addAngle = addAngle;
    }

    public void setOuterRadius(int outerRadius) {
        this.outerRadius = outerRadius;
    }

    public void setSectors(int sectors) {
        this.sectors = sectors;
        setFanAngle(360d / sectors);
        setFanArc(_Math.TWICE_PI / sectors);
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }
    public DT_ListBoxData getData(){
        return getData(index);
    }
    public DT_ListBoxData getData(int index){
        if (isValidIndex(index)){
            return data.get(index);
        }
        return null;
    }
    public boolean isValidIndex(){
        return isValidIndex(index);
    }
    public boolean isValidIndex(int index){
        return index >= 0 && index < data.size();
    }
    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        System.out.println("button:"+pButton);
        if (this.active && this.visible && this.flipMode == FlipMode.button) {
            if (pButton == 0){
                if (startIndex >= sectors){
                    startIndex -= sectors;
                    return true ;
                }
            }else if (pButton == 1){
                if (data.size() > startIndex + sectors){
                    startIndex += sectors;
                    return true ;
                }
            }
            return false;
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        if (flipMode == FlipMode.tire){
            DT_ListBoxData dtListBoxData = getData();
            if (dtListBoxData != null){
                dtListBoxData.OnPress(dtListBoxData.getValue());
            }
        }
        super.onClick(pMouseX, pMouseY);
    }

    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta) {
        if (this.flipMode == FlipMode.tire){
            if (pDelta > 0){
                if (startIndex >= sectors){
                    startIndex -= sectors;
                    return true ;
                }
            }else{
                if (data.size() > startIndex + sectors){
                    startIndex += sectors;
                    return true ;
                }
            }
            return false;
        }
        return super.mouseScrolled(pMouseX, pMouseY, pDelta);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float v) {
        if (visible){
            int centerX = getX() , centerY = getY();
            double angle = Math.atan2(mouseY - centerY, mouseX - centerX);
            if (angle < 0) {
                angle += _Math.TWICE_PI;
            }
            for (int i = 0; i < sectors; i++) {
                int sIndex = startIndex + i;
                double startAngle = i * fanArc;
                double endAngle = (i + 1) * fanArc;

                int bgc = bgUsualColor , tc = textNormalColor;
                if (angle >= startAngle && angle < endAngle) {
                    bgc = bgSelectColor;
                    tc = textSelectColor;
                    this.index = sIndex;
                }

                drawSector(centerX,centerY,startAngle,endAngle,bgc);

                if (isValidIndex(sIndex)) {
                    PoseStack pose = guiGraphics.pose();
                    pose.pushPose();
                    //double rad = fanAngle * (i + 2)  + fanTextAngle;

                    //当前扇形起始角度
                    double rad = fanAngle * i;
                    //移动至中心
                    pose.translate(centerX,centerY,0);
                    //计算文本位置
                    double theta = Math.toRadians(rad);
                    double cx = getFanTextInnerSpace() * Math.cos(theta);
                    double cy = getFanTextInnerSpace() * Math.sin(theta);
                    //移动文本渲染位置
                    pose.translate(cx,cy,0);
                    // 旋转至对应角度
                    pose.mulPose(Axis.ZP.rotationDegrees((float) rad));

                    // 半个扇形的角度
                    pose.mulPose(Axis.ZP.rotationDegrees((float) fanTextAngle));
                    // 文本高为低，等腰三角形的角度
                    //pose.mulPose(Axis.ZP.rotationDegrees((float) -getTextAngle(font.lineHeight,getFanTextInnerSpace())));

                    //pose.mulPose(new Quaternionf(new AxisAngle4d(Math.toRadians(rad),0,0,1)));
                    //pose.translate(getFanTextInnerSpace(),0,0);
                    //pose.mulPose(new Quaternionf(new AxisAngle4d(Math.toRadians(fanAngle / font.lineHeight),0,0,1)));
                    DT_ListBoxData boxData = getData(sIndex);
                    String st = boxData.getComponent().getString();
                    st =font.plainSubstrByWidth(st,outerRadius - getFanTextInnerSpace());
                    guiGraphics.drawString(font, st, 0, 0, tc,false);
                    pose.popPose();
                }
            }
        }
    }
    private double getTextAngle(double b,double h){
        double tanTheta = (b / 2) / h;
        double theta = Math.atan(tanTheta);
        double degreesTheta = Math.toDegrees(theta);
        return 180 - 2 * degreesTheta;
    }
    private void drawSector(int centerX, int centerY, double startAngle, double endAngle, int color) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.getBuilder();
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        buffer.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
        for (double angle = startAngle; angle <= endAngle - addAngle; angle += addAngle) {
            double x2 = centerX + Math.cos(angle) * outerRadius;
            double y2 = centerY + Math.sin(angle) * outerRadius;
            buffer.vertex(x2, y2, 0).color(color).endVertex();
            double x1 = centerX + Math.cos(angle) * innerRadius;
            double y1 = centerY + Math.sin(angle) * innerRadius;
            buffer.vertex(x1, y1, 0).color(color).endVertex();

        }
        tesselator.end();
    }
    public enum  FlipMode{
        tire,
        button
    }
}
