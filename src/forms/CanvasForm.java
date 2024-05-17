package forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utils.Constants;
import utils.ImageManager;

/**
 * This file contains the canvas, and the main function is to propagate the clicks, events, delta time,
 * to the main menu and consequently to the classes inside the menu.
 * 
 * @author angel
 *
 */
public class CanvasForm extends JComponent {

	private static final long serialVersionUID = 1L;
	private final BufferedImage testImage;

	public CanvasForm() {
		testImage =  ImageManager.readImage("1-1.png");

		// start the thread
		//new Thread(this).start();
	}
	
	public void repaintGame() {
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Constants.BACKGROUND_COLOR);
		g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);


		//g.drawImage(grabImage(testImage, 0, 0, 192, 192), 200, 0, 200, 200, this);
		g.drawImage(testImage, 200, 0, 145, 200, this);
		g.setColor(Color.BLACK);
	}

	public BufferedImage grabImage(BufferedImage image, int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * 48), (row * 48), 48, 48);
		//return image; typo here!
		return img;
	}

	/**
	 * This is the method that moves all the objects by updating their coordinates every tick call.
	 * A tick represent how many calls we make per second to this method, so this "dt" represents the
	 * UPS = updates per second
	 * 
	 * Example:
	 * 	1dt/seg  (1dt  means we are calling this method once per second)
	 *	2dt/seg  (2dt  means we are calling this method two times per second)
	 *	60dt/seg (60dt means we are calling this method sixty times per second)
	 *
	 * Example 1: 1dt and speed of object = 30
	 * by using d = s/t (distance = speed/ time)
	 * 
	 * Calculate new location
	 * 		1) d = 30 / 1dt
	 * 		   d = 30
	 * 		2) this means the object moves a distance of 30 per second(then in 60 calls we also have a distance of 30)
	 * 
	 * Example 2: 2dt and speed of object = 30
	 * by using d = s/t (distance = speed/ time)
	 * 
	 * Calculate new location
	 * 		1) d = 30 / 2
	 * 		   d = 15
	 * 		2) this means the object moves a distance of 15 in every call(then in 2 calls we also have a distance of 30)
	 *
	 * Example 3: 60dt and speed of object = 30
	 * by using d = s/t (distance = speed/ time)
	 * 
	 * Calculate new location
	 * 		1) d = 30 / 60
	 * 		   d = 0.5
	 * 		2) this means the object moves a distance of 0.5 in every call(then in 60 calls we also have a distance of 30)
	 * 
	 * @param dt - Delta Time
	 */
	public void tick(double dt) {
		/* Example, where lengthdir_x =
		public double lengthdir_x(double len, double dir)
	    {
		        return len * Math.cos(Math.toRadians(dir - 90)); // calculate direction of x using angles
		}
		x += lengthdir_x(speed/dt, directionAngle);
		y += lengthdir_y(speed/dt, directionAngle);*/

		//System.out.println("Delta time: " + dt);
	}

	public void propagateClick(Point point) {
		System.out.println("Click: X = " + point.getX() + ", Y = " + point.getY());
	}

	public void propagateDrag(Point point) {
		System.out.println("Drag: X = " + point.getX() + ", Y = " + point.getY());
	}
}
