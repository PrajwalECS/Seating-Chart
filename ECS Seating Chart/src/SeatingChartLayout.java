

import java.awt.*;
import javax.swing.*;

public class SeatingChartLayout extends JPanel {
	Stroke drawingStroke = new BasicStroke(3, BasicStroke.CAP_BUTT,
			BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
	
	public SeatingChartLayout() {
		super.add(new TextField());
	}
	public void paintComponent(Graphics g) { // Code to establish the layout of
												// the seating chart
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.setColor(new Color(207, 180, 31));
		g.fillRect(150, 20, 500, 20);
		g.setColor(Color.RED);
		Font font = new Font("Monotype Corsiva", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString("Board", 365, 38);
		g.setColor(new Color(207, 180, 31));
		g.fillRect((int)(100 * 1.6), (int)(150 * 1.28), (int)(60 * 1.6), (int)(120 * 1.28)); //start of outer U
		g.fillRect((int)(100 * 1.6), (int)(275 * 1.28), (int)(60 * 1.6), (int)(120 * 1.28));
		g.fillRect((int)(100 * 1.6), (int)(400 * 1.28), (int)(60 * 1.6), (int)(120 * 1.28));
		g.fillRect((int)(100 * 1.6), (int)(525 * 1.28), (int)(120 * 1.6), (int)(60 * 1.28));
		g.fillRect((int)(225 * 1.6), (int)(525 * 1.28), (int)(120 * 1.6), (int)(60 * 1.28));
		g.fillRect(455, 525, 120, 60);
		g.fillRect(580, 525, 120, 60);
		g.fillRect(640, 150, 60, 120);
		g.fillRect(640, 275, 60, 120);
		g.fillRect(640, 400, 60, 120);
		g.fillRect(305, 100, 60, 120); //start of inner  U
		g.fillRect(305, 225, 60, 120); 
		g.fillRect(275, 350, 120, 60);
		g.fillRect(435, 100, 60, 120);
		g.fillRect(435, 225, 60, 120);
		g.fillRect(405, 350, 120, 60);
		g.setColor(Color.BLACK);
		
	}

	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2,
			double dash_length, double space_length) {
		if ((x1 == x2) && (y1 == y2)) {
			g.drawLine(x1, y1, x2, y2);
			return;
		}

		double linelength = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1)
				* (y2 - y1));
		double yincrement = (y2 - y1)
				/ (linelength / (dash_length + space_length));
		double xincdashspace = (x2 - x1)
				/ (linelength / (dash_length + space_length));
		double yincdashspace = (y2 - y1)
				/ (linelength / (dash_length + space_length));
		double xincdash = (x2 - x1) / (linelength / (dash_length));
		double yincdash = (y2 - y1) / (linelength / (dash_length));
		int counter = 0;
		for (double i = 0; i < linelength - dash_length; i += dash_length
				+ space_length) {
			g.drawLine((int) (x1 + xincdashspace * counter),
					(int) (y1 + yincdashspace * counter), (int) (x1
							+ xincdashspace * counter + xincdash), (int) (y1
							+ yincdashspace * counter + yincdash));
			counter++;
		}

		if ((dash_length + space_length) * counter <= linelength)
			g.drawLine((int) (x1 + xincdashspace * counter),
					(int) (y1 + yincdashspace * counter), x2, y2);
	}

}
