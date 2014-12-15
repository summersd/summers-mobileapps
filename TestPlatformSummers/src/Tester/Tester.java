package Tester;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// Make two players
//		Player rebecca = new Player("Rebecca");
//		Player joshua = new Player("Joshua");
//		
//		System.out.println(rebecca.getName());
//		System.out.println(joshua.getName());
//		
//		rebecca.setPosition(10);
//		joshua.setPosition(8);
//		
//		rebecca.setEmail("rebecca17@marist.com");
//		joshua.setEmail("joshua22@marist.com");
//				
//		System.out.println(rebecca.getName() + "'s position is: ");
//		System.out.println(rebecca.getPosition());
//		
//		System.out.println(joshua.getName() + "'s position is: ");
//		System.out.println(joshua.getPosition());
//		
//		System.out.println(rebecca.getEmail());
//		System.out.println(joshua.getEmail());
		
//		EnglishToSpanish dictionary = new EnglishToSpanish();
//		
//		dictionary.addEntry("cat",  "gato");
//		dictionary.addEntry("kitchen", "cocina");
//		
//		String output = dictionary.translate("dog");
//		System.out.println(output);
//		
//		output = dictionary.translate("cat");
//		System.out.println(output);
		
// Contact Tester
		
		Contact dude = new Contact("Coolest", "The");
		
		dude.setEmail("dude@dude.com");
		dude.setCell("(404)coolman");
		dude.setAddress("14 Dude St.");
		
		Contact hammer = new Contact("John", "Hammer");
		
		hammer.setEmail("idk@gmail.com");
		hammer.setCell("(404) 123-4567");
		hammer.setAddress("123 Awsome St.");
		
		System.out.println(dude.getName());
		System.out.println(dude.getEmail());
		System.out.println(dude.getCell());
		System.out.println(dude.getAddress());
		
		System.out.println(hammer.getName());
		System.out.println(hammer.getEmail());
		System.out.println(hammer.getCell());
		System.out.println(hammer.getAddress());
		System.out.println();

		
//EnglishToAwsome
		
		EnglishToAwsome dictionary = new EnglishToAwsome();
		
		dictionary.addEntry("animal",  "aanimul");
		dictionary.addEntry("spiderman", "spoderman");
		
		String output = dictionary.translate("house");
		System.out.println(output);
		
		output = dictionary.translate("animal");
		System.out.println(output);
		
	}

}
