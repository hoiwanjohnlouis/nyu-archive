package service;

import dao.RandomIF;
import dao.RandomImpl;

public class RandomServiceImpl implements RandomServiceIF{
	private RandomIF randomDAO = null;
	
	public int findRandom() {
		return randomDAO.getRandom();
	}

	public RandomIF getRandomDAO() {
		return randomDAO;
	}

	public void setRandomDAO(RandomIF randomDAO) {
		this.randomDAO = randomDAO;
	}

}
