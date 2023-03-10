package es.ieslavereda.myApplication;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BotonNum implements View.OnClickListener{
    private Button numero;
    private TextView text;
    private MainActivity m;
    public BotonNum(Button button, TextView text, MainActivity m){
        numero = button;
        this.text = text;
        this.m = m;
    }
    @Override
    public void onClick(View view) {
        if (!m.isBorrar()) {
            text.setText(text.getText() + "" + numero.getText());
        }else{
            m.setBorrar(false);
            text.setText(numero.getText());
            m.blanquearBotonOperacion();
        }
    }
}
