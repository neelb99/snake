package applet;

import java.util.Random;

public class apple {
	int xapp, yapp;
	Random r = new Random();
	apple()
	{
		xapp=r.nextInt(800-50);
		yapp=r.nextInt(600-60);
	}
}
