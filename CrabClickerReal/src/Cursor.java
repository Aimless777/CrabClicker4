public class Cursor {
	private static long cost = 15;
	
	public Cursor() {
		cost *= 1.15;
	}
	public static long getCost() {
		return cost;
	}
}
