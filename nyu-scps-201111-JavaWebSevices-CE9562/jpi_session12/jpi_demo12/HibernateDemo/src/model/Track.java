package model;

public class Track extends Item{
	private transient static final long serialVersionUID = 1L;


	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
