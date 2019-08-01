package percentage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.net.ssl.SSLContext;

public class Program extends Frame implements ActionListener{
	class we extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {dispose();}
	}
	Indicator[] ind=new Indicator[2];
	Panel hd=new Panel();
	Panel ft=new Panel();
	Button b[]=new Button[2];
	Progress[] n=new Progress[2];
	Simulated_work[] s=new Simulated_work[2];
	public Program() throws G_informative {
		super("Progress");setBounds(500,100,600,400);
		ind[0]=new Square_indicator(200, 250, Color.gray);
		ind[1]=new Circular_indicator(200, 200, Color.red);
		Panel p1=new Panel();p1.add(ind[0]);
		Panel p2=new Panel();p2.add(ind[1]);
		hd.add(p1);
		hd.add(p2);addWindowListener(new we());
		for (int i = 0; i < b.length; i++) {
			b[i]=new Button("Start");b[i].addActionListener(this);
			s[i]=new Simulated_work(1000, 10, 5, 15);
			n[i]=new Progress(ind[i]);
			s[i].subscribe(n[i]);
			ft.add(b[i]);
		}
		b[0].setActionCommand("1");
		b[1].setActionCommand("2");
		Panel hlPanel=new Panel(new GridLayout(1,2));;
		//hlPanel.add(hd,BorderLayout.NORTH);
		add(ft,BorderLayout.SOUTH);
		add(hd,BorderLayout.NORTH);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("1")) {
			s[0].w_continue();
			b[0].setActionCommand("~1");
		}
		else if(arg0.getActionCommand().equals("2")) {
			s[1].w_continue();
			b[1].setActionCommand("~2");
		}
		else if(arg0.getActionCommand().equals("~1")) {
			s[0].w_stop();
			b[0].setActionCommand("1");
		}
		else if(arg0.getActionCommand().equals("~2")) {
			s[0].w_stop();
			b[0].setActionCommand("2");
		}
	}
	public static void main(String[] args) throws G_informative {
		Program p=new Program();
	}

}
