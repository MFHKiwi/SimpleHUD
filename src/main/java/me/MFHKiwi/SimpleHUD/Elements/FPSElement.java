package me.MFHKiwi.SimpleHUD.Elements;

import me.MFHKiwi.SimpleHUD.Mixins.FPSGetterMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

public class FPSElement extends TextElement {
	private MinecraftClient client = MinecraftClient.getInstance();
	private TextRenderer renderer;
	
	public FPSElement(int colour) {
		super("FPS: ", colour);
		this.renderer = this.client.textRenderer;
	}
	
	public String getText() {
		try {
			return super.getText() + ((FPSGetterMixin) this.client).getFps();
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	public int getWidth() {
		return this.renderer.getWidth(getText());
	}
}
