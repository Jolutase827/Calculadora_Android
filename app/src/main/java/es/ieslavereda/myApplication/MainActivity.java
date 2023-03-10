package es.ieslavereda.myApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b1.getText());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b2.getText());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b3.getText());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b4.getText());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b5.getText());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b6.getText());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b8.getText());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b9.getText());
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText()+""+b0.getText());
            }
        });
        bAC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text.setText(text.getText().subSequence(0,text.getText().length()-1));
            }
        });



    }
}