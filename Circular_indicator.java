package percentage;

import java.awt.Color;
import java.awt.Graphics;

public class Circular_indicator extends Indicator {
	private Color c;
	private double proc;
	public Circular_indicator(int width,int height,Color color) {	
		c=color;setSize(width,height);
	}
	public void paint(Graphics g) {
		g.setColor(c);
		g.drawOval(0, 0, getWidth(), getHeight());
		g.fillArc(0, 0,getWidth() , getHeight(), 0, (int)(proc*360));
	}
	public void notify_t(double i) {
		proc=i;
		repaint();
	}

}
