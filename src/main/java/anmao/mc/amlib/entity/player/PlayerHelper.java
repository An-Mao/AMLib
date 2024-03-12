package anmao.mc.amlib.entity.player;

import anmao.mc.amlib.entity.EntityHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class PlayerHelper {
    public static Player getNearPlayer(Entity entity, double radius){
        return EntityHelper.getLevel(entity).getNearestPlayer(entity,radius);
    }
}
