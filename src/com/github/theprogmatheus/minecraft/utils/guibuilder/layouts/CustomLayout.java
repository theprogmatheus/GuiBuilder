package com.github.theprogmatheus.minecraft.utils.guibuilder.layouts;

import com.github.theprogmatheus.minecraft.utils.guibuilder.GuiLayout;

public class CustomLayout implements GuiLayout
{

	private int rows;
	private int[] slots;

	public CustomLayout(int rows, int... slots)
	{
		this.rows = ((rows < 1) || (rows > 6)) ? 6 : rows;
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
		return (this.rows * 9);
	}

}
