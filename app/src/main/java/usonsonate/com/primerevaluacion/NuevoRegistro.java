package usonsonate.com.primerevaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NuevoRegistro extends AppCompatActivity {

    private EditText txbNota1, txbNota2, txbNota3,txbNombre, txbCodigo, txbMateria;
    String Promedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        txbNota1 = findViewById(R.id.txbPrimerParcial);
        txbNota2 = findViewById(R.id.txbSegundoParcial);
        txbNota3 = findViewById(R.id.txbTercerParcial);
        txbMateria = findViewById(R.id.txbMateria);
        txbNombre = findViewById(R.id.txbNombre);
        txbCodigo = findViewById(R.id.txbCodigo);


    }

    public void btnProcesarClick(View v){
        Double N1 = 0.0;
        Double N2 = 0.0;
        Double N3 = 0.0;

        if (!txbNota1.getText().toString().isEmpty()){
            N1 = Double.parseDouble(txbNota1.getText().toString());
        }

        if (!txbNota2.getText().toString().isEmpty()){
            N2 = Double.parseDouble(txbNota2.getText().toString());
        }

        if (!txbNota3.getText().toString().isEmpty()){
            N3 = Double.parseDouble(txbNota3.getText().toString());
        }

        CalculoPromedio();

        if (!txbMateria.getText().toString().isEmpty() && !txbNombre.toString().isEmpty() &&
            !txbNota1.getText().toString().isEmpty() && !txbNota2.toString().isEmpty() &&
            !txbNota3.getText().toString().isEmpty() && Promedio!= null &&
                N1 >=0.0 && N1 <= 10.0 &&
                N2 >=0.0 && N2 <= 10.0 &&
                N3>= 0.0 && N3 <=10.0){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putExtra("NOMBRE", txbNombre.getText().toString());
            resultIntent.putExtra("CODIGO", txbCodigo.getText().toString());
            resultIntent.putExtra("MATERIA", txbMateria.getText().toString());
            resultIntent.putExtra("PARCIAL1", txbNota1.getText().toString());
            resultIntent.putExtra("PARCIAL2", txbNota2.getText().toString());
            resultIntent.putExtra("PARCIAL3", txbNota3.getText().toString());
            resultIntent.putExtra("PROMEDIO", Promedio.toString());
            setResult(MainActivity.ENVIOPRINCIPAL, resultIntent);
            finish();
        }else{
            if (txbNombre.getText().toString().isEmpty()) {
                Toast.makeText(this, "El campo nombre esta vacio.", Toast.LENGTH_SHORT).show();
                txbNombre.findFocus();
            }else if (txbCodigo.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo código esta vacio.", Toast.LENGTH_SHORT).show();
                txbCodigo.findFocus();

            }else if (txbMateria.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo materia esta vacio.", Toast.LENGTH_SHORT).show();
                txbMateria.findFocus();
            }else if (txbNota1.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo de la primer nota esta vacio.", Toast.LENGTH_SHORT).show();
                txbNota1.findFocus();
            }else if (txbNota2.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo de la segunda nota esta vacio.", Toast.LENGTH_SHORT).show();
                txbNota2.findFocus();
            }else if (txbNota3.getText().toString().isEmpty()){
                Toast.makeText(this, "El campo de la tercer nota esta vacio.", Toast.LENGTH_SHORT).show();
                txbNota3.findFocus();
            }else if(N1 <0.0 || N1>10.0){
                Toast.makeText(this, "El primer parcial no se encuentra entre el rango aceptable 0 - 10", Toast.LENGTH_SHORT ).show();
            }else if(N2 <0.0 || N2>10.0){
                Toast.makeText(this, "El segundo parcial no se encuentra entre el rango aceptable 0 - 10", Toast.LENGTH_SHORT ).show();
            }else if(N3 <0.0 || N3>10.0){
                Toast.makeText(this, "El tercer parcial no se encuentra entre el rango aceptable 0 - 10", Toast.LENGTH_SHORT ).show();
            }
        }

    }

    protected void CalculoPromedio(){
        Double Total = 0.0;
        if (!txbNota1.getText().toString().isEmpty()){
            Total = Total + (Double.parseDouble(txbNota1.getText().toString()) * 0.3);
        }

        if(!txbNota2.getText().toString().isEmpty()){
            Total = Total + (Double.parseDouble(txbNota2.getText().toString()) * 0.3);
        }

        if(!txbNota3.getText().toString().isEmpty()){
            Total = Total + (Double.parseDouble(txbNota3.getText().toString()) * 0.4);
        }

        if (Total > 0){
            //Total = Total / 3;
            Total = (double)Math.round(Total * 100d) / 100d;
            Promedio = Total.toString();
        }else{

            Promedio = null;
        }

    }
}
