package applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class panel extends JPanel implements ActionListener
{
	snake s = new snake();
	Timer t = new Timer(1,this);
	apple a = new apple();

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<s.length;i++)
		{
			s.b[i].x+=s.b[i].velx;
			s.b[i].y+=s.b[i].vely;
			repaint();
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		
		g.clearRect(0, 0, 800,600);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800,600);
		g.setColor(Color.RED);
		g.fillRect(a.xapp, a.yapp, 10, 10);
		g.setColor(Color.GREEN);
		for(int i=0;i<s.length;i++)
			g.fillOval(s.b[i].x, s.b[i].y, 20,20);
		s.b[0].eye();
		g.setColor(Color.BLACK);
		g.fillOval(s.b[0].eyex1,s.b[0].eyey1 , 5, 5);
		g.fillOval(s.b[0].eyex2,s.b[0].eyey2 , 5, 5);
		g.setColor(Color.GREEN);
		if(s.out() || s.checkcollision())
		{
			t.stop();
			g.drawString("Game Over!", 300, 250);
		}
		else
			t.restart();
		if((Math.abs(s.b[0].x-a.xapp)<=20) && (Math.abs(s.b[0].y-a.yapp)<=20))
		{	
			s.length++;
			
			s.b[s.length-1]= new bodypart();
			if(s.b[s.length-2].velx!=0)
			{
				s.b[s.length-1].setdata(s.b[s.length-2].x+10*(s.b[s.length-2].velx/2*-1), s.b[s.length-2].y);
				s.b[s.length-1].velx=s.b[s.length-2].velx;
			}
			else if(s.b[s.length-2].vely!=0)
			{
				s.b[s.length-1].setdata(s.b[s.length-2].x, s.b[s.length-2].y+10*(s.b[s.length-2].vely/2)*-1);
				s.b[s.length-1].vely=s.b[s.length-2].vely;
			}
			s.b[s.length-1].move(s.b[s.length-2].velx, s.b[s.length-2].vely);
			a=new apple();
		}
		
	}

}
