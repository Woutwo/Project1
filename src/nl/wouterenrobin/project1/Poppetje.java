package nl.wouterenrobin.project1;

import org.newdawn.slick.Image;

public class Poppetje {
	public static float x = 128;
	public static float y = 128;
	public static double velocity;
	public static double vgravity;
	public static double vspeed;
	public static boolean onground = true;
	public static Image plaatje;
	
	public static void init() {
		plaatje = Images.test;
	}
	
	public static void jump() {
		System.out.println("Springnngg");
		if(onground){
			velocity = -10;
			vgravity = 1.0005;
			onground = false;
		}
	}

	public static void update() {
		if(!onground){
			vgravity *= vgravity;
			velocity += vgravity;
			
			vspeed = velocity;
			y += vspeed;
		}else{
			velocity = 0;
			vgravity = 0;
			vspeed   = 0;
		}
		
		if(y > 128){
			y = 128;
			onground = true;
		}
	}
}
