package chap07.ex07;

public class Client {

	public static void main(String[] args) {
		VingsuMaker maker = new VingsuMaker();
		maker.Maker(new RerBeaenVingsu());
		System.out.println();
		maker.Maker(new ChocoVingsu());
		System.out.println();
		maker.Maker(new CookieVingsu());
	}

}
