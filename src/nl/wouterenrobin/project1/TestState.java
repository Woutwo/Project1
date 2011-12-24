package nl.wouterenrobin.project1;

public class TestState extends State
{
	public float f;
	public void Update()
	{
		super.Update();
		f+=1;
		Camera.x=(float) Math.cos(f/10)*32;
		Camera.y=(float) Math.sin(f/10)*32;
	}
	public void Draw()
	{
		super.Draw();
		Images.test.draw(32f, 32f);
	}
}
