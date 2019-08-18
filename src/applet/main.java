package applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class main
{
	
	public static void main(String args[])
	{
		frame f = new frame();
		panel p = new panel();
		f.add(p);
		p.setFocusable(true);
		p.requestFocus();
		p.addKeyListener(new KeyListener() 
		{
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) 
			{
				
				if(e.getKeyCode()==38)
				{	
					if(p.s.b[0].vely==0)
						p.s.move(0,-2);
				}
				
				else if(e.getKeyCode()==39)
				{
					if(p.s.b[0].velx==0)
						p.s.move(2,0);
				}
				
				
				else if(e.getKeyCode()==37)
				{
					if(p.s.b[0].velx==0)
						p.s.move(-2,0);
				}
				
				else if(e.getKeyCode()==40)
				{
					
					if(p.s.b[0].vely==0)
						p.s.move(0,2);
				}
			
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				
			}
		});
	}
}