package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;
import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.color.scheme.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class ColorSchemeRegister {
    public static final ResourceLocation KEY =  ResourceLocation.tryBuild(AMLib.MOD_ID, "color_scheme");
    public static final DeferredRegister<ColorScheme> COLOR_SCHEME = DeferredRegister.create(KEY, AMLib.MOD_ID);
    public static final Supplier<IForgeRegistry<ColorScheme>> REGISTRY = COLOR_SCHEME.makeRegistry(RegistryBuilder::new);


    public static final RegistryObject<ColorScheme> DEFAULT = reg("default", ColorSchemeDefault::new);

    public static final RegistryObject<ColorScheme> Twilight_Purple = reg("twilight_purple", TwilightPurple::new);
    public static final RegistryObject<ColorScheme> Cold_Gray = reg("cold_gray", ColdGray::new);
    public static final RegistryObject<ColorScheme> Blue_Fresh = reg("blue_fresh", BlueFresh::new);
    public static final RegistryObject<ColorScheme> Natural_Greenery = reg("natural_greenery", NaturalGreenery::new);
    public static final RegistryObject<ColorScheme> Ocean_Breeze = reg("ocean_breeze", OceanBreeze::new);
    public static final RegistryObject<ColorScheme> Sunset_Glow = reg("sunset_glow", SunsetGlow::new);
    public static final RegistryObject<ColorScheme> Fresh_Mint = reg("fresh_mint", FreshMint::new);
    public static final RegistryObject<ColorScheme> Autumn_Leaves = reg("autumn_leaves", AutumnLeaves::new);


    public static final RegistryObject<ColorScheme> Midnight_Blue = reg("midnight_blue", MidnightBlue::new);
    public static final RegistryObject<ColorScheme> Coral_Reef = reg("coral_reef", CoralReef::new);
    public static final RegistryObject<ColorScheme> Emerald_Green = reg("emerald_green", EmeraldGreen::new);
    public static final RegistryObject<ColorScheme> Soft_Lavender = reg("soft_lavender", SoftLavender::new);
    public static final RegistryObject<ColorScheme> Golden_Sands = reg("golden_sands", GoldenSands::new);
    public static final RegistryObject<ColorScheme> Crimson_Tide = reg("crimson_tide", CrimsonTide::new);
    public static final RegistryObject<ColorScheme> Misty_Violet = reg("misty_violet", MistyViolet::new);
    public static final RegistryObject<ColorScheme> TealWhisper = reg("teal_whisper", TealWhisper::new);
    public static final RegistryObject<ColorScheme> Amber_Blaze = reg("amber_blaze", AmberBlaze::new);
    public static final RegistryObject<ColorScheme> Peach_Melba = reg("peach_melba", PeachMelba::new);


    public static void register(IEventBus eventBus){
        COLOR_SCHEME.register(eventBus);
    }

    public static Component getSchemeComponent(ColorScheme colorScheme){
        return Component.translatable(getSchemeKey(colorScheme));
    }

    public static RegistryObject<ColorScheme> reg(String name , Function<String , ColorScheme> function){
        return COLOR_SCHEME.register(name, () -> function.apply(name));

    }
    public static RegistryObject<ColorScheme> reg(String name, Supplier<? extends ColorScheme> sup) {
            return COLOR_SCHEME.register(name, sup);

    }

    public static String getSchemeKey(ColorScheme colorScheme){
        return "color_scheme."+REGISTRY.get().getKey(colorScheme).toLanguageKey();
    }
}
