package control;

import com.autsia.bracer.BracerParser;

import display.FrameCore;
import javacalculus.core.CALC;
import javacalculus.core.CalcParser;
import javacalculus.core.CalculusEngine;
import javacalculus.evaluator.CalcABS;
import javacalculus.evaluator.CalcCOS;
import javacalculus.evaluator.CalcPLOT;
import javacalculus.evaluator.CalcSIN;
import javacalculus.evaluator.CalcSUB;
import javacalculus.evaluator.extend.Calc1ParamFunctionEvaluator;
import javacalculus.evaluator.extend.CalcNullEvaluator;
import javacalculus.exception.CalcSyntaxException;
import javacalculus.struct.CalcDouble;
import javacalculus.struct.CalcFunction;
import javacalculus.struct.CalcObject;
import javacalculus.struct.CalcSub;
import javacalculus.struct.CalcSymbol;

public class TaskMain
{
	public static void main(String[] args) 
	{
		new FrameCore();

		try
		{
			BracerParser bracerParser = new BracerParser(3);
			bracerParser.parse("sin(0");
			System.out.println(bracerParser.evaluate());
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			/*
			String function = "PLOT(sin(x),x)";
			CalculusEngine cengine = new CalculusEngine();
			cengine.execute(function);
			*/
			
			/*
			String function = "sin(x) = x";
			CalcParser cvaluate = new CalcParser();
			CalcObject cobject = cvaluate.parse(function);
			CalcPLOT cplot = new CalcPLOT();
			
			//System.out.println(cobject.getHeader().toString());
			System.out.println(cobject.evaluate().toString());
			
			CalcSub cfunctiontemp = (CalcSub) cobject;
			//CalcFunction cfunction = new CalcFunction(cobject.getHeader(), (CalcFunction) cfunctiontemp.evaluateParameters(), 0, 10);
			CalcFunction cfunction = (CalcFunction) cobject;
			
			//System.out.println(cfunction.getHeader().toString());
			
			cplot.evaluate(cfunctiontemp);
			System.out.println(cplot.getYValue(1));
			*/
			
			/*
			double x = 0;
			String string = "cos(sin(x))";
			CalcObject input = new CalcParser().parse(string);
			//CalcFunction function = new CalcFunction(input.getHeader(), new CalcParser().parse("sin(x)"));
			//System.out.println(function.toString());
			
			CalculusEngine engine = new CalculusEngine();
			CalcObject result = CalcSUB.numericSubstitute(input, new CalcSymbol("x", new CalcABS(), 0x0400), new CalcDouble(x));
			//TestAPI.print(result.toString());
			
			CalcFunction result2 = (CalcFunction) result;
			CalcFunction result3 = new CalcFunction(result2.getHeader(), result2.get(0));
			CalcSub result4 = (CalcSub) result;
			
			System.out.println(result2.get(0));
			System.out.println(result3.toString());
			System.out.println(result.getHeader().toString());
			System.out.println(result.toString());
			System.out.println(result4.evaluate().toString());
			*/
			
			//System.out.println(new CalculusEngine().execute("sin(0)"));
	}
}
