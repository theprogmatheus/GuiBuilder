# GuiBuilder (Bukkit) 1.8.8
A simple Bukkit library for handling GUI menus.


## Exemplo de Uso:
```java
public class Example extends JavaPlugin
{

	@Override
	public void onEnable()
	{
		// Registra o GuiEngine no onEnable();
		new GuiEngine(this).register();
	}

	// Exibe um menu com o layout default para o jogador.
	public static void showSimpleMenu(Player player)
	{
		// Cria um GuiFrame com o título e layout que você quer usar.
		// DefaultLayout(rows)
		GuiFrame frame = new GuiFrame("Menu Simples", new DefaultLayout(6));

		// Cria alguns botões para colocar no menu
		GuiButton netherStarButton = new GuiButton(new ItemStack(Material.NETHER_STAR));
		GuiButton diamondButton = new GuiButton(new ItemStack(Material.DIAMOND));

		// Adicione os métodos que devem ser executados ao clicar nos botões.

		netherStarButton.addGuiRunnable(ClickType.LEFT, new GuiRunnable()
		{
			@Override
			public void run(Player player)
			{
				player.sendMessage("§aVocê clicou na Nether Star");
			}
		});

		diamondButton.addGuiRunnable(ClickType.LEFT, new GuiRunnable()
		{
			@Override
			public void run(Player player)
			{
				player.closeInventory();
				player.sendMessage("§cVocê fechou o menu");
			}
		});

		// com o método put(GuiButton) você adiciona o botão ao primeiro slot vazio do
		// inventário.
		frame.put(netherStarButton);

		// com o método put(int, GuiButton) você adiciona o botão no slot informado como
		// int.
		frame.put(53, diamondButton);

		// exibe o menu para o jogador.
		frame.show(player);
	}

	// Exibe um menu com o layout customizado para o jogador.
	public static void showCustomMenu(Player player)
	{
		// Cria um GuiFrame com o título e layout que você quer usar.
		// CustomLayout(rows, slots)
		GuiFrame frame = new GuiFrame("Menu Custom", new CustomLayout(6, new int[] { 10, 11, 12, 13, 14, 15, 16, 19, 20,
				21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 }));

		// Cria alguns botões para colocar no menu
		GuiButton netherStarButton = new GuiButton(new ItemStack(Material.NETHER_STAR));
		GuiButton diamondButton = new GuiButton(new ItemStack(Material.DIAMOND));

		// Adicione os métodos que devem ser executados ao clicar nos botões.

		netherStarButton.addGuiRunnable(ClickType.LEFT, new GuiRunnable()
		{
			@Override
			public void run(Player player)
			{
				player.sendMessage("§aVocê clicou na Nether Star");
			}
		});

		diamondButton.addGuiRunnable(ClickType.LEFT, new GuiRunnable()
		{
			@Override
			public void run(Player player)
			{
				player.closeInventory();
				player.sendMessage("§cVocê fechou o menu");
			}
		});

		// com o método put(GuiButton) você adiciona o botão ao primeiro slot vazio do
		// inventário.
		frame.put(netherStarButton);

		// com o método put(int, GuiButton) você adiciona o botão no slot informado como
		// int.
		frame.put(53, diamondButton);

		// exibe o menu para o jogador.
		frame.show(player);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		Player player = ((sender instanceof Player) ? ((Player) sender) : null);
		if (player != null) {
			if (args.length >= 1) {
				String type = args[0];
				switch (type.toLowerCase()) {
				case "simples":
					showSimpleMenu(player);
					break;
				case "custom":
					showCustomMenu(player);
					break;
				}

			}
		}
		return false;
	}

}
```