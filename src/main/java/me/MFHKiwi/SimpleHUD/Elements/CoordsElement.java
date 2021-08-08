package me.MFHKiwi.SimpleHUD.Elements;

public class CoordsElement extends TextElement {
	
	public String getText() {
		int x = super.mc.player.getBlockX();
		int y = super.mc.player.getBlockY();
		int z = super.mc.player.getBlockZ();
		return "X: " + x + ", Y: " + y + ", Z: " + z; 
	}
}
