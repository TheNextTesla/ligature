package music;

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
		string = instring;
		values = new double[21];					
	}
	
	public void evaluateCalc()
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
			System.out.println("Error - Parse Failed");
			return;
		}
		
		
		for(int i = 0; i < values.length; i++)
		{
			CalcObject result = CalcSUB.numericSubstitute(evaluated, new CalcSymbol("x", new CalcNullEvaluator(), 0x0400), new CalcDouble(i));
			System.out.println(result.toString());
			try
			{

				values[i] = Double.parseDouble(result.evaluate().toString());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				values[i] = 0;
			}
		}
		
		new MusicPlayer(values).start();;
	}
}
