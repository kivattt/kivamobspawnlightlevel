package com.kiva.kivamobspawnlightlevel.server.mixins;

import com.kiva.kivamobspawnlightlevel.KivaMobSpawnLightLevel;
import net.minecraft.src.game.entity.EntityMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EntityMob.class)
public class MixinRenameThis {
    @ModifyArg(method = "getCanSpawnHere", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
    private int changeLightLevelMobsCanSpawnAt(int in){
        return KivaMobSpawnLightLevel.mobSpawnLightLevel;
    }
}
