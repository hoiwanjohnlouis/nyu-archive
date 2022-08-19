public class CoinTester {

	public static void main(String[] args){
		Coin n = Coin.Nickel;
		System.out.println(n.name()+"\t"+ n.value());
		Coin d = Coin.Dime;
		System.out.println(d.name()+"\t"+ d.value());
	}
}
