package display;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Configuration;

public class FrameCore extends JFrame
{

	/**
	 * Requested by JFrame
	 */
	private static final long serialVersionUID = -1140522721030212890L;
	
	private JPanel panelCore;
	
	private final String[] statusOptions = {"Base", "Diff", "Int"};
	
	private JTextField equationEntry;
	private JComboBox<String> differentialStatus;
	private JButton runButton;
	
	public FrameCore()
	{
		this.setSize(300, 50);
		this.setMinimumSize(new Dimension(300, 50));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Configuration.WINDOW_NAME_DEFAULT);
		
		panelCore = new PanelCore();
		GroupLayout groupLayout = new GroupLayout(panelCore);
		panelCore.setLayout(groupLayout);
		
		equationEntry = new JTextField(5);
		differentialStatus = new JComboBox<>(statusOptions);
		runButton = new JButton("Run");
		
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup
				(
						groupLayout.createSequentialGroup()
				);
		
		this.add(panelCore);
		this.setVisible(true);
	}
}
