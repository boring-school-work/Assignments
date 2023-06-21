public class TestMarker {
	public static void main(String[] args) {
		Marker blackMarker = new Marker();
		Marker redMarker = new Marker("red");
		Marker blueMarker = new Marker("blue", (byte) 25);

		System.out.println(blackMarker.toString());
		System.out.println(redMarker.toString());
		System.out.println(blueMarker.toString());
	}
}
