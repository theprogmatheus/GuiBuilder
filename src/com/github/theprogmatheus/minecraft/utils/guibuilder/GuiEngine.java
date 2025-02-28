package com.github.theprogmatheus.minecraft.utils.guibuilder;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class GuiEngine implements Listener
{

	private Plugin plugin;

	public GuiEngine(Plugin plugin)
	{
		this.plugin = plugin;
	}

	public GuiEngine register()
	{
		Bukkit.getPluginManager().registerEvents(this, this.plugin);
		return this;
	}

	public Plugin getPlugin()
	{
		return this.plugin;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void inventoryClick(InventoryClickEvent event)
	{
		if (event.isCancelled()) {
			return;
		}

		HumanEntity whoClicked = event.getWhoClicked();
		if ((whoClicked == null) || (!(whoClicked instanceof Player))) {
			return;
		}

		Player player = (Player) whoClicked;

		Inventory inventory = event.getInventory();
		if ((inventory != null) && (inventory.getHolder() != null) && (inventory.getHolder() instanceof GuiFrame)) {

			event.setCancelled(true);

			GuiFrame guiFrame = (GuiFrame) inventory.getHolder();

			Inventory clickedInventory = event.getClickedInventory();
			if ((clickedInventory != null) && (clickedInventory == inventory)) {
				GuiButton button = guiFrame.get(event.getSlot());
				if (button != null) {
					GuiRunnable runnable = button.getGuiRunnableWithFixed(event.getClick());
					if (runnable != null) {
						runnable.run(player);
					}
				}
			}
		}
	}

}
