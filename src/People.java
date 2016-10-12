
public class People {

	private int id;
	private String name;
	private String surname;
	private String country;
	
	public People(int id, String name, String surname, String country){
		
		setId(id);
		setName(name);
		setSurname(surname);
		setCountry(country);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
