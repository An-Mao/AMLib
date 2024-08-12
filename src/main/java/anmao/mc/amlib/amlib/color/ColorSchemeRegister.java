package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;
import anmao.mc.amlib.AMLib;
import anmao.mc.amlib.amlib.color.scheme.*;
import anmao.mc.net.Net;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class ColorSchemeRegister {
    public static final ResourceLocation KEY =  ResourceLocation.tryBuild(AMLib.MOD_ID, "color_scheme");
    public static final ResourceKey<Registry<ColorScheme>> REGISTRY_KEY = ResourceKey.createRegistryKey(KEY);
    public static final Registry<ColorScheme> REGISTRY = new RegistryBuilder<>(REGISTRY_KEY)
            .sync(true)
            .maxId(256)
            .create();
    @EventBusSubscriber(modid = AMLib.MOD_ID,bus = EventBusSubscriber.Bus.MOD)
    public static class reg{
        @SubscribeEvent
        public static void registerRegistries(NewRegistryEvent event) {
            event.register(REGISTRY);
        }
    }
    public static final DeferredRegister<ColorScheme> COLOR_SCHEME = DeferredRegister.create(REGISTRY, AMLib.MOD_ID);


    public static final DeferredHolder<ColorScheme, ColorSchemeDefault> DEFAULT = reg("default", ColorSchemeDefault::new);

    public static final DeferredHolder<ColorScheme, TwilightPurple> Twilight_Purple = reg("twilight_purple", TwilightPurple::new);
    public static final DeferredHolder<ColorScheme, ColdGray> Cold_Gray = reg("cold_gray", ColdGray::new);
    public static final DeferredHolder<ColorScheme, BlueFresh> Blue_Fresh = reg("blue_fresh", BlueFresh::new);
    public static final DeferredHolder<ColorScheme, NaturalGreenery> Natural_Greenery = reg("natural_greenery", NaturalGreenery::new);
    public static final DeferredHolder<ColorScheme, OceanBreeze> Ocean_Breeze = reg("ocean_breeze", OceanBreeze::new);
    public static final DeferredHolder<ColorScheme, SunsetGlow> Sunset_Glow = reg("sunset_glow", SunsetGlow::new);
    public static final DeferredHolder<ColorScheme, FreshMint> Fresh_Mint = reg("fresh_mint", FreshMint::new);
    public static final DeferredHolder<ColorScheme, AutumnLeaves> Autumn_Leaves = reg("autumn_leaves", AutumnLeaves::new);


    public static final DeferredHolder<ColorScheme, MidnightBlue> Midnight_Blue = reg("midnight_blue", MidnightBlue::new);
    public static final DeferredHolder<ColorScheme, CoralReef> Coral_Reef = reg("coral_reef", CoralReef::new);
    public static final DeferredHolder<ColorScheme, EmeraldGreen> Emerald_Green = reg("emerald_green", EmeraldGreen::new);
    public static final DeferredHolder<ColorScheme, SoftLavender> Soft_Lavender = reg("soft_lavender", SoftLavender::new);
    public static final DeferredHolder<ColorScheme, GoldenSands> Golden_Sands = reg("golden_sands", GoldenSands::new);
    public static final DeferredHolder<ColorScheme, CrimsonTide> Crimson_Tide = reg("crimson_tide", CrimsonTide::new);
    public static final DeferredHolder<ColorScheme, MistyViolet> Misty_Violet = reg("misty_violet", MistyViolet::new);
    public static final DeferredHolder<ColorScheme, TealWhisper> TealWhisper = reg("teal_whisper", TealWhisper::new);
    public static final DeferredHolder<ColorScheme, AmberBlaze> Amber_Blaze = reg("amber_blaze", AmberBlaze::new);
    public static final DeferredHolder<ColorScheme, PeachMelba> Peach_Melba = reg("peach_melba", PeachMelba::new);


    public static void register(IEventBus eventBus){
        COLOR_SCHEME.register(eventBus);
    }

    public static Component getSchemeComponent(ColorScheme colorScheme){
        return Component.translatable(getSchemeKey(colorScheme));
    }

    public static <I extends ColorScheme> DeferredHolder<ColorScheme, I>  reg(String name, Supplier<? extends I> sup) {
        return COLOR_SCHEME.register(name, sup);
    }

    public static String getSchemeKey(ColorScheme colorScheme){
        return "color_scheme."+REGISTRY.getKey(colorScheme).toLanguageKey();
    }
}
