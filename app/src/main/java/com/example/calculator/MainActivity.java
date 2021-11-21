package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnDEL,btnDivide,btnPlus,btnMinus,btnMulti,btnDot,btnEquals;
    private TextView textViewHistory,textViewResult;
    private String number=null;
    double firstNum=0.0d;
    double lastNum=0.0d;
    String status=null;
    boolean operator=false;
    DecimalFormat myFormatter=new DecimalFormat("######.######");
    String history,currentResult;
    boolean dot=true;
    boolean btnACcontrol=true;
    boolean btnEqalscontrol=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnAC=findViewById(R.id.btnAC);
        btnDEL=findViewById(R.id.btnDEL);
        btnDivide=findViewById(R.id.btnDivide);
        btnPlus=findViewById(R.id.btnPlus);
        btnMinus=findViewById(R.id.btnMinus);
        btnMulti=findViewById(R.id.btnMulti);
        btnDot=findViewById(R.id.btnDot);
        btnEquals=findViewById(R.id.btnEquals);
        textViewHistory=findViewById(R.id.textViewhistory);
        textViewResult=findViewById(R.id.textViewresult);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNum=0;
                lastNum=0;
                dot=true;
                btnACcontrol=true;

            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnACcontrol)
                {
                    textViewResult.setText("0");
                }
                else
                {
                    number=number.substring(0,number.length()-1);
                    if(number.length()==0)
                    {
                        btnDEL.setClickable(false);
                    }
                    else if(number.contains("."))
                    {
                        dot=false;
                    }
                    else
                    {
                        dot=true;
                    }
                    textViewResult.setText(number);
                }

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");
                if(operator)
                {
                    if(status=="multiplication")
                    {
                        Multiply();
                    }
                    else if(status=="sum")
                    {
                        Plus();
                    }
                    else if(status=="subtraction")
                    {
                        Minus();
                    }
                    else
                    {
                        Divide();
                    }
                }
                status="division";
                operator=false;
                number=null;

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");
                if(operator)
                {
                    if(status=="multiplication")
                    {
                        Multiply();
                    }
                    else if(status=="division")
                    {
                        Divide();
                    }
                    else if(status=="subtraction")
                    {
                        Minus();
                    }
                    else
                    {
                        Plus();
                    }
                }
                status="sum";
                operator=false;
                number=null;

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");
                if(operator)
                {
                    if(status=="multiplication")
                    {
                        Multiply();
                    }
                    else if(status=="division")
                    {
                        Divide();
                    }
                    else if(status=="sum")
                    {
                        Plus();
                    }
                    else
                    {
                        Minus();
                    }
                }
                status="subtraction";
                operator=false;
                number=null;

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");
                if(operator)
                {
                    if(status=="sum")
                    {
                        Plus();
                    }
                    else if(status=="division")
                    {
                        Divide();
                    }
                    else if(status=="subtraction")
                    {
                        Minus();
                    }
                    else
                    {
                        Multiply();
                    }
                }
                status="multiplication";
                operator=false;
                number=null;

            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator)
                {
                    if(status=="multiplication")
                    {
                        Multiply();
                    }
                    else if(status=="sum")
                    {
                        Plus();
                    }
                    else if(status=="division")
                    {
                        Divide();
                    }
                    else if(status=="subtraction")
                    {
                        Minus();
                    }
                    else
                    {
                        firstNum=Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator=false;
                btnEqalscontrol=true;

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dot)
                {
                    if(number==null)
                    {
                        number="0.";
                    }
                    else
                    {
                        number=number+".";
                    }
                }
                textViewResult.setText(number);
                dot=false;

            }
        });
    }
    public void numberClick(String view)
    {
        if(number==null)
        {
            number=view;
        }
        else if(btnEqalscontrol)
        {
            firstNum=0;
            lastNum=0;
            number=view;
        }
        else
        {
            number+=view;
        }
        textViewResult.setText(number);
        operator=true;
        btnACcontrol=false;
        btnDEL.setClickable(true);
        btnEqalscontrol=false;

    }
    public void Plus()
    {
        lastNum=Double.parseDouble(textViewResult.getText().toString());
        firstNum+=lastNum;
        textViewResult.setText(myFormatter.format(firstNum));
        dot=true;
    }
    public void Minus()
    {
        if(firstNum==0)
        {
            firstNum=Double.parseDouble(textViewResult.getText().toString());
        }
        else
        {
            lastNum=Double.parseDouble(textViewResult.getText().toString());
            firstNum-=lastNum;
        }
        textViewResult.setText(myFormatter.format(firstNum));
        dot=true;
    }
    public void Multiply()
    {
        if(firstNum==0)
        {
            firstNum=1;
            lastNum=Double.parseDouble(textViewResult.getText().toString());
            firstNum*=lastNum;
        }
        else
        {
            lastNum=Double.parseDouble(textViewResult.getText().toString());
            firstNum*=lastNum;
        }
        textViewResult.setText(myFormatter.format(firstNum));
        dot=true;
    }
    public void Divide()
    {
        if(firstNum==0)
        {
            lastNum=Double.parseDouble(textViewResult.getText().toString());
            firstNum=lastNum/1;
        }
        else
        {
            lastNum=Double.parseDouble(textViewResult.getText().toString());
            firstNum/=lastNum;
        }
        textViewResult.setText(myFormatter.format(firstNum));
        dot=true;
    }

}