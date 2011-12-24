package nl.wouterenrobin.project1;

public class Manager
{
	public static State s;
	public static State overlaystate;
	public static void Update()
	{
		if(overlaystate!=null)
		overlaystate.Update();
		if (overlaystate==null || (overlaystate!=null && !overlaystate.pause))
		s.Update();
	}
	public static void Draw()
	{
		s.Draw();
		if(overlaystate!=null){overlaystate.Draw();}
	}
	public static void DrawBackground()
	{
		s.DrawBackground();
		if(overlaystate!=null){overlaystate.DrawBackground();}
	}
	public static void DrawForeground()
	{
		s.DrawForeground();
		if(overlaystate!=null){overlaystate.DrawForeground();}
	}
}
