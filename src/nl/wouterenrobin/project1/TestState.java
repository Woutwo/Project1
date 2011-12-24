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
			Camera.y--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			Camera.y++;
		}
	}
	public void Draw()
	{
		super.Draw();
		Images.test.draw(-200f, -200f,1600f,1600f);
		Images.test.draw(32f, 32f);
	}
}
