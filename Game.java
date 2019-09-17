package TowersOfHanoi;

import java.util.Scanner;

public class Game 
{
	private boolean isInProgress = true;
	private Tower[] towers = new Tower[3];
	private String gameStatus = "Ready";
	
	public void start(int towerHeight)
	{
		int counter = 0;
		for(Tower tower : towers)
		{
			towers[counter] = new Tower(towerHeight);
			counter++;
		}
		towers[0].fillTower();
		
		while(isInProgress)
		{	
			drawGame();
			interpreteInputs(new Scanner(System.in).next());		
		}
	}
	
	private void interpreteInputs(String input)
	{
		switch(input)
		{		
		case "ab":
			move(0,1);
			break;
		case "ac":
			move(0,2);
			break;
		case "ba":
			move(1,0);
			break;
		case "bc":
			move(1,2);
			break;
		case "ca":
			move(2,0);
			break;
		case "cb":
			move(2,1);
			break;
		case "solve":
			solve();
			break;
		case "q":
			isInProgress = false;
			break;
			default:
				break;
		}
	}
	private void move(int source, int target)
	{
		if(towers[source].isTransfereLegal(towers[target]))
		{
			towers[target].addRing(towers[source].getTompmostRing());
			towers[source].removeRing();
			gameStatus = "Clear";
		}
		else
		{
			gameStatus = "Illigal";
		}
	}
	private void solve()
	{
		if(towers[towers.length-1].getRingCount()%2 == 1)
		{
			while(!towers[towers.length-1].isTowerFull())
			{
				if(!towers[towers.length-1].isTowerFull())
				{
					if(towers[0].isTransfereLegal(towers[1]))
					{
						move(0,1);						
					}
					else if(towers[1].isTransfereLegal(towers[0]))
					{
						move(1,0);					
					}
					drawGame();
				}
				if(!towers[towers.length-1].isTowerFull())
				{
					if(towers[0].isTransfereLegal(towers[2]))
					{
						move(0,2);						
					}
					else if(towers[2].isTransfereLegal(towers[0]))
					{
						move(2,0);					
					}
					drawGame();
				}
				if(!towers[towers.length-1].isTowerFull())
				{
					if(towers[1].isTransfereLegal(towers[2]))
					{
						move(1,2);						
					}
					else if(towers[2].isTransfereLegal(towers[1]))
					{
						move(2,1);					
					}
					drawGame();
				}
			}
		}
		else
		{
			while(!towers[towers.length-1].isTowerFull())
			{
				while(!towers[towers.length-1].isTowerFull())
				{
					if(!towers[towers.length-1].isTowerFull())
					{
						if(towers[0].isTransfereLegal(towers[2]))
						{
							move(0,2);						
						}
						else if(towers[2].isTransfereLegal(towers[0]))
						{
							move(2,0);					
						}
						drawGame();
					}
					if(!towers[towers.length-1].isTowerFull())
					{
						if(towers[0].isTransfereLegal(towers[1]))
						{
							move(0,1);						
						}
						else if(towers[1].isTransfereLegal(towers[0]))
						{
							move(1,0);					
						}
						drawGame();
					}
					if(!towers[towers.length-1].isTowerFull())
					{
						if(towers[1].isTransfereLegal(towers[2]))
						{
							move(1,2);						
						}
						else if(towers[2].isTransfereLegal(towers[1]))
						{
							move(2,1);					
						}
						drawGame();
					}
				}
			}			
		}
		
	}
	private String drawGame()
	{
		String status = "\n\nGame Status: " + gameStatus;
		String gameBoard = "\n\n";
		String inputRequest = "\n\nplease enter command: ";
		
		for(int y = 0; y < towers[0].getRingCount();y++)
		{
			for(int x = 0; x < towers.length;x++)
			{
				gameBoard += "\t" + towers[x].getTowerDrawing()[y];
			}
			gameBoard += "\n";
		}
		System.out.print(status + gameBoard + inputRequest);
		return status + gameBoard + inputRequest;
	}
}
