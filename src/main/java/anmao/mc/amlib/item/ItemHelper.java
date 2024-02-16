package anmao.mc.amlib.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.Objects;

public class ItemHelper {
    public static Item getItem(String id){
        if (Objects.equals(id, "")){
            return null;
        }
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
    }
    public static double getMainItemDamage(LivingEntity livingEntity){
        return getItemDamage(livingEntity.getMainHandItem());
    }
    public static double getItemDamage(ItemStack itemStack){
        double damage;
        Collection<AttributeModifier> atk = itemStack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
        damage = getAttributeModifierDamage(atk);
        return damage;
    }
    public static double getAttributeModifierDamage(Collection<AttributeModifier> attlist) {
        double dadd = 0;
        double dbase = 0;
        double dtotal = 1;
        for (AttributeModifier al : attlist) {
            if(al.getOperation() == AttributeModifier.Operation.ADDITION){
                dadd += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE) {
                dbase += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                dtotal *= 1.0D + al.getAmount();
            }
        }
        return (dadd + dadd * dbase) * dtotal;
    }


    public static boolean hasEnchant(ItemStack itemStack, Enchantment enchantment){
        return itemStack.getEnchantmentLevel(enchantment) > 0;
    }
}
