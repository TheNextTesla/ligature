package display;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCore extends JFrame
{

	/**
	 * Requested by JFrame
	 */
	private static final long serialVersionUID = -1140522721030212890L;
	

	
	public FrameCore()
	{
		this.setSize(300, 50);
		this.setMinimumSize(new Dimension(300, 50));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ligature");
		
		JPanel panelCore = new PanelCore();
		this.add(panelCore);
	}
}
