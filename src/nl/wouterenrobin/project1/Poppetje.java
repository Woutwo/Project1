package nl.wouterenrobin.project1;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;

public class Poppetje {
	public TestState s;
	public float x = 128;
	public float y = 128;
	public float xspeed,yspeed;
	public float gravity = 0.5f;
	public boolean onground = true;
	public Image plaatje = Images.test;
	
	public Poppetje(TestState s)
	{
		this.s = s;
		Random r = new Random();
		x = r.nextFloat()*200;
		y = r.nextFloat()*200;
	}
	
	public void jump() {
		System.out.println("Springnngg");
		if(onground)
		{
			yspeed = -10;
			onground = false;
		}
	}

	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			jump();
		}
		if(!onground)
		{
			y+=yspeed;
			yspeed+=gravity;
		}
		else
		{
			yspeed=0;
		}
		
		if(y >= 128){
			y = 128;
			onground = true;
		}
		else
		{
			onground  = false;
		}
	}
	
	public void draw()
	{
		plaatje.draw(x, y);
	}
}
