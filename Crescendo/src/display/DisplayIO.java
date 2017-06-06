package display;

public class DisplayIO 
{
	private static DisplayIO displayIO;
	
	private FrameCore frameCore;
	
	private DisplayIO()
	{
		frameCore = new FrameCore();
	}
	
	public static DisplayIO getInstance()
	{
		if(displayIO == null)
		{
			displayIO = new DisplayIO();
		}
		return displayIO;
	}
	
	public FrameCore getFrame()
	{
		return frameCore;
	}
}
