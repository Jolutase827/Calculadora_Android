package es.ieslavereda.myApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float a;
    private float b;
    private boolean hayComa;
    private boolean borrar;
    private char operacion;

    private TextView text;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button bSuma;
    private Button bResta;
    private Button bMultiplicacion;
    private Button bDivision;
    private Button bComa;
    private Button bIgual;
    private Button bAC;
    private Button bC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        operacion = ' ';
        a=0;
        b=0;
        hayComa = false;
        borrar = false;
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bSuma = (Button) findViewById(R.id.bSuma);
        bResta = (Button) findViewById(R.id.bResta);
        bMultiplicacion = (Button) findViewById(R.id.bMulti);
        bDivision = (Button) findViewById(R.id.bDivision);
        bIgual = (Button) findViewById(R.id.bOperar);
        bComa = (Button) findViewById(R.id.bComa);
        bAC = (Button) findViewById(R.id.bAC);
        bC = (Button) findViewById(R.id.bC);


        b1.setOnClickListener(new BotonNum(b1,text,this));
        b2.setOnClickListener(new BotonNum(b2,text,this));
        b3.setOnClickListener(new BotonNum(b3,text,this));
        b4.setOnClickListener(new BotonNum(b4,text,this));
        b5.setOnClickListener(new BotonNum(b5,text,this));
        b6.setOnClickListener(new BotonNum(b6,text,this));
        b7.setOnClickListener(new BotonNum(b7,text,this));
        b8.setOnClickListener(new BotonNum(b8,text,this));
        b9.setOnClickListener(new BotonNum(b9,text,this));
        b0.setOnClickListener(new BotonNum(b0,text,this));

        bMultiplicacion.setOnClickListener(new BotonOper(bMultiplicacion,text,this));
        bSuma.setOnClickListener(new BotonOper(bSuma,text,this));
        bResta.setOnClickListener(new BotonOper(bResta,text,this));
        bDivision.setOnClickListener(new BotonOper(bDivision,text,this));


        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                operacion = ' ';
                a =0;
                b=0;
                blanquearBotonOperacion();
                hayComa=false;
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text.getText().length()>0)
                    text.setText(text.getText().subSequence(0,text.getText().length()-1));
                if (text.getText().length()==0){
                    colorearOperacionesASuColor();
                }
            }
        });

        bComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hayComa) {
                    if (text.getText().equals("") || borrar) {
                        text.setText("0.");
                        colorearOperacionesASuColor();
                        borrar = false;
                    } else
                        text.setText(text.getText() + ".");
                    hayComa=true;
                }
            }
        });

        bIgual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (operacion!=' ') {
                    b = Float.parseFloat(text.getText().toString());
                    if (b == 0 && operacion == '/') {
                        text.setText("Err.");
                        colorearOperacionesASuColor();
                    } else {
                        a = operar();
                        text.setText(Float.toString(a));
                        operacion = ' ';
                        a=0;
                        b=0;
                        colorearOperacionesASuColor();
                        hayComa = false;
                    }
                }
                borrar = true;
            }
        });



    }


    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    public char getOperacion() {
        return operacion;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public float operar(){
        switch (operacion){
            case('*'):
                return a*b;
            case('-'):
                return a-b;
            case('+'):
                return a+b;
            case('/'):
                return a/b;
            default:
                return 0;
        }
    }

    public void colorearOperacionesASuColor(){
        blanquearBotonOperacion();
        colorearOperacion();
    }

    public void blanquearBotonOperacion() {
        bMultiplicacion.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bResta.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bDivision.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bSuma.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bMultiplicacion.setTextColor(Color.parseColor("#000000"));
        bResta.setTextColor(Color.parseColor("#000000"));
        bDivision.setTextColor(Color.parseColor("#000000"));
        bSuma.setTextColor(Color.parseColor("#000000"));
    }

    public void colorearOperacion(){
        switch (operacion){
            case('*'):
                bMultiplicacion.setBackgroundColor(Color.parseColor("#000000"));
                bMultiplicacion.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case('-'):
                bResta.setBackgroundColor(Color.parseColor("#000000"));
                bResta.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case('+'):
                bSuma.setBackgroundColor(Color.parseColor("#000000"));
                bSuma.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case('/'):
                bDivision.setBackgroundColor(Color.parseColor("#000000"));
                bDivision.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            default:
                break;
        }
    }
}