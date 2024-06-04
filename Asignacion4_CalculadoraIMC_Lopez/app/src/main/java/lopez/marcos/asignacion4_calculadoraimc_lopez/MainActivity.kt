package lopez.marcos.asignacion4_calculadoraimc_lopez


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
        val estaturaInp: EditText = findViewById(R.id.estatura);
        val pesoInp: EditText = findViewById(R.id.peso);
        val calcular: Button = findViewById(R.id.calcimc);
        val imcNum: TextView = findViewById(R.id.imc);
        val rango: TextView = findViewById(R.id.rango);


        calcular.setOnClickListener{
            var estatura: String = estaturaInp.getText().toString();
            var peso: String = pesoInp.getText().toString();

            var imc = peso.toFloat() / estatura.toFloat().pow(2);
            var textoRango: String = "";
            var colorRango: Int = 0;

            imcNum.setText("$imc");
            if(imc < 18.5){
                textoRango = "Bajo peso";
                colorRango = R.color.greennish
            } else if(imc <= 24.9){
                textoRango = "Normal";
                colorRango = R.color.green
            } else if (imc <= 29.9){
                textoRango = "Sobrepeso";
                colorRango = R.color.yellow
            }else if (imc <= 34.9){
                textoRango = "Obesidad grado 1";
                colorRango = R.color.orange
            }else if (imc <= 39.9){
                textoRango = "Obesidad grado 2";
                colorRango = R.color.red
            }else if (imc > 40){
                textoRango = "Obesidad grado 3";
                colorRango = R.color.brown
            }

            rango.setText(textoRango);
            rango.setBackgroundResource(colorRango)
            imcNum.visibility = View.VISIBLE;
            rango.visibility = View.VISIBLE;
        }
    }
}
