package Tester;

public class Contact {
	// Fields
	private String lastname;
	private String firstname;
	private String email;
	private String cellphone;
	private String address;
	
	public Contact (String l, String f) {
		lastname = l;
		firstname = f;
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCell() {
		return cellphone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public void setCell (String c) {
		cellphone = c;
	}
	
	public void setAddress (String a) {
		address = a;
	}
	
	public void setName (String last, String first) {
		lastname = last;
		firstname = first;
	}	
}
