package me.MFHKiwi.SimpleHUD.Mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public interface FPSGetterMixin {
	@Accessor("currentFps")
	public abstract int getFps();
}
