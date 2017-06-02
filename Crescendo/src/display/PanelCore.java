package display;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCore extends JPanel
{

	/**
	 * Requested by JPanel
	 */
	private static final long serialVersionUID = -5000726430470197351L;
	
	private JTextField equationEntry;
	private JComboBox<String> differentialStatus;
	private JButton runButton;
	
	private final String[] statusOptions = {"Base", "Diff", "Int"};
	
	public PanelCore()
	{
		equationEntry = new JTextField(5);
		differentialStatus = new JComboBox<>(statusOptions);
		runButton = new JButton("Run");
	}
}
