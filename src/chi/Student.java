package chi;

public class Student extends Human implements Comparable {

	private int course;
	private String university;
	private String faculty;

	public Student(String name, String surname, String patronymic, Gender gender, int age, int course,
			String university, String faculty) {
		super(name, surname, patronymic, gender, age);
		this.course = course;
		this.university = university;
		this.faculty = faculty;
	}

	public Student() {
		super();
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	String getSort(String fieldOfSort) {
		String result = "";

		switch (fieldOfSort) {

		case "name":
			result = super.getName();
			break;
		case "surname":
			result = super.getSurname();
			break;
		case "patronymic":
			result = super.getPatronymic();
			break;
		}

		return result;
	}

	@Override
	public String toString() {
		return super.toString() + " Student [course=" + course + ", university=" + university + ", faculty=" + faculty
				+ "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub

		if (this == null || o == null) {
			return 0;
		}

		Student anotherSt = (Student) o;

		if (this.getAge() > anotherSt.getAge()) {
			return -1;
		}

		if (this.getAge() < anotherSt.getAge()) {
			return 1;
		}

		return 0;

		/*
		 * if (o == null) { return -1; }
		 * 
		 * Student anotherSt = (Student) o;
		 * 
		 * return getName().compareToIgnoreCase(anotherSt.getName());
		 */

	}

}
