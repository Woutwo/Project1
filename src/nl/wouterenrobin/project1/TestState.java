package nl.wouterenrobin.project1;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

public class TestState extends State
{
	public float f;
	
	ArrayList<Poppetje> poplist = new ArrayList<Poppetje>();
	
	public TestState()
	{
		super();
		for(int i = 0; i<1000; i++)
		{
			poplist.add(new Poppetje(this));
		}
	}
	
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
		
		@SuppressWarnings("unchecked")
		List<Poppetje> copy = (List<Poppetje>) poplist.clone();
		for(Poppetje p:copy)
		{
			p.update();
		}
	}
	public void Draw()
	{
		super.Draw();
		Images.test.draw(-200f, -200f,1600f,1600f);
		@SuppressWarnings("unchecked")
		List<Poppetje> copy = (List<Poppetje>) poplist.clone();
		for(Poppetje p:copy)
		{
			p.draw();
		}
	}
}
