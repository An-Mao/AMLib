package anmao.mc.amlib.amlib.network.tip$gui;

import anmao.mc.amlib.amlib.gui.TipGui;
import anmao.mc.amlib.amlib.network.easy_net.EasyNet;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TipGuiNetSTC extends EasyNet {
    @Override
    public void client(Supplier<NetworkEvent.Context> contextSupplier, CompoundTag dat) {
        TipGui.addMsg(dat.getString("msg"),dat.getLong("time"));
    }
}
