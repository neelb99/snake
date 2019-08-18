package applet;

public class bodypart 
{
	int x,y,velx,vely,eyex1,eyex2,eyey1,eyey2;
	
	boolean outofbounds()
	{
		if(x+40>800 || x<0 || y+60>600 || y<0)
			return true;
	return false;
	}
	
	void setdata(int a,int b)
	{
		this.x=a;
		this.y=b;
		eyex1 = x+12;
		eyex2= x+12;
		eyey1= y+3;
		eyey2= y+12;
	}
	void move(int p,int q)
	{
		velx=p;
		vely=q;
	}

	void eye()
	{
		if(velx>0)
		{
			eyex1 = x+12;
			eyex2= x+12;
			eyey1= y+3;
			eyey2= y+12;
		}
		else if(velx<0)
		{
			eyex1 = x+3;
			eyex2= x+3;
			eyey1= y+3;
			eyey2= y+12;
		}
		else if(vely<0)
		{
			eyex1 = x+3;
			eyex2= x+12;
			eyey1= y+3;
			eyey2= y+3;
		}
		else if(vely>0)
		{
			eyex1 = x+3;
			eyex2= x+12;
			eyey1= y+12;
			eyey2= y+12;
		}
	}
}
