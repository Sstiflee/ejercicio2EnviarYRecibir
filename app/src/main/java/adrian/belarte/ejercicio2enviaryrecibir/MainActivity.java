package adrian.belarte.ejercicio2enviaryrecibir;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import adrian.belarte.ejercicio2enviaryrecibir.modelos.Coche;

public class MainActivity extends AppCompatActivity {
    //atributos para la vista
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;
    private TextView lbCantidadCoches;
    private TextView lbCantidadMotos;
    private TextView lbCantidadBicis;

    //atributos para los launchers(recoger informacion)
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    //atributos para logica
    private ArrayList<Coche>listaCoches;
    private ArrayList<Coche>listaMotos;
    private ArrayList<Coche>listaBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();
    }

    private void inicializarVariables() {
        //inicializar vista
        lbCantidadCoches = findViewById(R.id.lbCochesMain);
        lbCantidadMotos = findViewById(R.id.lbMotosMain);
        lbCantidadBicis= findViewById(R.id.lbBicisMain);

        btnCrearCoche = findViewById(R.id.btnCocheMain);
        btnCrearMoto = findViewById(R.id.btnMotoMain);
        btnCrearBici = findViewById(R.id.btnBiciMain);

        //inicializar logica
        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();
    }
}