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

public class CrearCocheActivity extends AppCompatActivity {
    //variables de vista
    private EditText txtMarca;
    private  EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);
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
                String color = txtColor.getText().toString();

                if(marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    Toast.makeText(CrearCocheActivity.this,"Faltan Datos", Toast.LENGTH_LONG);
                }else{
                    Coche coche = new Coche(marca,modelo,color);
                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);

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
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}