package metodos;

import android.util.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class Intervalo {
    double inferior;
    double superior;

    public Intervalo(double inferior, double superior) {
        this.inferior = inferior;
        this.superior = superior;
    }
}

interface Function {
    Double evaluate(Double x);
}

class Integral {
    Function f;
    Intervalo intervalo;
    Integer subintervalos;

    public Integral(Function f, Intervalo intervalo, int subintervalos) {
        this.f = f;
        this.intervalo = intervalo;
        this.subintervalos = subintervalos;
    }

    double simpson(){
        double a = intervalo.inferior;
        double b = intervalo.superior;
        double longitud = (b-a)/subintervalos;

        double F = 0;
        double I = 0;
        double P = 0;

        double fx0 = f.evaluate(a);
        for(int i = 1; i<subintervalos; i++) {
            double xi = a+i*longitud;
            if (i%2 == 1)
                I += f.evaluate(xi);
            else
                P += f.evaluate(xi);
        }
        double fxn = f.evaluate(b);

        F = (fx0 + 4*I + 2*P +fxn)*(longitud)/3.;

        return F;
    }
}

public class Metodos {

    public static String sendParams(String stringFunction, String a, String b, String subintervalosS) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");

        Function functionFS = (Double x) -> {
            try {
                String stringToEvaluate = stringFunction.toLowerCase();
                stringToEvaluate = stringToEvaluate.replaceAll("x", x.toString());
                stringToEvaluate = stringToEvaluate.replaceAll("\\^", "**");
                stringToEvaluate = stringToEvaluate.replaceAll("sin", "Math.sin");
                stringToEvaluate = stringToEvaluate.replaceAll("cos", "Math.cos");
                stringToEvaluate = stringToEvaluate.replaceAll("√", "Math.sqrt");
                stringToEvaluate = stringToEvaluate.replaceAll("e", "Math.E");
                Log.i("x: ",stringToEvaluate);
                //Object evalu = engine.eval("1*2");
                return (Double)engine.eval(stringToEvaluate);

            }catch (ScriptException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                return Double.NaN;
            }
        };

        Intervalo intervalo = new Intervalo(Double.valueOf(a),Double.valueOf(b));
        int subintervalos = Integer.valueOf(subintervalosS);

        Integral integral = new Integral(functionFS, intervalo, subintervalos);
        double F = integral.simpson();

        return String.valueOf(F);
    }

    //ScriptEngineManager mgr = new ScriptEngineManager();
    //ScriptEngine engine = mgr.getEngineByName("rhino");

    /*String stringFunction = "x*x + (5 + Math.sin(x))";
    Intervalo intervalo = new Intervalo(.5, 1.2);
    int gaaa = 500 ;
*/
    //Double res = sendParams(stringFunction, intervalo, gaaa);

    //System.out.println(res);
}
