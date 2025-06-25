package com.github.theprogmatheus.minecraft.utils.guibuilder;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class GuiButton
{

	private ItemStack itemStack;
	private Map<ClickType, GuiRunnable> runnables;

	public GuiButton(ItemStack itemStack)
	{
		this.itemStack = itemStack;
		this.runnables = new HashMap<>();
	}

	public void addGuiRunnable(ClickType clickType, GuiRunnable guiRunnable)
	{
		this.runnables.put(clickType, guiRunnable);
	}

	public GuiRunnable getGuiRunnable(ClickType clickType)
	{
		return this.runnables.get(clickType);
	}

	public GuiRunnable getGuiRunnableWithFixed(ClickType clickType)
	{
		GuiRunnable runnable = null;
		if (!this.runnables.isEmpty()) {

			runnable = this.runnables.get(clickType);

			if ((runnable == null) && (clickType != ClickType.LEFT)) {
				runnable = this.runnables.get(ClickType.LEFT);
			}

			if (runnable == null) {
				runnable = this.runnables.values().stream().findFirst().orElse(null);
			}

		}
		return runnable;
	}

	public ItemStack getItemStack(Player player)
	{
		return this.getItemStack();
	}

	public ItemStack getItemStack()
	{
		return this.itemStack.clone();
	}

	public void setItemStack(ItemStack itemStack)
	{
		this.itemStack = itemStack;
	}

}
