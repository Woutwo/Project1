package nl.wouterenrobin.project1;

import static org.lwjgl.opengl.GL11.GL_STENCIL_BUFFER_BIT;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Game
{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	// FPS counter:
	private static long time = System.currentTimeMillis();
	private static short framecount = 0;
	
	public static boolean finished = false; // Spel moet afsluiten
	
	public void start()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
			Display.setFullscreen(true);
		}
		catch(LWJGLException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glClearAccum(0f,0f,0f,1f);
		GL11.glClear(GL11.GL_ACCUM_BUFFER_BIT);
		
		while(!Display.isCloseRequested() && !finished)
		{
			if (System.currentTimeMillis()-time>1000)
			{
				System.out.println(framecount+" FPS");
				time = System.currentTimeMillis();
				framecount = 0;
			}
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
			
			GL11.glColor3f(1, 1, 1);
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, WIDTH,HEIGHT, 0, -10,10);
			Manager.DrawBackground();
			
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, WIDTH,HEIGHT, 0, -10,10);
			
			GL11.glTranslatef(-Camera.x, -Camera.y, 0);
			Display.sync(60);
			
			Manager.Draw();
			Manager.Update();
			
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, WIDTH,HEIGHT, 0, -10,10);
			Manager.DrawForeground();
			
			Display.update();
			
			framecount++;
		}
	}
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();
	}
}
