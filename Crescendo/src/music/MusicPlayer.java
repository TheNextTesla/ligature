package music;

import org.jfugue.player.Player;

public class MusicPlayer
{
	private double[] fvalues;
	MusicPlayer(double[] values)
	{
		fvalues = values;
		double maxvalue = 0;
		double minvalue = 0;
		String string = "";
		for(int i = 0; i<fvalues.length; i++)
		{
			if(fvalues[i]> maxvalue)
			{
				maxvalue = fvalues[i];
			
			}
			if(fvalues[i]< minvalue)
			{
				minvalue = fvalues[i];
			
			}
				
		}
		for(int i = 0; i < fvalues.length; i++)
		{
			int tempint = (int) Math.ceil((fvalues[i]-minvalue)/maxvalue*7);
			//System.out.println(tempint);
			switch(tempint)
			{
			case 1:
				string += "C ";
				break;
			case 2:
				string += "D ";
				break;
			case 3:
				string += "E ";
				break;
			case 4:
				string += "F ";
				break;
			case 5:
				string += "G ";
				break;
			case 6:
				string += "A ";
				break;
			case 7:
				string += "B ";
				break;
			default:
				string += "C ";
				break;
			}
			System.out.println(tempint);
		}
		
		System.out.println(string);
		Player player = new Player();
		player.play(string);
	}
}
