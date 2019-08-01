package percentage;

import java.awt.Color;
import java.awt.Graphics;

public class Square_indicator extends Indicator {
	private double proc;
	boolean dir;
	private Color c;
	public Square_indicator(int width,int height,Color color) {
		setSize(width,height);c=color;
		dir=width>height;
	}

	@Override
	public void notify_t(double i) {
		proc=i;
		repaint();
	}
	public void paint(Graphics g) {
		g.setColor(c);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1	);
		g.fillRect(0, 0,(int)(getWidth()*(dir?proc:1)), (int)(getHeight()*(dir?1:proc)));
	}
}
