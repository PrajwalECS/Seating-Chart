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
	ArrayList<String> races = new ArrayList<String>();
	int count = 1;

	public RaceChoosingWin() {
		super.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		super.setTitle("Seating Chart");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup group = new ButtonGroup();
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
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

		namefield = new JTextField();

		super.getContentPane().add(panel);
		super.getContentPane().add(namefield);
		super.pack();
		super.setVisible(true);

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

		} else if (e.getSource() == next) {
			try {
				fis = new FileInputStream("StudentData.xlsx");

				wb = new XSSFWorkbook(fis);

			} catch (FileNotFoundException exception) {

			} catch (IOException exception) {

			}
			XSSFSheet ws = wb.getSheet("Sheet1");
			try {
				if (!((ws.getRow(count).getCell(0)).equals(null))) {
					white.setSelected(false);
					namefield.setText(ws.getRow(count).getCell(0).toString());
					if (white.isSelected()) {
						races.add("White");
						System.out.println(races);
					}
					count++;
				}
			} catch (NullPointerException exception) {
				namefield.setText("All Students Are Done!");

			}

		}
	}

}
