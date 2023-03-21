//package dev.batuhansener.examples.calculator;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.widget.Button;
//
//@SuppressLint("AppCompatCustomView")
//public abstract class CalculatorButton extends Button {
//
//    public CalculatorButton(Context context) {
//        super(context);
//    }
//
//    abstract int calculate(int num1, int num2);
//}
//
//class AddButton extends CalculatorButton{
//
//    public AddButton(Context context) {
//        super(context);
//    }
//
//    @Override
//    int calculate(int num1, int num2) {
//        return num1+num2;
//    }
//}
//class SubButton extends CalculatorButton{
//
//    public SubButton(Context context) {
//        super(context);
//    }
//
//    @Override
//    int calculate(int num1, int num2) {
//        return num1-num2;
//    }
//}
//class MulButton extends CalculatorButton{
//
//    public MulButton(Context context) {
//        super(context);
//    }
//
//    @Override
//    int calculate(int num1, int num2) {
//        return num1*num2;
//    }
//}
//class DivButton extends CalculatorButton{
//
//    public DivButton(Context context) {
//        super(context);
//    }
//
//    @Override
//    int calculate(int num1, int num2){
//        if (num2!=0)
//            return num1*num2;
//        else
//            throw new ArithmeticException("Sıfır'a bölemezsin");
//    }
//}
