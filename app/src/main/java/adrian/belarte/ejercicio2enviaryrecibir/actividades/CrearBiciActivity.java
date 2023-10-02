package adrian.belarte.ejercicio2enviaryrecibir.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adrian.belarte.ejercicio2enviaryrecibir.R;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Bici;
import adrian.belarte.ejercicio2enviaryrecibir.modelos.Coche;

public class CrearBiciActivity extends AppCompatActivity {
    private EditText txtMarca;
    private  EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

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
                String pulgadas = txtPulgadas.getText().toString();

                if(marca.isEmpty() || pulgadas.isEmpty()){
                    Toast.makeText(CrearBiciActivity.this,"Faltan Datos", Toast.LENGTH_LONG);
                }else{
                    Bici bici = new Bici(marca,pulgadas);
                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);

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
        txtMarca = findViewById(R.id.txtMarcaBici);
        txtPulgadas = findViewById(R.id.txtPulgadaBici);

        btnCancelar = findViewById(R.id.btnCancelarBici);
        btnCrear = findViewById(R.id.btnCrearBici);
    }
}