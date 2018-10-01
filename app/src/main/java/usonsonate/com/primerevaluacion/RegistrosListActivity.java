package usonsonate.com.primerevaluacion;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class RegistrosListActivity extends ListActivity {

    private AdaptadorEstudiante adaptadorEstudiante;
    private ArrayList<Estudiante> lstEstudiantes;
    private  ArrayList<Estudiante> lstNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_registros_list);

        Bundle contenedor = getIntent().getExtras();
        lstEstudiantes = (ArrayList<Estudiante>) contenedor.getSerializable("array");
        lstNuevo = new ArrayList<>();

        //creo el adaptador
        adaptadorEstudiante = new AdaptadorEstudiante(RegistrosListActivity.this, lstNuevo );
        //le establezco el adaptador al Listview
        setListAdapter(adaptadorEstudiante);

        FillListEncuestado();

    }

    private void FillListEncuestado(){
        for (final Estudiante c:lstEstudiantes){
            lstNuevo.add(c);
            adaptadorEstudiante.notifyDataSetChanged();
        }
    }

}
