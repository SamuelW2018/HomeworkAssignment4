import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Threadtest function, which displays the interface for the yahtzee game. The functions here are misspelled.
 * @author swynsma18
 *
 */
public class TheadTest extends JFrame{
	JFrame frame;
	
	/**
	 * Constructor for the ThreadTest object. This adds a new JFrame and sets the size, close operation, and layout of the JFrame.
	 */
	public TheadTest()
	{
		frame = new JFrame();
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
	}
	
	/**
	 * This is the main function for the program. It creates a threadTest, five dice, and a JLabel to store the dice.
	 * It also adds a button which allows the program to roll the dice. The program creates five threads
	 * when this button is pressed, each corresponding to a different die.
	 * @param args
	 */
	public static void main(String[] args)
	{
		TheadTest T = new TheadTest();
		Die[] dice = new Die[5];
		for (int i = 0; i < 5; i++)
		{
			JLabel l = new JLabel();
			dice[i] = new Die(l);
			T.frame.add(l);
		}
		
		JButton button = new JButton("roll");
		JButton button2 = new JButton("Calculate");
		JLabel Rolled = new JLabel("0");
		T.frame.add(button);
		T.frame.add(button2);
		T.frame.add(Rolled);
		button.addActionListener(new ActionListener()
				{
					@Override
					/**
					 * This starts the dice rolling
					 */
					public void actionPerformed(ActionEvent E ) {
						// TODO Auto-generated method stub
						
						Thread[] ts = new Thread[5];
						for (int j = 0; j < 5; j++)
						{
							ts[j] = new Thread(dice[j]);
							ts[j].start();
						}		
						
					}
				});
		button2.addActionListener(new ActionListener(){
			/**
			 * This checks the dice count total.
			 */
			public void actionPerformed(ActionEvent E)
			{
				int Roll = 0;
				for (int k = 0; k < 5; k++)
				{
					Roll += dice[k].getInt();
				}
				Rolled.setText(""+Roll);
			}
		});

		T.frame.setVisible(true);

		
	}
}
