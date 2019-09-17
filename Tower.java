package TowersOfHanoi;

public class Tower 
{
	public final int FREE_SPACE = 0;
	
	private int[] Rings;
	private int topmostRing;
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
		topmostRing = Rings[0];
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
		topmostRing = Rings[Rings.length-1];
		topmostRingIndex = Rings.length-1;
	}

	public void setTowerName(String Name)
	{
		towerName = Name;
	}
	public String getTowerName()
	{
		return towerName;
	}
	
	public boolean isTrasfereLegal(Tower Target)
	{
		if(Target.topmostRing > this.topmostRing && this.topmostRing != FREE_SPACE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void addRing(int ringValue)
	{
		if(ringValue < topmostRing)
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
	
}
