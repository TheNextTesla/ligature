package display;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.Configuration;
import music.MusicHandler;

public class FrameCore extends JFrame
{

	/**
	 * Requested by JFrame
	 */
	private static final long serialVersionUID = -1140522721030212890L;
	
	private JPanel panelCore;
	
	private JLabel informLabel;
	private JTextField equationEntry;
	private JRadioButton baseButton;
	private JRadioButton diffButton;
	private JRadioButton intButton;
	private ButtonGroup radioButtons;
	private JButton runButton;
	
	public FrameCore()
	{
		this.setSize(Configuration.WINDOW_SIZE_DEFAULT_WIDTH, Configuration.WINDOW_SIZE_DEFAULT_HEIGHT);
		this.setMinimumSize(new Dimension(Configuration.WINDOW_SIZE_DEFAULT_WIDTH, Configuration.WINDOW_SIZE_DEFAULT_HEIGHT));
		this.setMaximumSize(new Dimension(Configuration.WINDOWS_SIZE_MAX_WIDTH, Configuration.WINDOW_SIZE_MAX_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Configuration.WINDOW_NAME_DEFAULT);
		
		panelCore = new PanelCore();
		GroupLayout groupLayout = new GroupLayout(panelCore);
		panelCore.setLayout(groupLayout);
		
		informLabel = new JLabel("Equation:");
		equationEntry = new JTextField(5);
		baseButton = new JRadioButton("Base");
		diffButton = new JRadioButton("Diff");
		intButton = new JRadioButton("Int");
		runButton = new JButton("Run");
		radioButtons = new ButtonGroup();
		
		radioButtons.add(baseButton);
		radioButtons.add(diffButton);
		radioButtons.add(intButton);
		
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup
				(
						groupLayout.createParallelGroup()
							.addGroup(groupLayout.createSequentialGroup()
									.addComponent(informLabel)
									.addGroup(groupLayout.createParallelGroup()
											.addComponent(equationEntry)
											.addGroup(groupLayout.createSequentialGroup()
													.addComponent(baseButton)
													.addComponent(diffButton)
													.addComponent(intButton)))
									.addComponent(runButton))
				);
		groupLayout.setVerticalGroup
				(
						groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(informLabel)
									.addComponent(equationEntry)
									.addComponent(runButton))
							
							.addGroup(groupLayout.createParallelGroup()
									.addComponent(baseButton)
									.addComponent(diffButton)
									.addComponent(intButton))
				);
		
		runButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						if(!equationEntry.getText().equals(""))
						{
							if(baseButton.isSelected())
							{
								MusicHandler musicHandler = new MusicHandler(equationEntry.getText());
								musicHandler.evaluateCalc();
							}
							else if(diffButton.isSelected())
							{
								MusicHandler musicHandler = new MusicHandler("DIFF(" + equationEntry.getText() + ",x)");
								musicHandler.evaluateCalc();
							}
							else if(intButton.isSelected())
							{
								MusicHandler musicHandler = new MusicHandler("INT(" + equationEntry.getText() + ",x)");
								musicHandler.evaluateCalc();
							}
							else
							{
								JOptionPane.showMessageDialog(null, Configuration.POPUP_WINDOW_NOTICE);
							}
						}
					}
				});
		
		this.add(panelCore);
		this.setVisible(true);
	}
}
