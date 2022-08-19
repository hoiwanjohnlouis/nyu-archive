// Code 10F
/** A frame with radio buttons on it.*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonAddedJFrame extends ClosableJFrame 
{
	private JRadioButton birdRadioButton;
	private JRadioButton catRadioButton;
	private JRadioButton dogRadioButton;
	private JRadioButton rabbitRadioButton;
	private JRadioButton pigRadioButton;
	private JLabel label;

	public JRadioButtonAddedJFrame()
	{
		// Instantiate the radio buttons with hot keys.
		birdRadioButton = new JRadioButton("Bird");
		birdRadioButton.setMnemonic(KeyEvent.VK_B);

		catRadioButton = new JRadioButton("Cat");
		catRadioButton.setMnemonic(KeyEvent.VK_C);

		dogRadioButton = new JRadioButton("Dog");
		dogRadioButton.setMnemonic(KeyEvent.VK_D);

		rabbitRadioButton = new JRadioButton("Rabbit");
		rabbitRadioButton.setMnemonic(KeyEvent.VK_R);

		pigRadioButton = new JRadioButton("Pig");
		pigRadioButton.setMnemonic(KeyEvent.VK_P);
		
		// make bird the selected one by default.
		birdRadioButton.setSelected(true);

		// Instantiate a button group.
		ButtonGroup rgRadio = new ButtonGroup();

		// add the buttons to the group.
		rgRadio.add(birdRadioButton);
		rgRadio.add(catRadioButton);
		rgRadio.add(dogRadioButton);
		rgRadio.add(rabbitRadioButton);
		rgRadio.add(pigRadioButton);

		// Register a listener for the radio buttons.
		birdRadioButton.addActionListener(new InnerActionListener());
		catRadioButton.addActionListener(new InnerActionListener());
		dogRadioButton.addActionListener(new InnerActionListener());
		rabbitRadioButton.addActionListener(new InnerActionListener());
		pigRadioButton.addActionListener(new InnerActionListener());

		// load 'bird.gif' on the label since
		// bird is selected by default.
		label = new JLabel(new ImageIcon("Bird" + ".gif"));

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image.
		// A real program would compute 
		label.setPreferredSize(new Dimension(177, 122));


		// Instantiate a panel.
		JPanel radioPanel = new JPanel();

		// set layout to one column grid.
		radioPanel.setLayout(new GridLayout(0, 1));

		// add the buttons to the panel.
		radioPanel.add(birdRadioButton);
		radioPanel.add(catRadioButton);
		radioPanel.add(dogRadioButton);
		radioPanel.add(rabbitRadioButton);
		radioPanel.add(pigRadioButton);

		// add the panel to the frame.
		getContentPane().add(radioPanel, BorderLayout.WEST);

		// add the label to the frame.
		getContentPane().add(label, BorderLayout.CENTER);
		}

		/** overridden action listener interface method that
		* loads pictures as the user selection changes.
		*/
		private class InnerActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				label.setIcon(new ImageIcon((
				(JRadioButton) e.getSource()).getText() + ".gif"));
			}
		}

		/** main method for testing this class.*/
		public static void main(String args[])
		{
			// instantiate an object of this class.
	         	JRadioButtonAddedJFrame frame = new JRadioButtonAddedJFrame();

			// resize and make it visible.
			frame.pack();
			frame.setVisible(true);
		}
}

