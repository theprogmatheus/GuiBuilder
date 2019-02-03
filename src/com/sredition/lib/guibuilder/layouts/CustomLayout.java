package com.sredition.lib.guibuilder.layouts;

import com.sredition.lib.guibuilder.GuiLayout;

public class CustomLayout implements GuiLayout
{

	private int size;
	private int[] slots;

	public CustomLayout(int size, int... slots)
	{
		this.size = size;
		this.slots = slots;
	}

	@Override
	public int[] slots()
	{
		return this.slots;
	}

	@Override
	public int size()
	{
		return this.size;
	}

}
