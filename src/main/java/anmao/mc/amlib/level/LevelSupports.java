package anmao.mc.amlib.level;

import anmao.mc.amlib.server.ServerSupports;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class LevelSupports {
    @Nullable
    public static Level getLevel(ResourceKey<Level> pDimension) {
        Level level = Minecraft.getInstance().level;
        if (level == null) {
            level = ServerSupports.getLevel(ServerLevel.OVERWORLD);
        }
        return level;
    }
}
