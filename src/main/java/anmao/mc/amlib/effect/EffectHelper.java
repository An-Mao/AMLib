package anmao.mc.amlib.effect;

import anmao.mc.amlib.math._Random;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class EffectHelper {
    private static List<MobEffect> DeBuff = null;
    private static int DeBuffNumber = 0;

    public static IForgeRegistry<MobEffect> getRegister(){
        return ForgeRegistries.MOB_EFFECTS;
    }
    public static List<MobEffect> getDeBuffs(){
        if (DeBuff == null) {
            DeBuff = new ArrayList<>();
            getRegister().forEach(mobEffect -> {
                if (!mobEffect.isBeneficial()){
                    DeBuff.add(mobEffect);
                }
            });
            DeBuffNumber = DeBuff.size() - 1;
        }
        return DeBuff;
    }
    public static MobEffect getRandomDeBuff(){
        return getDeBuffs().get(_Random.getIntRandomNumber(0,DeBuffNumber));
    }
    public static MobEffectInstance getDeBuffInstance(int time, int lvl){
        return new MobEffectInstance(Holder.direct(getRandomDeBuff()),time,lvl);
    }
}
