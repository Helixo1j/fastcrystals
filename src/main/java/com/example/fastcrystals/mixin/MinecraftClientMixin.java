package com.example.fastcrystals.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow private int itemUseCooldown;
    @Shadow public ClientPlayerEntity player;

    // Vanilla forces a 4-tick wait between right-click uses.
    // Zero it out every tick while holding an end crystal.
    @Inject(method = "tick", at = @At("HEAD"))
    private void fastcrystals$noUseDelay(CallbackInfo ci) {
        if (player == null) return;
        if (player.getMainHandStack().isOf(Items.END_CRYSTAL)
                || player.getOffHandStack().isOf(Items.END_CRYSTAL)) {
            this.itemUseCooldown = 0;
        }
    }
}
