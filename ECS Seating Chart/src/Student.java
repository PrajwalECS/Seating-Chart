




public class Student {
	String name;
	String race;
	String gender;
	public Student(String name, String race, String gender) {
		this.name = name;
		this.race = race;
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
