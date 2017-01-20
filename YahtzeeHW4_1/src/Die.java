import java.awt.*;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

/**
 * Die is an object on screen. It is runnable, and each die will be rolled to display an image w/ a value associated with it.
 * @author swynsma18
 *
 */
public class Die implements Runnable{

	//static Image ourImage;
	static int imageWidth = 100, imageHeight = 100;
	private JLabel L;
	private int DieRoll;
	/**
	 * Constructor for die. Takes a label and use it to display the picture.
	 * @param ourL is the label being passed in.
	 */
	public Die(JLabel ourL)
	{
		L = ourL;
	}
	@Override
	/**
	 * This calls the thread for the die object. This function rolls the die, giving it a random number and picture.
	 * First, it generates a random number of times the die will change, from 0 to 500.
	 * Then, for each of these 0-500 iterations, it randomly generates the number and gives it an image based on the number generated.
	 * For example, if "2" is rolled by the random number generator, an image of a "2" on a die will be shown.
	 * At the end, the die will land on the value/image it has after the 0-500 iterations.
	 */
	public void run() {
		Random Q = new Random();
		int S = Q.nextInt(300);
		for(int i = S; i >= 0; i--){
			Random R = new Random();
			int T = R.nextInt(6);
			T += 1;
			URL imgu;
			
			if (T == 1)
			{
				imgu = getClass().getResource("/graphics/One.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			else if(T == 2)
			{
				imgu = getClass().getResource("/graphics/Two.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			else if(T == 3)
			{
				imgu = getClass().getResource("/graphics/Three.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			else if(T == 4)
			{
				imgu = getClass().getResource("/graphics/Four.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			else if(T == 5)
			{
				imgu = getClass().getResource("/graphics/Five.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			else
			{
				imgu = getClass().getResource("/graphics/Six.png");
				Image ourImage = Toolkit.getDefaultToolkit().getImage(imgu);
				ourImage = ourImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(ourImage);
				L.setIcon(icon);
			}
			DieRoll = T;
			
//			try{
//				Thread.sleep(500);
//			}
//			catch (InterruptedException ex) {;}
			

		}
	}
	
	/**
	 * Gets the number on the die for the calculate function in main.
	 * @return the number on the die
	 */
	public int getInt()
	{
		return DieRoll;
	}

}
