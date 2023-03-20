package es.ieslavereda.myApplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BotonOper implements View.OnClickListener{
    private Button numero;
    private TextView text;
    private MainActivity m;
    public BotonOper(Button button, TextView text, MainActivity m){
        numero = button;
        this.text = text;
        this.m = m;
    }
    @Override
    public void onClick(View view) {
        if (m.isHacerOperacion()) {
            if (m.getOperacion() == ' ') {
                m.setA(Float.parseFloat(text.getText().toString()));
                m.setOperacion(numero.getText().charAt(0));
                m.colorearOperacionesASuColor();
            } else{
                m.setB(Float.parseFloat(text.getText().toString()));
                if (m.getB() == 0 && m.getOperacion() == '/') {
                    text.setText("Err.");
                } else {
                    m.setA(m.operar());
                    text.setText(Float.toString(m.getA()));
                    m.setOperacion(numero.getText().charAt(0));
                    m.setB(0);
                    m.colorearOperacionesASuColor();
                }
            }
            m.setBorrar(true);
            m.setHacerOperacion(false);
            m.setHayComa(false);
            marcarRadioButton();
        } else if (text.getText().length()>0) {
            m.setA(Float.parseFloat(text.getText().toString()));
            m.setOperacion(numero.getText().charAt(0));
            m.colorearOperacionesASuColor();
            m.setBorrar(true);
            marcarRadioButton();
        } else {
            m.clearMenu();
        }
    }

    private void marcarRadioButton(){
        if (m.getOperacion()=='+')
            m.getRbSuma().setChecked(true);
        if (m.getOperacion()=='-')
            m.getRbResta().setChecked(true);
        if (m.getOperacion()=='*')
            m.getRbMultipli().setChecked(true);
        if (m.getOperacion()=='/')
            m.getRbDivis().setChecked(true);
    }
}
