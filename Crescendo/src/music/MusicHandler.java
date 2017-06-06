package music;

import com.autsia.bracer.BracerParser;

import javacalculus.core.CalcParser;
import javacalculus.core.CalculusEngine;
import javacalculus.evaluator.CalcSUB;
import javacalculus.evaluator.extend.CalcNullEvaluator;
import javacalculus.exception.CalcSyntaxException;
import javacalculus.struct.CalcDouble;
import javacalculus.struct.CalcObject;
import javacalculus.struct.CalcSymbol;

public class MusicHandler
{
	private String string;
	private double[] values;
	
	public MusicHandler(String instring)
	{
		string = stringSkim(instring);
		values = new double[21];					
	}
	
	private String stringSkim(String skim)
	{
		String stringTemp = "";
		for(int i = 0; i < skim.length(); i++)
		{
			if(!skim.substring(i, i+1).equals("x"))
			{
				stringTemp += skim.substring(i, i+1).toUpperCase();
			}
			else
			{
				stringTemp += "x";
			}
		}
		return stringTemp;
	}
	
	public void evaluate()
	{
		CalcParser calcParser = new CalcParser();
		CalcObject parsed = null;
		CalcObject evaluated = null;
		try 
		{
			parsed = calcParser.parse(string);
			evaluated = parsed.evaluate();
		}
		catch (CalcSyntaxException e1) 
		{
			e1.printStackTrace();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(parsed == null || evaluated == null)
		{
			return;
		}
		
		
		for(int i = 0; i < values.length; i++)
		{
			BracerParser bracerParser = new BracerParser(5);
			CalcObject result = CalcSUB.numericSubstitute(evaluated, new CalcSymbol("x", new CalcNullEvaluator(), 0x0400), new CalcDouble(i));
			try
			{
				bracerParser.parse(result.toString());
				values[i] = Double.parseDouble(bracerParser.evaluate());
			}
			catch(Exception e)
			{
				values[i] = 0;
			}
		}
		
		new MusicPlayer(values);
	}
}
