package nl.wouterenrobin.project1;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Images
{
	public static final Image test = loadImage("test"); 
			
	public static final Image loadImage(String s)
	{
		Image i = null;
		try {
			i = new Image(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/"+s+".png"),GL11.GL_NEAREST));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
}
