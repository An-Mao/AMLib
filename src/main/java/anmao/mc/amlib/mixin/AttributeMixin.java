package anmao.mc.amlib.mixin;

import anmao.mc.amlib.amlib.config.Config;
import anmao.mc.amlib.amlib.config.attribute.AttributeConfig;
import anmao.mc.amlib.amlib.config.attribute.AttributeData;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Attribute.class)
public class AttributeMixin {
    @Mutable
    @Shadow @Final private double defaultValue;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void amlib$init$fix(String pDescriptionId, double pDefaultValue, CallbackInfo ci) {
        if (Config.config.isMixinAttributes()){
            AttributeData attributeData = AttributeConfig.config.get(pDescriptionId);
            if (attributeData != null) {
                this.defaultValue = attributeData.getDef();
            }
        }
    }
}
