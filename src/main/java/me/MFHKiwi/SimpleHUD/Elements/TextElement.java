package me.MFHKiwi.SimpleHUD.Elements;

import net.minecraft.client.MinecraftClient;

public class TextElement {
	protected final MinecraftClient mc = MinecraftClient.getInstance();
	private final String text;
	private final int colour;
	
	public TextElement(String text, int colour) {
		this.text = text;
		this.colour = colour;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getColour() {
		return this.colour;
	}
	
	public int getWidth() {
		return this.mc.textRenderer.getWidth(getText());
	}
}
