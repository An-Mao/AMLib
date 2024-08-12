package anmao.mc.amlib.amlib.color;

import anmao.dev.core.color.ColorScheme;
import anmao.dev.core.color.ColorSchemes;
import anmao.mc.amlib.AMLib;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ColorSchemeRegister {
    public static final ResourceLocation KEY =  ResourceLocation.tryBuild(AMLib.MOD_ID, "enchant");
    public static final DeferredRegister<ColorScheme> COLOR_SCHEME_DEFERRED_REGISTER = DeferredRegister.create(KEY, AMLib.MOD_ID);
    public static final Supplier<IForgeRegistry<ColorScheme>> REGISTRY = COLOR_SCHEME_DEFERRED_REGISTER.makeRegistry(RegistryBuilder::new);
    public static RegistryObject<ColorScheme> DEFAULT = COLOR_SCHEME_DEFERRED_REGISTER.register("default", ColorSchemeDefault.Default::new);
    public static RegistryObject<ColorScheme> ColdGray = COLOR_SCHEME_DEFERRED_REGISTER.register("cold_gray", ColorSchemeDefault.ColdGray::new);
    public static RegistryObject<ColorScheme> BlueFresh = COLOR_SCHEME_DEFERRED_REGISTER.register("blue_fresh", ColorSchemeDefault.BlueFresh::new);
    public static RegistryObject<ColorScheme> NaturalGreenery = COLOR_SCHEME_DEFERRED_REGISTER.register("natural_greenery", ColorSchemeDefault.NaturalGreenery::new);
    public static RegistryObject<ColorScheme> OceanBreeze = COLOR_SCHEME_DEFERRED_REGISTER.register("ocean_breeze", ColorSchemeDefault.OceanBreeze::new);
    public static RegistryObject<ColorScheme> SunsetGlow = COLOR_SCHEME_DEFERRED_REGISTER.register("sunset_glow", ColorSchemeDefault.SunsetGlow::new);
    public static RegistryObject<ColorScheme> FreshMint = COLOR_SCHEME_DEFERRED_REGISTER.register("fresh_mint", ColorSchemeDefault.FreshMint::new);
    public static RegistryObject<ColorScheme> AutumnLeaves = COLOR_SCHEME_DEFERRED_REGISTER.register("autumn_leaves", ColorSchemeDefault.AutumnLeaves::new);
    public static RegistryObject<ColorScheme> TwilightPurple = COLOR_SCHEME_DEFERRED_REGISTER.register("twilight_purple", ColorSchemeDefault.TwilightPurple::new);

    public static void register(IEventBus eventBus){
        COLOR_SCHEME_DEFERRED_REGISTER.register(eventBus);
    }
}
