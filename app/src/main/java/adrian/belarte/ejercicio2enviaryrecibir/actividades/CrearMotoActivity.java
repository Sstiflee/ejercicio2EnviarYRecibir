package adrian.belarte.ejercicio2enviaryrecibir.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adrian.belarte.ejercicio2enviaryrecibir.R;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Coche;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Moto;

public class CrearMotoActivity extends AppCompatActivity {

    private EditText txtMarca;
    private  EditText txtModelo;
    private EditText txtCilindrada;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

        inicializarVista();
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sacar la informacion de la vista para crear un coche
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                if(marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()){
                    Toast.makeText(CrearMotoActivity.this,"Faltan Datos", Toast.LENGTH_LONG);
                }else{
                    Moto moto = new Moto(marca,modelo,cilindrada);
                    //Enviar la moto a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);


                    //devolver el resultado de ok
                    setResult(RESULT_OK, intent);
                    //terminar
                    finish();
                }
            }
        });
    }

    private void inicializarVista() {
            txtMarca = findViewById(R.id.txtMarcaMoto);
            txtModelo = findViewById(R.id.txtModeloMoto);
            txtCilindrada = findViewById(R.id.txtCilindradaMoto);

            btnCancelar = findViewById(R.id.btnCancelarMoto);
            btnCrear = findViewById(R.id.btnCrearMoto);
        }
    }