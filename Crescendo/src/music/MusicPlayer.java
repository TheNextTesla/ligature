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
		String[] notes = new String[fvalues.length];
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
		for(int i =0; i<fvalues.length; i++)
		{
			int tempint = (int) Math.ceil((fvalues[i]-minvalue)/maxvalue*7);
			switch(tempint)
			{
			case 1:
				notes[i] = "C";
			case 2:
				notes[i] = "D";
			case 3:
				notes[i] = "E";
			case 4:
				notes[i] = "F";
			case 5:
				notes[i] = "G";
			case 6:
				notes[i] = "A";
			case 7:
				notes[i] = "B";
			}
			
				
		}
		
		Player player = new Player();
		player.play(notes);
	}
}
