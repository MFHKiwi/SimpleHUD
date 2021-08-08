package me.MFHKiwi.SimpleHUD.Elements;

import me.MFHKiwi.SimpleHUD.MainMixinAccessor;

public class FPSElement extends TextElement {
	
	public String getText() {
		try {
			return "FPS: " + ((MainMixinAccessor) super.mc).getFps();
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}
