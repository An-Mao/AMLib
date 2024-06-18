package anmao.mc.amlib.mixin;

import anmao.mc.amlib.amlib.config.Configs;
import anmao.mc.amlib.amlib.config.attribute.AttributeData;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RangedAttribute.class)
public class RangedAttributeMixin {
    @Mutable
    @Shadow @Final private double minValue;
    @Mutable
    @Shadow @Final private double maxValue;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void amlib$init$modifyMaxHealth(String pDescriptionId, double pDefaultValue, double pMin, double pMax, CallbackInfo ci) {
        if (Configs.general.getDatas().isMixinAttributes()){
            AttributeData attributeData = Configs.attribute.getConfig(pDescriptionId);
            if (attributeData != null){
                this.minValue = attributeData.getMin();
                this.maxValue = attributeData.getMax();
            }
        }
    }
}
