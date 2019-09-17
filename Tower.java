package TowersOfHanoi;

public class Tower 
{
	public final int FREE_SPACE = 0;
	
	private int[] Rings;
	private int topmostRingIndex;
	private String towerName;
	
	public Tower()
	{
		
	}	
	public Tower(int rings)
	{
		setRingCount(rings);
	}
	
	public void setRingCount(int ringCount)
	{
		Rings = new int[ringCount];
		clearTower();
	}	
	public int getRingCount()
	{
		return Rings.length;
	}
	public void fillTower()
	{
		int level = 0;
		for(int Ring : Rings)
		{
			Rings[level]=level+1;
			level++;
		}
		topmostRingIndex = 0;
	}
	public void clearTower()
	{
		int level = 0;
		for(int Ring : Rings)
		{
			Rings[level] = FREE_SPACE;
			level++;
		}
		topmostRingIndex = Rings.length;
	}

	public void setTowerName(String Name)
	{
		towerName = Name;
	}
	public String getTowerName()
	{
		return towerName;
	}
	public String[] getTowerDrawing()
	{
		String[] draft = new String[Rings.length];
		char middlePice = '|';
		char filling = '█';		
		
		for(int y = 0; y < Rings.length;y++)
		{
			draft[y] = "";
			int fillWidth = Rings[y];
			int spaceWidth = Rings.length-fillWidth;

			for(int x = 0; x < spaceWidth;x++)
			{
				draft[y] += " ";
			}
			for(int x = 0; x < fillWidth;x++)
			{
				draft[y] += filling;
			}
			draft[y] += middlePice;
			for(int x = 0; x < fillWidth;x++)
			{
				draft[y] += filling;
			}

			for(int x = 0; x < spaceWidth;x++)
			{
				draft[y] += " ";
			}
		}
		
		return draft;
	}
	public String getLevelDrawing(int level)
	{
		String draft = "";
		char middlePice = '|';
		char filling = '█';	
		
		draft = "";
		int spaceWidth = Rings.length-level;

		for(int x = 0; x < spaceWidth;x++)
		{
			draft += " ";
		}
		for(int x = 0; x < level;x++)
		{
			draft += filling;
		}
		draft += middlePice;
		for(int x = 0; x < level;x++)
		{
			draft += filling;
		}

		for(int x = 0; x < spaceWidth;x++)
		{
			draft += " ";
		}
		
		return draft;
	}
	
	public boolean isTransfereLegal(Tower Target)
	{
		if(this.getTompmostRing() == FREE_SPACE || (Target.getTompmostRing() < this.getTompmostRing() && Target.getTompmostRing() != FREE_SPACE))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void addRing(int ringValue)
	{
		if(topmostRingIndex > 0 )
		{
			topmostRingIndex--;
			Rings[topmostRingIndex] = ringValue;
		}
	}
	public void removeRing()
	{
		if(topmostRingIndex < Rings.length)
		{
			Rings[topmostRingIndex] = FREE_SPACE;
			topmostRingIndex++;
		}
	}
	public int getTompmostRing()
	{
		if(topmostRingIndex < Rings.length)
		{
			return Rings[topmostRingIndex];
		}
		else
		{
			return FREE_SPACE;
		}
	}
	public boolean isTowerFull()
	{
		if(Rings[0] != FREE_SPACE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
