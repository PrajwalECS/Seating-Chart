

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class SeatingChartWindow {

	public static void main(String[] args) {
		Object[][] data = { { "Bill", "Black", "Male" },
				{ "Jack", "White", "Male" }, { "Janet", "White", "Female" },
				{ "Kumar", "Indian", "Male" } };
		String[] column = {"Name", "Race", "Gender"};
		DefaultTableModel d = new DefaultTableModel(data,column);

		JTable table = new JTable(d);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(true);
		table.setDropMode(DropMode.USE_SELECTION);
/*		JTextField t = new JTextField(20);
		t.setText("You can drag me");
		t.setDragEnabled(true);
		verticalBox.add(t);
		JTextField t1 = new JTextField(10);
		t1.setText("You can drag me too.");
		t1.setDragEnabled(true);
		verticalBox.add(t1);
*/
		JFrame f = new JFrame();
		f.setTitle("Seating Chart");
		f.setResizable(true);
		f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		f.add(new SeatingChartLayout());
		f.setVisible(true);
		
	}


}
