package service;

import dao.RandomIF;
import dao.RandomImpl;

public class RandomServiceImpl implements RandomServiceIF{
	private RandomIF xyz = null;
	
	public int findRandom() {
		return xyz.getRandom();
	}

	public RandomIF getRandomDAO() {
		return xyz;
	}

	public void setRandomDAO(RandomIF randomDAO) {
		this.xyz = randomDAO;
	}

}
