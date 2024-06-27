package anmao.mc.amlib.mc.register;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class Reg<T> {
    private final DeferredRegister<T> dr;
    private final Supplier<IForgeRegistry<T>> REGISTRY ;
    public Reg(ResourceKey<? extends Registry<T>> key, String modid) {
        dr = DeferredRegister.create(key,modid);
        REGISTRY = dr.makeRegistry(RegistryBuilder::new);
    }
    public Reg(IForgeRegistry<T> reg, String modid) {
        dr = DeferredRegister.create(reg.getRegistryKey(),modid);
        REGISTRY = dr.makeRegistry(RegistryBuilder::new);
    }
    public Reg(ResourceLocation registryName, String modid) {
        dr = DeferredRegister.create(registryName,modid);
        REGISTRY = dr.makeRegistry(RegistryBuilder::new);
    }
    public Reg(String registryName, String modid) {
        this(ResourceLocation.tryBuild(modid,registryName),modid);
    }
    public IForgeRegistry<T> getRegistry() {
        return REGISTRY.get();
    }
    public RegistryObject<T> register(String name, Supplier<T> supplier) {
        return dr.register(name, supplier);
    }
    public RegistryObject<T> register(String name , Function<String , T> function){
        return register(name, () -> function.apply(name));
    }




    public void register(IEventBus eventBus){
        dr.register(eventBus);
    }
}
