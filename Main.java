package TowersOfHanoi;

import java.util.Scanner;

public class Main 
{

	private static boolean isInMenu = true;
	private static Scanner generalInput = new Scanner(System.in);
	public static void main(String[] args) 
	{
		drawHelp();
		while(isInMenu)
		{
			drawMenu();
			interpreteMenuInput(generalInput.next());
			generalInput.reset();
		}
	}
	public static void drawMenu()
	{
		System.out.print("Please enter command: ");
	}
	public static void drawHelp()
	{
		System.out.println("\nhelp - opens this monolog");
		System.out.println("quit - quits the application");
		System.out.println("game - starts a game of Towers\n");
	}
	public static void interpreteMenuInput(String input)
	{
		switch(input)
		{
			case "q":
				isInMenu = false;
				break;
			case "quit":
				isInMenu = false;
				break;
			case "help":
				drawHelp();
				break;
			case "h":
				drawHelp();
				break;
			case "game":
				try
				{
					System.out.print("\tTower height: ");
					new Game().start(generalInput.nextInt());
				}
				catch(Exception ex)
				{
					System.out.print("Not an integer! loading default game...");
					new Game().start(5);
				}
				break;
			default:
				System.out.println("invalid command!");
				break;
		}
	}
}
