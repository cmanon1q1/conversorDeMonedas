-Agrega menú interactivo por consola para seleccionar moneda de origen, destino y monto
 
- Conecta con la API de ExchangeRate para obtener tasas de cambio actualizadas
  
- Valida entradas del usuario (monedas disponibles y montos numéricos)
  
- Muestra resultados con formato claro y opción para repetir o salir del programa

****conversorDeMonedas****

-src/
-Main.java                   // Punto de entrada de la aplicación
-Principal.java              // Menú e interacción con el usuario
-ConsultaTipoDeMoneda.java  // Lógica de conexión con la API

****Conversor de Monedas con API****

-Monedas disponibles: USD, EUR, MXN, JPY, etc.
-Ingrese moneda de origen: mxn
-Ingrese moneda destino: usd
-Ingrese cantidad a convertir: 500
-URL solicitada: https://v6.exchangerate-api.com/v6/TU_CLAVE_API/pair/MXN/USD
-Resultado: 500.00 MXN = 25.70 USD (Tasa: 0.0514)

