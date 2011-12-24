package nl.wouterenrobin.project1;

import org.lwjgl.input.Keyboard;

public class TestState extends State
{
	public float f;
	public void Update()
	{
		super.Update();
		f+=1;
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			Camera.y -= 5;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			Camera.y += 5;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			Camera.x -= 5;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			Camera.x += 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			Poppetje.jump();
		}
		
		Poppetje.update();
	}
	public void Draw()
	{
		super.Draw();
		Images.test.draw(-200f, -200f,1600f,1600f);
		Images.test.draw(Poppetje.x, Poppetje.y);
	}
}
