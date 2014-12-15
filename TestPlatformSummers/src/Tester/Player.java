package Tester;

public class Player {
	// Fields
	private String name;
	private int position;
	private String email;
	
	
	// Constructors
	public Player (String n){
		name = n;
		
	}
	
	// Methods for Player
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public String getEmail() {
		return email;
	}
}
