package me.MFHKiwi.SimpleHUD.Elements;

import net.minecraft.client.network.PlayerListEntry;

public class PingElement extends TextElement {

	public PingElement(int colour) {
		super("", colour);
	}
	
	public String getText() {
		PlayerListEntry entry = super.mc.getNetworkHandler().getPlayerListEntry(super.mc.player.getUuid());
		if (entry == null) return "Ping: " + 0 + "ms";
		if (super.mc.isInSingleplayer() && !super.mc.getNetworkHandler().getConnection().isEncrypted()) return "Ping: " + 0 + "ms";
		return "Ping: " + entry.getLatency() + "ms";
	}
}
