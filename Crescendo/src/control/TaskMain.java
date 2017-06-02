package control;

import display.FrameCore;
import javacalculus.core.CalcParser;
import javacalculus.evaluator.CalcPLOT;
import javacalculus.exception.CalcSyntaxException;
import javacalculus.struct.CalcFunction;
import javacalculus.struct.CalcObject;
import javacalculus.struct.CalcSymbol;

public class TaskMain
{
	public static void main(String[] args) 
	{
		new FrameCore();

		try
		{
			String function = "sin(x)";
			CalcParser cvaluate = new CalcParser();
			CalcObject cobject = cvaluate.parse(function);
			CalcPLOT cplot = new CalcPLOT();
			cplot.evaluate(new CalcFunction(new CalcSymbol("x"), cobject));
			System.out.println(cplot.getYValue(1));
		}
		catch(CalcSyntaxException cse)
		{
			cse.printStackTrace();
		}
	}
}
