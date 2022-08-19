public enum Coin {
	Penny(1),Nickel(5),Dime(10),Quarter(50);

	private int coinValue;
	private Coin(int anyValue){
		coinValue=anyValue;
	}
	public int value(){
		return coinValue;
	}
}
