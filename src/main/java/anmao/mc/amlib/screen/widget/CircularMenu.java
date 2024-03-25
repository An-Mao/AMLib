package anmao.mc.amlib.screen.widget;

import anmao.mc.amlib.debug.DeBug;
import anmao.mc.amlib.math._Math;
import anmao.mc.amlib.math._MathCDT;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;

import java.awt.*;
import java.util.List;

public class CircularMenu extends RenderWidgetCore {
    protected FlipMode flipMode;
    protected int sectors;
    protected int textNormalColor , textSelectColor;
    protected int innerRadius , outerRadius;
    protected double fanAngle , fanArc;
    protected double fanTextAngle;
    protected List<DT_ListBoxData> data ;
    protected int index = -1;
    protected int startIndex = 0;
    protected int fanTextInnerSpace;
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
                    DT_ListBoxData boxData = getData(sIndex);
                    drawName(guiGraphics,fanAngle * i,centerX,centerY,boxData.getComponent().getString(),tc);
                    /*
                    PoseStack pose = guiGraphics.pose();
                    pose.pushPose();
                    double rad = fanAngle * i;
                    double[] xyc = getArcCenter(getFanTextInnerSpace(),startAngle,fanAngle);
                    System.out.println("xyc::"+ Arrays.toString(xyc));
                    pose.translate(xyc[0],xyc[1],0);

                    pose.translate(centerX,centerY,0);
                    double theta = Math.toRadians(rad);
                    double cx = getFanTextInnerSpace() * Math.cos(theta);
                    double cy = getFanTextInnerSpace() * Math.sin(theta);
                    pose.translate(cx,cy,0);
                    pose.mulPose(Axis.ZP.rotationDegrees((float) rad ));
                    pose.mulPose(Axis.ZP.rotationDegrees((float) fanTextAngle));
                    DT_ListBoxData boxData = getData(sIndex);
                    String st = boxData.getComponent().getString();
                    st =font.plainSubstrByWidth(st,outerRadius - getFanTextInnerSpace());
                    guiGraphics.drawString(font, st, 0, 0, tc,false);
                    pose.popPose();
                     */

                }
            }
        }
    }
    protected void drawName(GuiGraphics guiGraphics, double rad, int centerX, int centerY, String name, int color){
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate(centerX,centerY,0);
        double theta = Math.toRadians(rad);
        double cx = getFanTextInnerSpace() * Math.cos(theta);
        double cy = getFanTextInnerSpace() * Math.sin(theta);
        pose.translate(cx,cy,0);
        pose.mulPose(Axis.ZP.rotationDegrees((float) rad ));
        pose.mulPose(Axis.ZP.rotationDegrees((float) fanTextAngle));

        name =font.plainSubstrByWidth(name,outerRadius - getFanTextInnerSpace());
        guiGraphics.drawString(font, name, 0, 0, color,false);
        pose.popPose();
    }
    protected double getArc(double angleDegrees,double radius){
        return (angleDegrees / 360.0) * (2 * Math.PI * radius);
    }
    protected double[] getArcCenter(double radius,double theta,double alpha){
        double x1 = radius * Math.cos(theta);
        double y1 = radius * Math.sin(theta);
        double x2 = radius * Math.cos(theta + alpha);
        double y2 = radius * Math.sin(theta + alpha);
        double xm = (x1 + x2) / 2;
        double ym = (y1 + y2) / 2;
        double xc = xm + radius * Math.sin(alpha / 2) * Math.cos(theta + alpha / 2);
        double yc = ym + radius * Math.sin(alpha / 2) * Math.sin(theta + alpha / 2);
        /*
        System.out.println("弧的起点坐标：(" + x1 + ", " + y1 + ")");
        System.out.println("弧的中点坐标：(" + xm + ", " + ym + ")");
        System.out.println("弧的终点坐标：(" + x2 + ", " + y2 + ")");
        System.out.println("弧的中心点坐标：(" + xc + ", " + yc + ")");
         */
        return new double[]{xc,yc};
    }
    protected double getTextAngle(double b,double h){
        double tanTheta = (b / 2) / h;
        double theta = Math.atan(tanTheta);
        double degreesTheta = Math.toDegrees(theta);
        return 180 - 2 * degreesTheta;
    }
    protected void drawSector(int centerX, int centerY, double startAngle, double endAngle, int color) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.getBuilder();
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        buffer.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
        for (double angle = startAngle; angle <= endAngle - _MathCDT.ARC; angle += _MathCDT.ARC) {
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
