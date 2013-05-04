

import java.util.*;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class StudentList {
	public ArrayList<Student> studentlist;

	public StudentList() {
		studentlist = new ArrayList<Student>();
	}

	public void addStudent(String name, String race, String gender) {
		studentlist.add(new Student(name, race, gender));
	}

	public void addAllStudentsInFile() throws Exception {
		InputStream fis = new FileInputStream("StudentData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Test1");
		int count = 1;
		try {
			while (!(ws.getRow(count).getCell(0).equals(null))
					&& !(ws.getRow(count).getCell(2).equals(null)) && !(ws
					.getRow(count).getCell(4).equals(null))) {
				addStudent(ws.getRow(count).getCell(0).toString(),
						ws.getRow(count).getCell(2).toString(), ws
								.getRow(count).getCell(4).toString());
				count++;
			}
		} catch (NullPointerException e) {

		}
	}
	
	
}
