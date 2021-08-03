package me.MFHKiwi.SimpleHUD;

import java.util.List;

import me.MFHKiwi.SimpleHUD.Elements.TextElement;

public interface RenderMixinAccessor {
	public void setElements(List<TextElement> elements);
}
