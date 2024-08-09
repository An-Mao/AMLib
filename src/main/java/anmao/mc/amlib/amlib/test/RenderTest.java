package anmao.mc.amlib.amlib.test;

import anmao.mc.amlib.AMLib;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = AMLib.MOD_ID)
public class RenderTest {
    /*
    public static void onHurt(LivingHurtEvent event){
        if (event.getEntity() instanceof ServerPlayer serverPlayer){
            List<String> list  = new ArrayList<>();
            serverPlayer.getMainHandItem().getEnchantments().keySet().forEach(enchantmentHolder -> list.add(enchantmentHolder.getRegisteredName()));
            Registry<Enchantment> reg = serverPlayer.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
            list.forEach(s -> {
                System.out.println(s);
                Optional<Holder.Reference<Enchantment>> enchantment = reg.getHolder(ResourceLocation.parse(s));
                enchantment.ifPresent(enchantmentReference -> System.out.println(enchantmentReference.get().getMaxLevel()));
            });
        }
    }

     */
}
