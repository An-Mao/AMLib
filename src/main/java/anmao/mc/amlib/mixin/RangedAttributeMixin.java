package anmao.mc.amlib.mixin;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RangedAttribute.class)
public class RangedAttributeMixin {
    @Mutable
    @Final
    @Shadow
    private double maxValue;
    @Inject(method = "<init>", at = @At("RETURN"))
    private void amlib$init$modifyMaxHealth(String pDescriptionId, double pDefaultValue, double pMin, double pMax, CallbackInfo ci) {
        if (pDescriptionId.equals("attribute.name.generic.max_health") || pDescriptionId.equals("attribute.name.generic.attack_damage") || pDescriptionId.equals("attribute.name.generic.armor") || pDescriptionId.equals("attribute.name.generic.armor_toughness")) {
            this.maxValue = Double.MAX_VALUE;
        }
    }
}
