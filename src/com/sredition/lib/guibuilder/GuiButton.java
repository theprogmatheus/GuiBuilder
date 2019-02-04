package com.sredition.lib.guibuilder;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class GuiButton
{

	private ItemStack itemStack;
	private Map<ClickType, Consumer<? super Player> consumers;

	public GuiButton(ItemStack itemStack)
	{
		this.itemStack = itemStack;
		this.consumers = new HashMap<>();
	}

	public void addGuiRunnable(ClickType clickType, Consumer<? super Player> consumer)
	{
		this.consumers.put(clickType, consumer);
	}

	public Consumer<? super Player> getGuiRunnable(ClickType clickType)
	{
		return this.consumers.get(clickType);
	}

	public Consumer<? super Player> getGuiRunnableWithFixed(ClickType clickType)
	{
		Consumer<? super Player> consumer = null;
		if (!this.consumers.isEmpty()) {

			consumer = this.consumers.get(clickType);

			if ((consumer == null) && (clickType != ClickType.LEFT)) {
				consumer = this.consumers.get(ClickType.LEFT);
			}

			if (consumer == null) {
				consumer = this.consumers.values().stream().findFirst().orElse(null);
			}

		}
		return consumer;
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
