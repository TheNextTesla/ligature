package music;

import javacalculus.core.CalcParser;
import javacalculus.core.CalculusEngine;
import javacalculus.evaluator.CalcPLOT;
import javacalculus.evaluator.CalcSUB;
import javacalculus.evaluator.extend.CalcNullEvaluator;
import javacalculus.exception.CalcSyntaxException;
import javacalculus.struct.CalcDouble;
import javacalculus.struct.CalcFunction;
import javacalculus.struct.CalcObject;
import javacalculus.struct.CalcSymbol;

public class MusicHandler
{
	private String string;
	private double[] values;
	
	public MusicHandler(String instring)
	{
		string = fixcase(instring);
		values = new double[21];
	}
	
	private String fixcase(String instring)
	{
		String returnstring = "";
		for(int i =0; i<instring.length(); i++)
		{
			if(instring.substring(i, i+1).equals("x"))
			{
				returnstring += instring.substring(i,i+1);
			}
			else
			{
				returnstring += instring.substring(i,i+1).toUpperCase();
			}
		}
		return returnstring;
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
			System.out.println(string);
			return;
		}
		
		
		CalcObject tempobject = new CalcFunction(new CalcSymbol("calcsymbol", new CalcNullEvaluator(), 0x0400), evaluated, new CalcSymbol("x", new CalcNullEvaluator(), 0x0400));
		CalcPLOT graph = new CalcPLOT();
		graph.evaluate((CalcFunction) tempobject);
		
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
