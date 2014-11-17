/**
 * Created by strange1 on 10/11/14.
 */
import java.math.*;

public class CalcController {
    public double a = 0.0;
    public double b = 0.0;

    public double minus(double a, double b){
        return  a - b;
    }
    public double plus (double a, double b){
        return a + b;
    }
    public double mul (double a, double b){
        return a * b;
    }
    public double division( double a, double b){
        if(b !=0) {
            return  a / b;
        }
        else {

            ViewContoller.result.setText("Null division");
            return 0.0;
        }
    }
    public void clear (){
        this.a = 0;
        this.b = 0;

    }
    public double plusminus(double a){
        return (-1.0 * a);
    }
    public double sqrt2(double a){
        return Math.sqrt(a);
    }

    public double hoch2(double a,double b ){
        return Math.pow(a,b);
    }
    public double random(){
        return Math.random()*100;

    }
    public double prozent(double a){
        return a / 100;
    }
    public double sin(double a){
        return Math.sin(a);
    }
}
