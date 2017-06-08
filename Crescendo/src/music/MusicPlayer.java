package music;

import org.jfugue.player.Player;

public class MusicPlayer extends Thread
{
	private double[] fvalues;
	
	MusicPlayer(double[] values)
	{
		fvalues = values;
	}
	
	public void run()
	{
		double maxvalue = Math.abs(fvalues[0]);
		double minvalue = Math.abs(fvalues[0]);
		String string = "";
		for(int i = 1; i<fvalues.length; i++)
		{
			if(Math.abs(fvalues[i]) > maxvalue)
			{
				maxvalue = fvalues[i];
			
			}
			if(Math.abs(fvalues[i]) < minvalue)
			{
				minvalue = fvalues[i];
			
			}
				
		}
		System.out.println("Min " + minvalue);
		for(int i = 0; i < fvalues.length - 1; i++)
		{
			int tempint = (int) Math.ceil((fvalues[i]-minvalue)/(maxvalue != 0 ? maxvalue : 1)*7);
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
			System.out.print(tempint + " ");
		}
		
		System.out.println("\n" + string);
		Player player = new Player();
		player.play(string);
	}
}
