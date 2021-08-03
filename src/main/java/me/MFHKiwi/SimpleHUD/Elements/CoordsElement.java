package me.MFHKiwi.SimpleHUD.Elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

public class CoordsElement extends TextElement {
	private final MinecraftClient mc = MinecraftClient.getInstance();

	public CoordsElement(int colour) {
		super("", colour);
	}
	
	public String getText() {
		int x = this.mc.player.getBlockX();
		int y = this.mc.player.getBlockY();
		int z = this.mc.player.getBlockZ();
		return "X: " + x + ", Y: " + y + ", Z: " + z; 
	}
	
	public int getWidth() {
		TextRenderer renderer = mc.textRenderer;
		return renderer.getWidth(getText());
	}

}
