package me.MFHKiwi.SimpleHUD.Elements;

import me.MFHKiwi.SimpleHUD.Mixins.FPSGetterMixin;

public class FPSElement extends TextElement {
		
	public FPSElement(int colour) {
		super("FPS: ", colour);
	}
	
	public String getText() {
		try {
			return super.getText() + ((FPSGetterMixin) super.mc).getFps();
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}
