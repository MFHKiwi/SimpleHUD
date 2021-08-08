package me.MFHKiwi.SimpleHUD.Elements;

import net.minecraft.client.MinecraftClient;

public abstract class TextElement {
	protected final MinecraftClient mc = MinecraftClient.getInstance();
	
	public abstract String getText();
	
	public int getWidth() {
		return this.mc.textRenderer.getWidth(getText());
	}
}
