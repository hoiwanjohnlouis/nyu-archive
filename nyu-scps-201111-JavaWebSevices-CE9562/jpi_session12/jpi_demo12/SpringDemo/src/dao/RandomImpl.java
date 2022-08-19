package dao;

public class RandomImpl implements RandomIF{
	private static int objectCount=1;
	private final int objectId;

	public RandomImpl(){
		objectId=objectCount++;
	}

	public int getObjectId() {
		return objectId;
	}

	public int getRandom() {
		
		return (int) (Math.random()*100);
	}

}
