




public class Student {
	String name;
	String race;
	String gender;
	public Student(String name, String race, String gender) {
		this.name = name;
		this.race = race;
		this.gender = gender;
	}
	public Student(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public String getRace() {
		return race;
	}
	public String getGender() {
		return gender;
	}
	public String toString() {
		return (name + ", " + race + ", " + gender);
	}
}
