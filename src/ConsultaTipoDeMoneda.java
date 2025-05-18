import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaTipoDeMoneda {

    public double obtenerTasa(String monedaOrigen, String monedaDestino) {
        String apiKey = "326a02e9ad555d3a0022caee";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + monedaOrigen + "/" + monedaDestino;

        try {
            System.out.println("URL solicitada: " + direccion);

            URL url = new URL(direccion);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            int respuesta = conexion.getResponseCode();
            if (respuesta != 200) {
                System.out.println("Error al consultar tasa de cambio: Código: " + respuesta);
                return -1;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder resultado = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                resultado.append(linea);
            }
            reader.close();

            JSONObject json = new JSONObject(resultado.toString());

            if (json.getString("result").equals("success")) {
                return json.getDouble("conversion_rate");
            } else {
                System.out.println("La API respondió con error: " + json.getString("error-type"));
                return -1;
            }

        } catch (Exception e) {
            System.out.println("Error general al consultar tasa: " + e.getMessage());
            return -1;
        }
    }
}
