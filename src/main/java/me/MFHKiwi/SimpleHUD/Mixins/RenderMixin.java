package me.MFHKiwi.SimpleHUD.Mixins;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.MFHKiwi.SimpleHUD.RenderMixinAccessor;
import me.MFHKiwi.SimpleHUD.Elements.TextElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public class RenderMixin implements RenderMixinAccessor {
	private final MinecraftClient mc = MinecraftClient.getInstance();
	private List <TextElement> elements = new ArrayList<TextElement>();
	
	@Inject(method = "renderHotbar", at = @At("TAIL"))
	private void onInject(float tickDelta, MatrixStack stack, CallbackInfo info) {
		if (this.elements.isEmpty()) return;
		for (TextElement element : this.elements) {
			renderElement(element, stack, this.mc.textRenderer.fontHeight * this.elements.indexOf(element), 14737632);
		}
	}
	
	public void setElements(List<TextElement> elements) {
		this.elements = elements;
	}
	
	private void renderElement(TextElement element, MatrixStack stack, int y, int colour) {
		y += (this.mc.player.getStatusEffects().isEmpty()) ? 1 : 26;
		this.mc.textRenderer.drawWithShadow(stack, element.getText(), mc.getWindow().getScaledWidth() - element.getWidth(), y, colour);
	}
}
