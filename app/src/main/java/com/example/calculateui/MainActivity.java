package com.example.calculateui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static EditText editText;
    public static String string = "";
    public static int left = 0;
    public static int right = 0;
    public static boolean pointFlat = true;
    public static boolean isResult = false;

    public static Button tempButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        Button button9 = (Button) findViewById(R.id.button_9);
        Button button0 = (Button) findViewById(R.id.button_0);
        Button add = (Button) findViewById(R.id.button_add);
        Button subtract = (Button) findViewById(R.id.button_subtract);
        Button multiply = (Button) findViewById(R.id.button_multiply);
        Button divide = (Button) findViewById(R.id.button_divide);
        Button ac = (Button) findViewById(R.id.button_ac);
        Button delete = (Button) findViewById(R.id.button_delete);
        Button equal = (Button) findViewById(R.id.button_equal);
        Button button_left = (Button) findViewById(R.id.button_brackets_left);
        Button button_right = (Button) findViewById(R.id.button_brackets_right);
        Button point = (Button) findViewById(R.id.button_point);

        editText = (EditText) findViewById(R.id.edit);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        ac.setOnClickListener(this);
        delete.setOnClickListener(this);
        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (isResult){
            String tempbutton;
            tempButton = (Button) findViewById(view.getId());
//        tempButton.setOnClickListener(this);
            tempbutton = String.valueOf(tempButton.getText());
            if (tempbutton.matches("[\\+\\-\\*\\/]")){
                isResult = false;
            }else if(tempbutton.equals("=")){
            }else {
                string = "";
                editText.setText(string);
                isResult = false;
            }
        }
        if (view.getId() == R.id.button_1) {
            string += "1";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_2) {
            string += "2";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_3) {
            string += "3";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_4) {
            string += "4";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_5) {
            string += "5";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_6) {
            string += "6";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_7) {
            string += "7";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_8) {
            string += "8";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_9) {
            string += "9";
            editText.setText(string);
        }
        if (view.getId() == R.id.button_0) {
            int length_0 = string.length();
            if (length_0 > 0 && String.valueOf(string.charAt(length_0 - 1)).equals("/")) {
                editText.setText(string + "0" + "   tip : 0不能作为除数");
            } else {
                string += "0";
                editText.setText(string);
            }
        }
        if (view.getId() == R.id.button_add) {
            int length_add = string.length();
            if (length_add == 0){
                string = "+";
            }else if (String.valueOf(string.charAt(length_add - 1)).equals(".")) {
                string += "0+";
            } else if (String.valueOf(string.charAt(length_add - 1)).matches("[\\-\\*\\/\\+]")) {
                string = string.substring(0,length_add - 1);
                string += "+";
            } else {
                string += "+";
            }
            editText.setText(string);
            pointFlat = true;
        }
        if (view.getId() == R.id.button_subtract) {
            int length_sub = string.length();
            if (length_sub == 0) {
                string += "-";
            } else if (String.valueOf(string.charAt(length_sub - 1)).matches("[\\+\\-\\*\\/]{1}")) {
                string += "(0-";
                left++;
            }//减号前有运算符的情况
            else if (String.valueOf(string.charAt(length_sub - 1)).equals(".")) {
                string += "0-";
            } else {
                string += "-";
            }
            editText.setText(string);
            pointFlat = true;
        }
        if (view.getId() == R.id.button_multiply) {
            int length_mul = string.length();
            if (length_mul == 0){
                string = "*";
            } else if (String.valueOf(string.charAt(length_mul - 1)).equals(".")) {
                string += "0*";
            } else if (String.valueOf(string.charAt(length_mul - 1)).matches("[\\-\\+\\/\\*]")) {
                string = string.substring(0,length_mul - 1);
                string += "*";
            }  else {
                string += "*";
            }
            editText.setText(string);
            pointFlat = true;
        }
        if (view.getId() == R.id.button_divide) {
            int length_divide = string.length();
            if (length_divide == 0){
                string = "/";
            }else if (String.valueOf(string.charAt(length_divide - 1)).equals(".")) {
                string += "0/";
            } else if (String.valueOf(string.charAt(length_divide - 1)).matches("[\\+\\*\\-\\/]")) {
                string = string.substring(0,length_divide - 1);
                string += "/";
            }  else {
                string += "/";
            }
            editText.setText(string);
            pointFlat = true;
        }
        if (view.getId() == R.id.button_ac) {
            string = "";
            left = right = 0;
            pointFlat = true;
            editText.setText(string);
        }
        if (view.getId() == R.id.button_delete) {
            int length_del = string.length();
            if (isResult && string.equals("Error")){
                string = "";
                isResult = false;
                pointFlat = true;
                editText.setText(string);
            }
            if (!isResult && length_del > 0){
                String temp = String.valueOf(string.charAt(length_del - 1));
                if (temp.equals(".")) {
                    pointFlat = true;
                } else if (temp.equals("(")) {
                    left--;
                } else if (temp.equals(")")) {
                    right--;
                }
                string = string.substring(0, length_del - 1);
                editText.setText(string);
                if (string.equals("")) {
                    left = right = 0;
                    pointFlat = true;
                    isResult = false;
                }
            }
        }
        if (view.getId() == R.id.button_brackets_left) {
            int length_left = string.length();
            if (length_left - 1 >= 0 && String.valueOf(string.charAt(length_left - 1)).matches("[0-9\\)]{1}")){
                string += "*(";
            }else {
                string += "(";
            }
            left++;
            editText.setText(string);
        }
        if (view.getId() == R.id.button_brackets_right) {
            int length_right = string.length();
            if (length_right == 0){
            } else if (length_right - 1 >= 0 && string.charAt(length_right - 1) == '.'){
                string += "0)";
                right++;
                editText.setText(string);
            }else {
                string += ")";
                right++;
                editText.setText(string);
            }

        }
        if (view.getId() == R.id.button_point) {
            if (pointFlat) {
                int length_point = string.length();
                if (length_point == 0 || (length_point > 0
                        && String.valueOf(string.charAt(length_point - 1)).matches("[\\+\\-\\*\\/\\(]{1}"))) {
                    string += "0.";
                    editText.setText(string);
                    pointFlat = false;
                } else {
                    string += ".";
                    editText.setText(string);
                    pointFlat = false;
                }
            }
        }
        if (view.getId() == R.id.button_equal) {
            String temp;
            if(string.equals("")){
            }else {
                isResult = true;
                string = temp = Equal(string);
                if (string.equals("Error")) {
                    editText.setText("Error");
                    left = right = 0;
                    pointFlat = true;
                }else if (string.matches("^[+-]?[1-9]\\d*$") || string.matches("^[+-]?\\d+(\\.\\d+)$")
                        || string.equals("0")){
                    editText.setText(temp + "\n" + "= " + string);
                    pointFlat = true;
                    left = right = 0;
                } else {
                    string = Deal(string);//中缀表达式转后缀表达式
                    string = Calculate(string);
                    editText.setText(temp + "\n" + "= " + string);
                    left = right = 0;
                    isResult = true;
                    pointFlat = true;
                }
            }
        }
    }
    public String Deal(String infix){
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        int length = infix.length();
        for (int i = 0; i < length; i++){
            String temp;
            String charAt = String.valueOf(infix.charAt(i));
            if (charAt.equals("(")){
                stack.push(String.valueOf(charAt));
            } else if (charAt.equals("+") || charAt.equals("-")) {
                while (!stack.isEmpty()){
                    temp = stack.peek();
                    if (temp.equals("(")){
                        break;
                    }
                    postfix.append(" ").append(stack.pop());
                }
                stack.push(charAt);
            } else if (charAt.equals("*") || charAt.equals("/")) {
                while (!stack.isEmpty()){
                    temp = stack.pop();
                    if (temp.equals("(")  || temp.equals("+")  || temp.equals("-")){
                        stack.push(temp);
                        break;
                    }
                    postfix.append(" ").append(temp);
                }
                stack.push(charAt);
            } else if (charAt.equals(")")) {
                while (!stack.isEmpty()){
                    temp = stack.pop();
                    if (!temp.equals("(")){
                        postfix.append(" ").append(temp);
                    }else {
                        break;
                    }
                }
            } else if (charAt.matches("[0-9]|\\.")){
                postfix.append(" ").append(charAt);
                if (i < length - 1){
                    int j = i + 1;
                    String nextNumber = String.valueOf(infix.charAt(j));
                    while (j < length && nextNumber.matches("[0-9]|\\.")){
                        postfix.append(nextNumber);
                        if (++j < length)
                            nextNumber = String.valueOf(infix.charAt(j));
                    }
                    i = j - 1;
                }
            }
        }
        while (!stack.isEmpty()){
            postfix.append(" ").append(stack.pop());
        }
        return postfix.toString().trim();
    }

    public String Equal(String string){
        int length_equ = string.length();
        if(length_equ == 1 && (string.equals("(") || string.equals(")"))){
            string = "Error";
            return string;
        }else if (String.valueOf(string.charAt(0)).equals(")")){
            string = "Error";
            return string;
        }
        if (length_equ == 2 && string.equals("()")){
            string = "Error";
            return string;
        }
        if (length_equ - 1 >= 0 && String.valueOf(string.charAt(length_equ - 1)).matches("[\\*\\/]{1}")){
            string += "1";
        } else if (length_equ - 1 >= 0 && String.valueOf(string.charAt(length_equ - 1)).matches("[\\+\\-\\.]{1}")) {
            string += "0";
        }//结尾是运算符的情况
        if (String.valueOf(string.charAt(0)).matches("[\\+\\-\\*\\/]{1}")){
            string = "0" + string;
        } //开头是运算符的情况
        while(left != right){
            if (left > right){
                right++;
                string += ")";
            }else if(left < right){
                string = "Error";
                return string;
            }
        }//括号不匹配的情况

        for (int i = 0; i < string.length(); i++) {
            String temp = String.valueOf(string.charAt(i));
            if (temp.equals("(") && i + 1 < string.length() - 1
                    && String.valueOf(string.charAt(i + 1)).matches("[\\+\\*\\/\\)]{1}")) {
                string = "Error";
                break;
            } else if (temp.equals(")") && i - 1 >= 0 &&
                    String.valueOf(string.charAt(i - 1)).matches("[\\+\\-\\*\\/\\(]{1}")) {
                string = "Error";
                break;
            } //出现(+*/  或者  +-*/)的情况
            if (temp.equals("(") && i - 1 >= 0
                    && String.valueOf(string.charAt(i - 1)).matches("[0-9\\.\\)]{1}")) {
                string = "Error";
                break;
            } else if (temp.equals(")") && i + 1 < string.length() - 1
                    && String.valueOf(string.charAt(i + 1)).matches("[0-9\\(\\.\\(]{1}")) {
                string = "Error";
                break;
            }//防止出现[0-9](  和  )[0-9]的情况
        }
        if (string.length() >= 2 && string.charAt(0) == '(' && string.charAt(string.length() - 1) == ')'){
            String temp = string.substring(1,string.length() - 1);
            if (temp.matches("^[+-]?[1-9]\\d*$") || temp.matches("^[+-]?\\d+(\\.\\d+)$")
                    || temp.equals("0")){
                return temp;
            }
        }
        return string;
    }

    public String Calculate(@NonNull String s){
        String[] nums = s.split(" ");
        Stack<String> stack = new Stack<>();
        BigDecimal big1,big2,big;
        String result = "";
        for(String str : nums){
                if (str.matches("^[+-]?[1-9]\\d*$") || str.matches("^[+-]?\\d+(\\.\\d+)$") || str.equals("0")){
                    stack.push(str);
                } else if (str.equals("+")){
                    big1 = new BigDecimal(stack.pop());
                    big2 = new BigDecimal(stack.pop());
                    big = big2.add(big1);
                    result = big + "";
                    stack.push(result);
                } else if (str.equals("-")) {
                    big1 = new BigDecimal(stack.pop());
                    big2 = new BigDecimal(stack.pop());
                    big = big2.subtract(big1);
                    result = big + "";
                    stack.push(result);
                } else if (str.equals("*")) {
                    big1 = new BigDecimal(stack.pop());
                    big2 = new BigDecimal(stack.pop());
                    big = big2.multiply(big1);
                    result = big + "";
                    stack.push(result);
                } else if (str.equals("/")) {
                    String temp1 = stack.pop();
                    String temp2 = stack.pop();
                    big1 = new BigDecimal(temp1);
                    big2 = new BigDecimal(temp2);
                    double b1 = Double.valueOf(temp1);
                    double b2 = Double.valueOf(temp2);
                    if (big1.compareTo(BigDecimal.ZERO) == 0){
                        return "Error : 除数不能为0";
                    }
                    if (temp1.length() <= 20 && temp2.length() <= 20){
                        double b = b2 / b1;
                        result = b + "";
                    }else {
                        big = big2.divide(big1,BigDecimal.ROUND_HALF_UP);
                        result = new BigDecimal(big + "").setScale(12, RoundingMode.HALF_UP) + "";
                    }
                    stack.push(result);
                } else {
                    return "Error : " + str + "不是数字";
                }
            }
        return result;
    }
}