package chi;

public class Human {

	private String name;
	private String surname;
	private String patronymic;
	private Gender gender;
	private int age;

	public Human(String name, String surname, String patronymic, Gender gender, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.gender = gender;
		this.age = age;
	}

	public Human() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + ", patronymic=" + patronymic + ", gender=" + gender
				+ ", age=" + age + "]";
	}

}

enum Gender {
	male, female, robot
}