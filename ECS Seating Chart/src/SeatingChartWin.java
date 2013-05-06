

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SeatingChartWin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatingChartWin frame = new SeatingChartWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeatingChartWin() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Object[][] data = new Object[30][15];
		String[] column = new String[14];
		data[5][1] = "Dominique M.";
		data[6][1] = "Bob E.";
		data[10][1] = "Cathy D.";
		data[11][1] = "Meagan D.";
		data[15][1] = "Traz T.";
		data[16][1] = "Poppy E.";
		data[19][1] = "Kyle S.";
		data[19][2] = "Gannon K.";
		data[19][4] = "Austin W.";
		data[19][5] = "Mehdi M.";
		data[19][8] = "Connor F.";
		data[19][9] = "Nathan N.";
		data[19][11] = "Nathan M.";
		data[19][12] = "Jeffrey T.";
		data[16][12] = "Jordan C.";
		data[15][12] = "Mecca K.";
		DefaultTableModel d = new DefaultTableModel(data,column);

		table = new JTable(d);
		contentPane.add(table, BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDragEnabled(true);
		table.setDropMode(DropMode.USE_SELECTION);
		table.setTransferHandler(new DragAndDropHandler());
		table.setRowHeight(30);
		table.setRowSelectionAllowed(false);
		

	}


}
