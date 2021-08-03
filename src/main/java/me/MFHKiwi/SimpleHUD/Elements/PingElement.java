package me.MFHKiwi.SimpleHUD.Elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;

public class PingElement extends TextElement {

	public PingElement(int colour) {
		super("", colour);
	}
	
	public String getText() {
		MinecraftClient mc = MinecraftClient.getInstance();
		PlayerListEntry entry = mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid());
		if (entry == null) return "Ping: " + 0 + "ms";
		if (mc.isInSingleplayer() && !mc.getNetworkHandler().getConnection().isEncrypted()) return "Ping: " + 0 + "ms";
		return "Ping: " + entry.getLatency() + "ms";
	}
}
