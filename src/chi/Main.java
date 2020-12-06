package chi;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Student st1 = new Student("Дарт", "Вейдер", "Звездосмертович", Gender.male, 100, 1, "Звезда смерти",
				"Уничтожения");
		Student st2 = new Student("Люк", "Скайвокер", "Гонщикович", Gender.male, 15, 1, "Звезда смерти", "Уничтожения");
		Student st3 = new Student("Лея", "Органа", "Принцессовна", Gender.female, 20, 1, "Звезда смерти",
				"Уничтожения");
		Student st4 = new Student("Робот", "Р2Д2", "Роботович", Gender.robot, 500, 1, "Звезда смерти", "Уничтожения");
		Student st5 = new Student("Робот", "Ситрипио", "Роботович", Gender.robot, 600, 1, "Звезда смерти",
				"Уничтожения");
		Student st6 = new Student("Волосатый", "Чубака", "Чубакович", Gender.male, 20, 1, "Звезда смерти",
				"Уничтожения");
		Student st7 = new Student("Хан", "Соло", "Неизвестнович", Gender.male, 20, 1, "Звезда смерти", "Уничтожения");
		Student st8 = new Student("Зеленый", "Йода", "Неизвестнович", Gender.male, 20, 1, "Звезда смерти",
				"Уничтожения");
		Student st9 = new Student("Оби", "Ван", "Кеноби", Gender.male, 20, 1, "Звезда смерти", "Уничтожения");
		Student st10 = new Student("Джабба", "Хат", "Неизвестнович", Gender.male, 20, 1, "Звезда смерти",
				"Уничтожения");
		Student st11 = new Student("Робот", "ББ8", "Роботович", Gender.robot, 20, 1, "Звезда смерти", "Уничтожения");

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
