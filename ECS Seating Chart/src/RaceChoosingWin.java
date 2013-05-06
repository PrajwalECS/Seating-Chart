import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.apache.poi.xssf.usermodel.*;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RaceChoosingWin extends JFrame implements ActionListener {

	ButtonGroup group;
	JButton view;
	JButton create;
	JButton edit;
	JButton next;
	JRadioButton african;
	JRadioButton white;
	JRadioButton asian;
	JRadioButton alaskanpacific;
	JRadioButton hispanic;
	JRadioButton indian;
	JRadioButton nativeamerican;
	JTextField namefield;
	InputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet ws;
	ArrayList<Student> students = new ArrayList<Student>();
	int count = 1;
	Student currentStudent;

	public RaceChoosingWin() {

		super.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		super.setTitle("Seating Chart");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		group = new ButtonGroup();
		getContentPane().setLayout(
		new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		
		african = new JRadioButton();
		african.setText("African American");
		group.add(african);
		panel.add(african);
		
		white = new JRadioButton();
		white.setText("White");
		group.add(white);
		panel.add(white);
		
		asian = new JRadioButton();
		asian.setText("Asian American");
		group.add(asian);
		panel.add(asian);
		
		alaskanpacific = new JRadioButton();
		alaskanpacific.setText("Alaskan Native/Pacific Islander");
		group.add(alaskanpacific);
		panel.add(alaskanpacific);
		
		hispanic = new JRadioButton();
		hispanic.setText("Hispanic");
		group.add(hispanic);
		panel.add(hispanic);
		
		indian = new JRadioButton();
		indian.setText("Indian");
		group.add(indian);
		panel.add(indian);
		
		nativeamerican = new JRadioButton();
		nativeamerican.setText("Native American");
		group.add(nativeamerican);
		panel.add(nativeamerican);
		
		view = new JButton();
		create = new JButton();
		edit = new JButton();
		next = new JButton();
		
		view.addActionListener(this);
		create.addActionListener(this);
		edit.addActionListener(this);
		next.addActionListener(this);
		
		panel.add(view);
		view.setText("View Previous Seating Charts");
		panel.add(create);
		create.setText("Create Seating Chart");
		panel.add(edit);
		edit.setText("Edit Previous Seating Charts");
		panel.add(next);
		next.setText("Next Student");
		
		try {
			fis = new FileInputStream("StudentData.xlsx");
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet("Sheet1");
		} catch (FileNotFoundException exception) {
			
		} catch (IOException exception) {

		}

		namefield = new JTextField("");
		super.getContentPane().add(panel);
		super.getContentPane().add(namefield);
		super.pack();
		super.setVisible(true);
		
		try {
			currentStudent = load(count);
			count++;
		} catch (NullPointerException exception) {
			namefield.setText("All Students Are Done!");
		}
	}
	public static void main(String[] args) throws Exception {
		// TEMPP
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		RaceChoosingWin r = new RaceChoosingWin();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			try {
				SeatingChartWin w = new SeatingChartWin();
				w.setVisible(true);
			} catch (Exception ex) {

			}
		}
		else if (e.getSource() == next) {
			if (white.isSelected()) {
				currentStudent.setRace("White");
			} else if (african.isSelected()) {
				currentStudent.setRace("African");
			} else if (nativeamerican.isSelected()) {
				currentStudent.setRace("Native American");
			} else if (indian.isSelected()) {
				currentStudent.setRace("Indian");
			} else if (alaskanpacific.isSelected()) {
				currentStudent.setRace("Alaskan/Pacific Islander");
			} else if (hispanic.isSelected()) {
				currentStudent.setRace("Hispanic");
			} else if (asian.isSelected()) {
				currentStudent.setRace("Asian");
			}
			try {
				students.add(currentStudent);
				System.out.println(students);
				currentStudent = load(count);
				count++;
			} catch (NullPointerException exception) {
				namefield.setText("All Students Are Done!");
			}
			group.clearSelection();
		}
	}

	public Student load(int n) throws NullPointerException {
		String name =
		ws.getRow(n).getCell(0).toString();
		namefield.setText(name);
		Student st = new Student(name);
		st.setGender(ws.getRow(count).getCell(4).toString());
		return st;
	}
}