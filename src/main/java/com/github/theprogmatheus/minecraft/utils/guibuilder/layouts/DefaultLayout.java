package com.github.theprogmatheus.minecraft.utils.guibuilder.layouts;

import com.github.theprogmatheus.minecraft.utils.guibuilder.GuiLayout;

public class DefaultLayout implements GuiLayout
{

	private int rows;

	public DefaultLayout()
	{
		this(6);
	}

	public DefaultLayout(int rows)
	{
		this.rows = ((rows < 1) || (rows > 6)) ? 6 : rows;
	}

	public int getRows()
	{
		return this.rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	@Override
	public int[] slots()
	{
		int size = this.size();

		int[] slots = new int[size];

		for (int i = 0; i < size; i++) {
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public int size()
	{
		return (this.rows * 9);
	}
}
