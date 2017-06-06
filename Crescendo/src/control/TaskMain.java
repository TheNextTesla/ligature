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

	}
}
