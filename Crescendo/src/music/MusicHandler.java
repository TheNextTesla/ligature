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
		System.out.println(stringTemp);
		return stringTemp;
	}
	
	private String stringSkimReverse(String skim)
	{
		String stringTemp = "";
		for(int i = 0; i < skim.length(); i++)
		{
			if(!skim.substring(i, i+1).equals("x") && ((skim.charAt(i) < '0') || (skim.charAt(i) > '9')))
			{
				System.out.println("Lower");
				stringTemp += skim.substring(i, i+1).toLowerCase();
			}
			else
			{
				stringTemp += skim.substring(i, i+1);
			}
		}
		System.out.println(stringTemp);
		return stringTemp;
	}
	
	public void evaluateBase()
	{
		String localString = stringSkimReverse(string).replaceAll("x", "var");
		for(int i = 0; i < values.length; i++)
		{
			BracerParser bracerParser = new BracerParser(5);
			try
			{
				bracerParser.parse(localString);
				values[i] = Double.parseDouble(bracerParser.evaluate(i).replaceAll(",", ""));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				values[i] = 0;
			}
			System.out.println(values[i]);
		}
		
		new MusicPlayer(values).start();;
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
			BracerParser bracerParser = new BracerParser(5);
			CalcObject result = CalcSUB.numericSubstitute(evaluated, new CalcSymbol("x", new CalcNullEvaluator(), 0x0400), new CalcDouble(i));
			System.out.println(result.toString());
			try
			{
				bracerParser.parse(stringSkimReverse(result.toString()));
				values[i] = Double.parseDouble(bracerParser.evaluate());
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
