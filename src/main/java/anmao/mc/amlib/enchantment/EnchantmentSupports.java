package anmao.mc.amlib.enchantment;

import anmao.mc.amlib.server.ServerSupports;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EnchantmentSupports {
    public static Registry<Enchantment> getRegistry() {
        return ServerSupports.getOverworldLevel().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
    }
    public static Registry<Enchantment> getRegistry(Level level) {
        return level.registryAccess().registryOrThrow(Registries.ENCHANTMENT);
    }
    public static @Nullable Holder<Enchantment> getHolder(Registry<Enchantment> registry, ResourceLocation res) {
        return registry.getHolder(res).isPresent() ? registry.getHolder(res).get() : null;
    }
    public static ItemEnchantments getBookEnchantments(ItemStack itemStack) {
        return itemStack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
    }
    public static ItemEnchantments getItemEnchantments(ItemStack itemStack) {
        if (itemStack.is(Items.ENCHANTED_BOOK)){
            return getBookEnchantments(itemStack);
        }
        return itemStack.getEnchantments();
    }
    public static Component getEnchantmentDescString(Holder<Enchantment> pEnchantment) {
        MutableComponent mutablecomponent = pEnchantment.value().description().copy();
        if (pEnchantment.is(EnchantmentTags.CURSE)) {
            ComponentUtils.mergeStyles(mutablecomponent, Style.EMPTY.withColor(ChatFormatting.RED));
        } else {
            ComponentUtils.mergeStyles(mutablecomponent, Style.EMPTY.withColor(ChatFormatting.GRAY));
        }
        return mutablecomponent;
    }
}
