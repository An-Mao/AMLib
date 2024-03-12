package anmao.mc.amlib.mixin;

import anmao.mc.amlib.amlib.config.Configs;
import anmao.mc.amlib.amlib.the$world.TheWorld;
import anmao.mc.amlib.entity.EntityHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityTickList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.function.Consumer;

@Mixin(EntityTickList.class)
public class EntityTickListMixin {
    @Shadow
    private Int2ObjectMap<Entity> active;
    @Shadow
    @Nullable
    private Int2ObjectMap<Entity> iterated;
    /**
     * @author AnMao
     * @reason The World
     */
    @Overwrite
    public void forEach(Consumer<Entity> pEntity) {
        if (this.iterated != null) {
            throw new UnsupportedOperationException("Only one concurrent iteration supported");
        } else {
            this.iterated = this.active;

            try {
                for(Entity entity : this.active.values()) {
                    if (Configs.theWorld.getDatas().isEnable()) {
                        if (TheWorld.GetTheWorldState(entity)) {
                            int time = TheWorld.GetTheWorldTime(entity);
                            if (Configs.theWorld.getDatas().getType() == 1) {
                                if (EntityHelper.getLevelTime(entity) - time < Configs.theWorld.getDatas().getStopTime()) {
                                    continue;
                                }
                            } else if (Configs.theWorld.getDatas().getType() == 2) {
                                if (time < Configs.theWorld.getDatas().getStopTime()) {
                                    TheWorld.SetTheWorldTime(entity,time+1);
                                    continue;
                                }
                            }
                            TheWorld.SetTheWorldState(entity,false);
                        }
                    }
                    pEntity.accept(entity);
                }
            } finally {
                this.iterated = null;
            }

        }
    }
}
