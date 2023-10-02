package adrian.belarte.ejercicio2enviaryrecibir;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adrian.belarte.ejercicio2enviaryrecibir.actividades.CrearCocheActivity;
import adrian.belarte.ejercicio2enviaryrecibir.actividades.CrearMotoActivity;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Bici;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Coche;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Moto;

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
    private ArrayList<Moto>listaMotos;
    private ArrayList<Bici>listaBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();
        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });
        btnCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMotos.launch(new Intent(MainActivity.this, CrearMotoActivity.class));
            }
        });
        
        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){

                            //INTENT                              BUNDLE
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");


                                if(coche != null){
                                    listaCoches.add(coche);

                                    lbCantidadCoches.setText("Coches: "+listaCoches.size());
                                 //   Toast.makeText(MainActivity.this, listaCoches.size(), Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "No hay coches", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Activdad Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){

                            //INTENT                              BUNDLE
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");


                                if(moto != null){
                                    listaMotos.add(moto);

                                    lbCantidadMotos.setText("Motos: "+listaMotos.size());
                                    //   Toast.makeText(MainActivity.this, listaCoches.size(), Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "No hay Motos", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Activdad Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
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