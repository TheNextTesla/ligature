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
	
	MusicHandler(String instring)
	{
		string = instring;
		values = new double[20];					
	}
	
	void evaluate()
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
		
		
		for(int i = 0; i <20; i++)
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
