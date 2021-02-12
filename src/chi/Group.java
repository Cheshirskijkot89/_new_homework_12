package chi;

import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Group implements Voenkom {

	private Student[] grp;
	private String fieldOFSort;

	public Group() {
		super();
		grp = new Student[10];
	}

	@Override
	public Student[] getRecruits() {

		Student[] result;
		int count = 0;
		int recruits = 0;

		for (int i = 0; i < grp.length; i++) {

			if (grp[i] == null) {
				continue;
			}

			if (grp[i].getAge() > 18 && grp[i].getGender() == Gender.male) {
				count++;
			}
		}

		result = new Student[count];

		for (int i = 0; i < grp.length; i++) {

			if (grp[i] == null) {
				continue;
			}

			if ((grp[i].getAge() > 18 && grp[i].getGender() == Gender.male)) {
				result[recruits++] = grp[i];
			}

		}

		return result;
	}

	public String getFieldOFSort() {
		return fieldOFSort;
	}

	public void setFieldOFSort(String fieldOFSort) {
		this.fieldOFSort = fieldOFSort;
	}

	public void addStudent(Student st, int ind) throws MyException {

		if (ind > grp.length - 1) {
			throw new MyException("������ " + ind + " ��������� ������ �������");
		}

		if (grp[ind] != null) {

			int result = JOptionPane.showConfirmDialog(null, "��������?", "����� " + ind + " ������",
					JOptionPane.YES_NO_OPTION);

			if (result == 0) {
				grp[ind] = st;
				System.out.println("student is added");
			} else {
				System.out.println("student is not added");
			}

		} else {
			grp[ind] = st;
		}

	}

	public void addStudent(Student st) throws MyException2 {

		boolean studIsAdded = false;

		for (int i = 0; i < grp.length; i++) {
			if (grp[i] == null) {
				grp[i] = st;
				System.out.println("student is added");
				studIsAdded = true;
			}
		}

		if (studIsAdded == false) {
			System.out.println("student is not added");
			throw new MyException2("������ ��� ��������");
		}

	}

	public void AddStudIteractive() {

		String name;
		String surname;
		String patronymic;
		String gender;
		int age;
		int course;
		String university;
		String faculty;

		name = JOptionPane.showInputDialog("��� ��������");

		if (name != null) {
			JOptionPane.showMessageDialog(null, "��� ������: " + name);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		surname = JOptionPane.showInputDialog("������� ��������");

		if (surname != null) {
			JOptionPane.showMessageDialog(null, "������� ������: " + surname);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		patronymic = JOptionPane.showInputDialog("�������� ��������");

		if (patronymic != null) {
			JOptionPane.showMessageDialog(null, "�������� ������: " + patronymic);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		String[] options = { "male", "female", "robot" };
		ImageIcon icon = new ImageIcon();
		gender = (String) JOptionPane.showInputDialog(null, "������� �����", "�����", JOptionPane.QUESTION_MESSAGE,
				icon, options, options[2]);

		if (gender != null) {
			JOptionPane.showMessageDialog(null, "����� ������: " + gender);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		try {
			age = Integer.valueOf(JOptionPane.showInputDialog("������� ��������"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		if (age != 0) {
			JOptionPane.showMessageDialog(null, "������� �����: " + age);
		}

		try {
			course = Integer.valueOf(JOptionPane.showInputDialog("���� ��������"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		if (course != 0) {
			JOptionPane.showMessageDialog(null, "���� �����: " + course);
		}

		university = JOptionPane.showInputDialog("university");

		if (university != null) {
			JOptionPane.showMessageDialog(null, "university: " + university);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		faculty = JOptionPane.showInputDialog("faculty");

		if (faculty != null) {
			JOptionPane.showMessageDialog(null, "faculty: " + faculty);
		} else {
			JOptionPane.showMessageDialog(null, "������� �� �����");
			return;
		}

		Student stNew = new Student();
		stNew.setName(name);
		stNew.setSurname(surname);
		stNew.setPatronymic(patronymic);
		stNew.setGender(Gender.valueOf(gender));
		stNew.setAge(age);
		stNew.setCourse(course);
		stNew.setFaculty(faculty);
		stNew.setUniversity(university);

		try {
			addStudent(stNew);
		} catch (MyException2 e) {
			System.out.println(e.getMessage());
		}

	}

	public Student findStudent(String surname) {

		for (Student i : grp) {

			if (i == null) {
				continue;
			}

			if (i.getSurname().equals(surname)) {
				return i;
			}
		}

		return null;

	}

	public void sortGroup() {

		Student stTemp;
		Student stFirst;
		Student stSecond;

		boolean sortingFinishing = false;
		boolean positionIsChanged = false;
		
		if (fieldOFSort == null) {
			return;
		}

		while (sortingFinishing == false) {

			for (int i = 0; i < grp.length - 1; i++) {

				stFirst = grp[i];
				stSecond = grp[i + 1];

				if (stFirst != null && stSecond != null) {
					// if (grp[i].getName().compareTo(grp[i + 1].getName()) > 0) {
					if (grp[i].getSort(fieldOFSort).compareTo(grp[i + 1].getSort(fieldOFSort)) > 0) {
						stTemp = grp[i];
						grp[i] = grp[i + 1];
						grp[i + 1] = stTemp;
						positionIsChanged = true;
					}
				} else if (stFirst == null && stSecond != null) {
					stTemp = grp[i];
					grp[i] = grp[i + 1];
					grp[i + 1] = stTemp;
					positionIsChanged = true;
				}

			}

			if (positionIsChanged == true) {
				sortingFinishing = false;
				positionIsChanged = false;
			} else {
				sortingFinishing = true;
			}

		}

	}
	
	Student[] GetStudents() {
		
		return grp;
		
	};

	@Override
	public String toString() {

		sortGroup();
		// Arrays.sort(grp);
		String result = "";

		for (Student i : grp) {

			if (i == null) {

				if (result == "") {
					result = "�������� �����������";
				} else {
					result = result + "\n" + "�������� �����������";
				}

			} else {

				if (result == "") {
					result = i.toString();
				} else {
					result = result + "\n" + i.toString();
				}

			}

		}

		return result;

	}

}
