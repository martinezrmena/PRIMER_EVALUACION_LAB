package usonsonate.com.primerevaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int ENVIOPRINCIPAL=48;
    private FloatingActionButton btnNuevoEstudiante, btnListaEstudiante;
    private ArrayList<Estudiante> lstEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Control de Estudiantes");

        btnNuevoEstudiante = findViewById(R.id.btnRegistrarEstudiante);
        btnListaEstudiante = findViewById(R.id.btnListaEstudiante);
        lstEstudiante = new ArrayList<>();

    }

    public void btnRegistroClick(View v){
        Intent nuevo = new Intent(MainActivity.this, NuevoRegistro.class);
        startActivityForResult(nuevo, ENVIOPRINCIPAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ENVIOPRINCIPAL){
            if(data==null) return;
            //recibo los datos

            Estudiante e = new Estudiante(
                    data.getStringExtra("NOMBRE"),
                    data.getStringExtra("CODIGO"),
                    data.getStringExtra("MATERIA"),
                    Double.parseDouble(data.getStringExtra("PARCIAL1")),
                    Double.parseDouble(data.getStringExtra("PARCIAL2")),
                    Double.parseDouble(data.getStringExtra("PARCIAL3")),
                    Double.parseDouble(data.getStringExtra("PROMEDIO"))
            );

            lstEstudiante.add(e);
            Toast.makeText(this, "Estudiante ingresado exitosamente.", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnViewListaRegistroClick(View v){

        if (lstEstudiante.size() != 0){
            Intent intento = new Intent(MainActivity.this, RegistrosListActivity.class);
            Bundle contenedor = new Bundle();
            contenedor.putSerializable("array", lstEstudiante);
            intento.putExtras(contenedor);
            startActivity(intento);
        }else{
            Toast.makeText(this, "No ha realizado ninguna registro.", Toast.LENGTH_SHORT).show();
        }

    }
}
