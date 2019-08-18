package applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class snake{
	boolean moving = false;
	int length=1;
	bodypart b[] = new bodypart[50];
	
	snake()
	{
		b[0] = new bodypart();
		b[0].setdata(100,100);
	}
	
	boolean out()
	{
		for(int i=0;i<length;i++)
			if(b[i].outofbounds())
				return true;
		return false;
	}
	boolean checkcollision()
	{
		if(length>1)
		{
			for(int i=1;i<length;i++)
				if((Math.abs(b[0].x-b[i].x)<5) && (Math.abs(b[0].y-b[i].y)<5))
					return true;
		}
		return false;
	}
	void move(int xvel,int  yvel)
	{
		
		Timer t = new Timer(1,null);
		t.addActionListener(new ActionListener() {
			int xpos,ypos;
			int i=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i==0)
				{
					b[i].move(xvel, yvel);
					xpos = b[i].x;
					ypos = b[i].y;
					i++;
				}
				else if(b[i].x==xpos && b[i].y==ypos)
				{
					
					b[i].move(xvel, yvel);
					i++;
				}
				
				
				if(i==length)
					t.stop();
			}
			
		});
		t.start();	
	
	}
	
}
