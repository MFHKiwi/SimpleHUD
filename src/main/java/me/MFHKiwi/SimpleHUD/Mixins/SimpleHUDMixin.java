package me.MFHKiwi.SimpleHUD.Mixins;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.gen.Accessor;

import me.MFHKiwi.SimpleHUD.Elements.CoordsElement;
import me.MFHKiwi.SimpleHUD.Elements.FPSElement;
import me.MFHKiwi.SimpleHUD.Elements.PingElement;
import me.MFHKiwi.SimpleHUD.Elements.TextElement;
import me.MFHKiwi.SimpleHUD.MainMixinAccessor;
import me.MFHKiwi.SimpleHUD.RenderMixinAccessor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;

@Mixin(MinecraftClient.class)
public abstract class SimpleHUDMixin implements MainMixinAccessor {
	// This is actually just the initialisation of the mod. I couldn't make a proper entrypoint, as MinecraftClient.getInstance() is null on init.

	@Inject(method = "<init>", at = @At("TAIL"))
	private void onInject(RunArgs args, CallbackInfo ci) {
		MinecraftClient mc = MinecraftClient.getInstance();
		System.out.println("SimpleHUD");
		List <TextElement> elements = new ArrayList<TextElement>();
		elements.add(new FPSElement());
		elements.add(new CoordsElement());
		elements.add(new PingElement());
		((RenderMixinAccessor) mc.inGameHud).setElements(elements);
	}

	@Accessor("currentFps")
	public abstract int getFps();
}
