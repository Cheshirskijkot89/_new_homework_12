package chi;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Student st1 = new Student("����", "������", "���������������", Gender.male, 100, 1, "������ ������",
				"�����������");
		Student st2 = new Student("���", "���������", "����������", Gender.male, 15, 1, "������ ������", "�����������");
		Student st3 = new Student("���", "������", "������������", Gender.female, 20, 1, "������ ������",
				"�����������");
		Student st4 = new Student("�����", "�2�2", "���������", Gender.robot, 500, 1, "������ ������", "�����������");
		Student st5 = new Student("�����", "��������", "���������", Gender.robot, 600, 1, "������ ������",
				"�����������");
		Student st6 = new Student("���������", "������", "���������", Gender.male, 20, 1, "������ ������",
				"�����������");
		Student st7 = new Student("���", "����", "�������������", Gender.male, 20, 1, "������ ������", "�����������");
		Student st8 = new Student("�������", "����", "�������������", Gender.male, 20, 1, "������ ������",
				"�����������");
		Student st9 = new Student("���", "���", "������", Gender.male, 20, 1, "������ ������", "�����������");
		Student st10 = new Student("������", "���", "�������������", Gender.male, 20, 1, "������ ������",
				"�����������");
		Student st11 = new Student("�����", "��8", "���������", Gender.robot, 20, 1, "������ ������", "�����������");

		Group grp1 = new Group();

		try {
			grp1.addStudent(st1, 0);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st2, 1);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st3, 2);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * try { grp1.addStudent(st4, 3); } catch (MyException e) {
		 * System.out.println(e.getMessage()); }
		 */

		try {
			grp1.addStudent(st5, 4);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st6, 5);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st7, 6);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st8, 7);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		try {
			grp1.addStudent(st9, 8);
		} catch (MyException e) {
			System.out.println(e.getMessage());

		}

		try {
			grp1.addStudent(st10, 9);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		// grp1.AddStudIteractive();

		grp1.setFieldOFSort("name");
		System.out.println(grp1.toString());

		System.out.println();

		grp1.setFieldOFSort("surname");
		System.out.println(grp1.toString());

		Student[] rec = grp1.getRecruits();

		System.out.println(Arrays.toString(rec));

	}

}
