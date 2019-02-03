package com.sredition.lib.guibuilder;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;

import com.sredition.lib.guibuilder.layouts.DefaultLayout;

public class GuiFrame implements InventoryHolder
{

	private String title;
	private GuiLayout layout;
	private HashMap<Integer, GuiButton> buttons;

	public GuiFrame(String title)
	{
		this(title, new DefaultLayout());
	}

	public GuiFrame(String title, GuiLayout layout)
	{
		this.title = title;
		this.layout = layout;
		this.buttons = new HashMap<>();
	}

	public void put(int index, GuiButton button)
	{
		this.buttons.put(index, button);
	}

	public void put(GuiButton button)
	{

		int[] slots = this.layout.slots();

		for (int i = 0; i < slots.length; i++) {

			int index = slots[i];
			GuiButton otherButton = this.buttons.get(index);

			if (otherButton == null) {
				this.put(index, button);
				break;
			}

		}

	}

	public GuiButton get(int index)
	{
		return this.buttons.get(index);
	}

	public void show(Player player)
	{
		Inventory inventory = Bukkit.createInventory(this, this.layout.size(), this.title);
		if (!this.buttons.isEmpty()) {
			for (Integer integer : this.buttons.keySet()) {
				GuiButton button = this.buttons.get(integer);
				if (button != null) {
					inventory.setItem(integer.intValue(), button.getItemStack(player));
				}
			}
		}
		player.openInventory(inventory);
	}

	public GuiButton getButton(int index)
	{
		if (this.buttons.containsKey(index)) {
			return this.buttons.get(index);
		}
		return null;
	}

	public GuiLayout getLayout()
	{
		return this.layout;
	}

	public void setLayout(GuiLayout layout)
	{
		this.layout = layout;
	}

	@Override
	public Inventory getInventory()
	{
		return null;
	}

	public static GuiFrame currentFrame(Player player)
	{
		InventoryView openInventory = player.getOpenInventory();
		if (openInventory != null) {
			Inventory chestInventory = openInventory.getTopInventory();
			if (chestInventory != null) {
				InventoryHolder inventoryHolder = chestInventory.getHolder();
				if ((inventoryHolder != null) && (inventoryHolder instanceof GuiFrame)) {
					return ((GuiFrame) inventoryHolder);
				}
			}
		}
		return null;
	}

}
