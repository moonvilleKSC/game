package com.ksc.moonville;

public class Depth implements Comparable<Depth>{
	/*
	 * ___________Variables___________
	 */
	private Zone mZone;		//zone such as background or foreground
	private int mPlace;			//place in the zone
	
	/*
	 * Sub Classes enums and more
	 */
	public static enum Zone
	{
		BACKGROUND, STAGE, FOREGROUND;
	}
	
	/*
	 * __________Constructors_____________
	 */
	public Depth(Zone zone, int place)
	{
		mZone = zone;
		mPlace = place;
	}
	
	/*
	 * __________Functions______________
	 */
	//to string method for output
	@Override
	public String toString()
	{
		return mZone.toString() + " : " + mPlace;
	}
	
	//compare to function for comparability
	@Override
	public int compareTo(Depth depth)
	{
		int zoneOffset = mZone.compareTo(depth.mZone);
		if(zoneOffset != 0)
			return zoneOffset;
		
		if(mPlace > depth.mPlace)
			return 1;
		else if(mPlace < depth.mPlace)
			return -1;
		
		return 0;
	}
	
	public Depth add(int value)
	{
		return new Depth(mZone, mPlace + value);
	}
	
	public Depth subtract(int value)
	{
		return new Depth(mZone, mPlace - value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mPlace;
		result = prime * result + ((mZone == null) ? 0 : mZone.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depth other = (Depth) obj;
		if (mPlace != other.mPlace)
			return false;
		if (mZone != other.mZone)
			return false;
		return true;
	}
	
	/*
	 * Getters and setters
	 */
	
	public Zone getZone()
	{
		return mZone;
	}
	
	public int getPlace()
	{
		return mPlace;
	}
}