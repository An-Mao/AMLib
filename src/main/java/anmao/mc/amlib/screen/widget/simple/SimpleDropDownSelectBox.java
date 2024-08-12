package anmao.mc.amlib.screen.widget.simple;

import anmao.dev.core.color.ColorHelper;
import anmao.dev.core.color.ColorScheme;
import anmao.dev.core.debug.DeBug;
import anmao.dev.core.math._Math;
import anmao.mc.amlib.amlib.color.ColorSchemes;
import anmao.mc.amlib.screen.widget.DT_ListBoxData;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleDropDownSelectBox extends SimpleWidgetCore<SimpleDropDownSelectBox> {
    private List<DT_ListBoxData> dataList;
    private int nowSelectIndex = -1;
    private boolean showList = false;
    private int line,
            lineHeight,
            linePosY,
            pages,
            nowPage;
    private int usualHeight,usualContentHeight;
    private int backgroundSelectColor,
            textSelectColor;

    public SimpleDropDownSelectBox(int x, int y, int w, int h, Component pMessage, DT_ListBoxData... data) {
        this(x, y, w, h, pMessage,Arrays.asList(data));
    }
    public SimpleDropDownSelectBox(int x, int y, int w, int h,  Component pMessage,List<DT_ListBoxData> data) {
        super(x, y, w, h, pMessage);
        this.dataList = data;
        setUsualHeight(h);
        setLine(7);
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    @Override
    public SimpleDropDownSelectBox setColorScheme(ColorScheme colorScheme) {
        super.setColorScheme(colorScheme);
        setBackgroundSelectColor(colorScheme.getSelectColor("element_background"));
        setTextSelectColor(colorScheme.getSelectColor("element_text"));
        System.out.println("set:"+ ColorHelper.intToHexColor(colorScheme.getSelectColor("element_background")));
        return self();
    }

    public int getBackgroundSelectColor() {
        return backgroundSelectColor;
    }

    public SimpleDropDownSelectBox setBackgroundSelectColor(int backgroundSelectColor) {
        this.backgroundSelectColor = backgroundSelectColor;
        return self();
    }

    public int getTextSelectColor() {
        return textSelectColor;
    }

    public SimpleDropDownSelectBox setTextSelectColor(int textSelectColor) {
        this.textSelectColor = textSelectColor;
        return self();
    }

    @Override
    public SimpleDropDownSelectBox setRadius(int radius) {
        super.setRadius(radius);
        setUsualContentHeight(getUsualHeight() - 2*radius);
        setLine(line);
        return self();
    }

    public int getUsualContentHeight() {
        return usualContentHeight;
    }

    public void setUsualContentHeight(int usualContentHeight) {
        this.usualContentHeight = usualContentHeight;
    }

    public int getUsualHeight() {
        return usualHeight;
    }
    public void setUsualHeight(int usualHeight) {
        this.usualHeight = usualHeight;// - 2 * getRadius();
    }
    public void setDataList(DT_ListBoxData... data) {
        setDataList(Arrays.asList(data));
    }
    public void setDataList(List<DT_ListBoxData> dataList) {
        setNowPage(1);
        nowSelectIndex = -1;
        this.dataList = dataList;
    }
    public @NotNull List<DT_ListBoxData> getDataList() {
        if (dataList == null){
            dataList = new ArrayList<>();
        }
        return dataList;
    }
    public int getPages(int number , int line){
        if (number == 0){
            return 1;
        }
        int n = number / line;
        if (number % line != 0){
            n ++;
        }
        return n;
    }

    public SimpleDropDownSelectBox setLine(int line){
        this.line = line;
        lineHeight = getUsualContentHeight() * line;
        this.linePosY = Math.max(_Math.half (getUsualContentHeight() - font.lineHeight)+1,0);
        this.pages = getPages(getDataList().size(),line);
        setNowPage(1);
        return self();
    }
    public Component getSelectComponent(){
        DT_ListBoxData dropDownListBoxData = getSelectData();
        if (dropDownListBoxData != null){
            return dropDownListBoxData.getComponent();
        }
        return Component.literal("--");
    }
    public Component getComponent(int index){
        DT_ListBoxData dropDownListBoxData = getData(index);
        if (dropDownListBoxData != null){
            return dropDownListBoxData.getComponent();
        }
        return Component.literal("--");
    }
    public List<Component> getDataTooltip(int index){
        DT_ListBoxData dropDownListBoxData = getData(index);
        if (dropDownListBoxData != null){
            return dropDownListBoxData.getTooltip();
        }
        return List.of(Component.literal("--")) ;
    }
    public DT_ListBoxData getSelectData(){
        if (nowSelectIndex >= 0 && nowSelectIndex < dataList.size()){
            return dataList.get(nowSelectIndex);
        }
        return null;
    }
    public DT_ListBoxData getData(int index){
        int i = (getNowPage() - 1) * line + index;
        if (i >= 0 && i < dataList.size()){
            return dataList.get(i);
        }
        return null;
    }
    public Object getSelectValue(){
        if (nowSelectIndex > dataList.size() || nowSelectIndex < 0){
            DeBug.ThrowError("Error Select");
            return null;
        }else {
            return dataList.get(nowSelectIndex).getValue();
        }
    }
    public boolean setSelect(int index){
        if (index > dataList.size() || index < 0){
            return false;
        }
        this.nowSelectIndex = index;
        return true;
    }
    public int getNowSelectIndex(){
        return nowSelectIndex;
    }
    public String FixStrWidth(String s){
        return font.plainSubstrByWidth(s,width);
    }
    public String FixStrWidth(Component s){
        return FixStrWidth(s.getString());
    }
    @Override
    public void onClick(double pMouseX, double pMouseY) {
        super.onClick(pMouseX, pMouseY);
        showList = !showList;
        int np = getNowPage();
        if (showList){
            setHeight(getUsualHeight() + lineHeight);
        }else {
            setHeight(getUsualHeight());
        }
        updateIndex(pMouseY,np);
    }
    public void updateIndex(double mouseY,int  page){
        int i = (int) ((mouseY - getContentY()) / getContentH());
        if (i > 0){
            nowSelectIndex = i - 1;
            nowSelectIndex += (page- 1) * line;
            DT_ListBoxData dropDownListBoxData = getSelectData();
            if (dropDownListBoxData != null) {
                dropDownListBoxData.OnPress(getSelectValue());
            }
        }
    }
    public boolean isInWidget(double pMouseX,double pMouseY){
        return pMouseX > getContentX() && pMouseX < getContentX() + getContentW() && pMouseY > getContentY() && pMouseY < getContentY() + getContentH();
    }
    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double sx,double sy) {
        if (showList) {
            if (isInWidget(pMouseX,pMouseY)) {
                if (sy < 0 && getNowPage() < pages){
                    setNowPage(getNowPage() + 1);
                }else if (sy > 0 && getNowPage() > 1){
                    setNowPage(getNowPage() - 1);
                }
                return true;
            }
        }
        return super.mouseScrolled(pMouseX, pMouseY, sx,sy);

    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        if (showList){
            PoseStack poseStack = pGuiGraphics.pose();
            poseStack.pushPose();
            poseStack.translate(0, 0, 10);
            super.renderWidget(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
            poseStack.popPose();
            return;
        }
        super.renderWidget(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderContent(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        //if (showList)poseStack.translate(0, 0, 10);// else poseStack.translate(0, 0, layerZ);

        //绘制显示框

        Component c = getMessage();
        if (nowSelectIndex > -1 || c.equals(Component.empty())){
            c = getSelectComponent();
        }

        int sx = getContentX() + 1;
        int sy = getContentY();
        guiGraphics.drawString(getFont(),Component.literal(FixStrWidth(c)),sx,sy+linePosY,getTextHoverColor(),false);



        if (showList){
            for (int i = 0; i < line;i++){
                int lineH =  (i+1) * getUsualContentHeight();
                int lineY = getContentY() + lineH;
                Component select = getComponent(i);
                int tc = getTextUsualColor();
                if (mouseX > getContentX() && mouseX < getContentEndX()
                        &&
                        mouseY > lineY && mouseY < lineY + getUsualContentHeight()
                ){
                    tc = getTextSelectColor();
                    guiGraphics.renderTooltip(font,getDataTooltip(i), Optional.empty(),mouseX,mouseY);
                    guiGraphics.fill(getContentX(),  lineY,getContentEndX(), lineY+ getUsualContentHeight(), getBackgroundSelectColor());
                }
                guiGraphics.drawString(getFont(),Component.literal(FixStrWidth(select)),sx,sy+lineH+ linePosY,tc,false);
            }
        }
        poseStack.popPose();
    }
}
