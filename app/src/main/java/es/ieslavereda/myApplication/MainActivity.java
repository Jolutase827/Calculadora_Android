package es.ieslavereda.myApplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private boolean hacerOperacion;
    private RadioGroup rG;
    private CheckBox checkBox;
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

    private RadioButton rbSuma;
    private RadioButton rbResta;
    private RadioButton rbMultipli;
    private RadioButton rbDivis;



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("hacerOperacion",hacerOperacion);
        outState.putSerializable("a",a);
        outState.putSerializable("b",b);
        outState.putSerializable("borrar",borrar);
        outState.putSerializable("hayComa", hayComa);
        outState.putSerializable("operacion",operacion);
        outState.putSerializable("texto",  text.getText().toString());

    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        rbSuma = findViewById(R.id.radioButtonSuma);
        rbResta = findViewById(R.id.radioButtonResta);
        rbDivis = findViewById(R.id.radioButtonDividir);
        rbMultipli = findViewById(R.id.radioButtonMultiplicar);
        rG = findViewById(R.id.rG);
        checkBox = findViewById(R.id.checkBox);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 =  findViewById(R.id.b5);
        b6 =  findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bSuma = findViewById(R.id.bSuma);
        bResta = findViewById(R.id.bResta);
        bMultiplicacion = findViewById(R.id.bMulti);
        bDivision =  findViewById(R.id.bDivision);
        bIgual =  findViewById(R.id.bOperar);
        bComa =  findViewById(R.id.bComa);
        bAC =  findViewById(R.id.bAC);
        bC =  findViewById(R.id.bC);

        if (savedInstanceState==null) {
            operacion = ' ';
            a = 0;
            b = 0;
            hacerOperacion = false;
            hayComa = false;
            borrar = false;

        }else {
            operacion = (char) savedInstanceState.get("operacion");
            hacerOperacion = (boolean) savedInstanceState.get("hacerOperacion");
            a = (float) savedInstanceState.get("a");
            b = (float) savedInstanceState.get("b");
            hayComa = (boolean) savedInstanceState.get("hayComa");
            borrar = (boolean) savedInstanceState.get("borrar");
            text.setText(savedInstanceState.get("texto").toString());
            colorearOperacion();

        }


        rbSuma.setOnClickListener(new BotonOper(bSuma,text,this));
        rbMultipli.setOnClickListener(new BotonOper(bMultiplicacion,text,this));
        rbResta.setOnClickListener(new BotonOper(bResta,text,this));
        rbDivis.setOnClickListener(new BotonOper(bDivision,text,this));


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    rG.setVisibility(View.VISIBLE);
                    checkBox.setText("Menos");
                }
                else {
                    rG.setVisibility(View.GONE);
                    checkBox.setText("Más");
                }
            }
        });
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
                hacerOperacion=false;
                clearMenu();
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (borrar){
                    text.setText("");
                }
                if (text.getText().length()>0) {
                    if(text.getText().charAt(text.getText().length()-1)=='.')
                        hayComa=false;
                    text.setText(text.getText().subSequence(0, text.getText().length() - 1));
                }
                if (text.getText().length()==0){
                    colorearOperacionesASuColor();
                    hacerOperacion=false;
                    hayComa=false;
                }
            }
        });

        bComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hayComa) {
                    if (text.getText().equals("") || borrar) {
                        text.setText("0.");
                        blanquearBotonOperacion();
                        borrar = false;
                    } else
                        text.setText(text.getText() + ".");
                    hayComa=true;
                    hacerOperacion=true;
                }
            }
        });

        bIgual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (hacerOperacion) {
                    b = Float.parseFloat(text.getText().toString());
                    if (b == 0 && operacion == '/') {
                        text.setText("Err.");
                    } else {
                        a = operar();
                        text.setText(Float.toString(a));
                        operacion = ' ';
                        a=0;
                        b=0;
                        hayComa = false;
                    }
                    colorearOperacionesASuColor();
                    clearMenu();
                    hacerOperacion=false;
                }
                borrar = true;
            }
        });



    }



    public void clearMenu(){
        rbSuma.setChecked(false);
        rbResta.setChecked(false);
        rbMultipli.setChecked(false);
        rbDivis.setChecked(false);
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

    public void setHayComa(boolean hayComa) {
        this.hayComa = hayComa;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public boolean isHacerOperacion() {
        return hacerOperacion;
    }

    public void setHacerOperacion(boolean hacerOperacion) {
        this.hacerOperacion = hacerOperacion;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public RadioButton getRbDivis() {
        return rbDivis;
    }

    public RadioButton getRbMultipli() {
        return rbMultipli;
    }

    public RadioButton getRbResta() {
        return rbResta;
    }

    public RadioButton getRbSuma() {
        return rbSuma;
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