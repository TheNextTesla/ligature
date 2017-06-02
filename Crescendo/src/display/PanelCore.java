package display;

import java.awt.Color;

import javax.swing.JPanel;

import control.Configuration;

public class PanelCore extends JPanel
{

	/**
	 * Requested by JPanel
	 */
	private static final long serialVersionUID = -5000726430470197351L;
	
	private Color backgroundColor;
	
	public PanelCore()
	{
		backgroundColor = Configuration.WINDOW_COLOR_DEFAULT;
		
		this.setBackground(backgroundColor);
		this.setVisible(true);
	}
	
	public void updateColor(Color newColor)
	{
		backgroundColor = newColor;
		this.setBackground(backgroundColor);
	}
}
