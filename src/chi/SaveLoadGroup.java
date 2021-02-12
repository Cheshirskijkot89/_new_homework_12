package chi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JFileChooser;

public abstract class SaveLoadGroup {

	static void SaveGroup(Group grp) {

		File fileGroup;
		File fileFolder;

		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setDialogTitle("Укажите каталог сохранения файла");

		int result = fc.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			fileFolder = fc.getSelectedFile();
		} else {
			return;
		}

		fileGroup = new File(fileFolder.getAbsolutePath() + "/" + "file_group.txt");

		String str = "";

		for (Student st : grp.GetStudents()) {

			if (st == null) {
				continue;
			}

			str += (st.getName().equals("")) ? "*" : st.getName();
			str += "%";

			str += (st.getSurname().equals("")) ? "*" : st.getSurname();
			str += "%";

			str += (st.getPatronymic().equals("")) ? "*" : st.getPatronymic();
			str += "%";

			str += (st.getAge() == 0) ? "*" : String.valueOf(st.getAge());
			str += "%";

			str += (st.getGender() == null) ? "*" : st.getGender().toString();
			str += "%";

			str += (st.getUniversity().equals("")) ? "*" : st.getUniversity();
			str += "%";

			str += (st.getFaculty().equals("")) ? "*" : st.getFaculty();
			str += "%";

			str += (st.getCourse() == 0) ? "*" : String.valueOf(st.getCourse());

			str += System.lineSeparator();

		}

		try (FileOutputStream fos = new FileOutputStream(fileGroup)) {

			fos.write(str.getBytes());
			System.out.println("группа сохранена");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	static Group LoadGroup() {

		File fileGroup;

		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Укажите файл для загрузки");

		int result = fc.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			fileGroup = fc.getSelectedFile();
		} else {
			return null;
		}

		try (BufferedReader bf = new BufferedReader(new FileReader(fileGroup))) {

			Group grp = new Group();

			Student stTemp;
			String[] words;

			String tempLime = "";
			
			int counter  = 0;
			
			while ((tempLime = bf.readLine()) != null) {

				stTemp = new Student();
				words = tempLime.split("%");

				if (!words[0].equals("*")) {
					stTemp.setName(words[0]);
				}

				if (!words[1].equals("*")) {
					stTemp.setSurname(words[1]);
				}

				if (!words[2].equals("*")) {
					stTemp.setPatronymic(words[2]);
				}

				if (!words[3].equals("*")) {
					stTemp.setAge(Integer.parseInt(words[3]));
				}

				if (!words[4].equals("*")) {
					stTemp.setGender(Gender.valueOf(words[4]));
				}

				if (!words[5].equals("*")) {
					stTemp.setUniversity(words[5]);
				}

				if (!words[6].equals("*")) {
					stTemp.setFaculty(words[6]);
				}

				if (!words[7].equals("*")) {
					stTemp.setCourse(Integer.parseInt(words[7]));
				}

				grp.addStudent(stTemp, counter++);

			}

			return grp;

		} catch (Exception e) {
			return null;
		}

	}

}
