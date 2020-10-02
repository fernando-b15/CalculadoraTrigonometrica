package edu.eci.arem;

import static spark.Spark.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.eci.arem.Calculators.Calculator;
import spark.Request;
import spark.Response;


/**
 * Esta clase es la clase de inicio de un server principal que se encrag de resivir peticiones para realizar calculos
 *
 */
public class App 
{
	/**
     * Este metodo main inicia el servidor Fachada y define algunas peticiones y respuestas haciendo uso 
     * de algunas funciones lambda
     */
    public static void main( String[] args ) throws NoSuchAlgorithmException
    {
    	port(getPort());
    	secure("keystores/ecikeystore.p12","456123","keystores/myTrustStore", "789123");
    	get("/respuesta", (req, res) ->  resultsView(req, res));
    	
    }
    /**
     *Este metodo se encarga de retonar el puerto por defecto que esta definido en una variable de entorno 
     *para correr el servidor web fachada sobre ese puerto.
     * @throws NoSuchAlgorithmException 
     */
  
 
 private static int getPort() {
   	 if (System.getenv("PORT") != null) {
   		 return Integer.parseInt(System.getenv("PORT"));
   	 }
   	 return 4000; //returns default port if heroku-port isn't set
   }
 /**
  *Este metodo contruye la vista resultView a partir una peticion que le solicita a otro server fachada
  *este server principal se encarga de realizar los calculos de las peticiones haciendo uso de la calculadora trigonometrica
  *
  * @param req Tiene la informacion de la peticion que llega al servidor.
  * @param res Tiene la informacion con la respuesta del servidor.
  * @return String con la informacion html de la vista de entrada.
  */
private static String resultsView(Request req, Response res) {
	 String funcion=req.queryParams("funcion");
	 String datos = req.queryParams("datos");
	 Calculator cal= new Calculator(); 
	 double respuesta = cal.calculate(funcion,Double.parseDouble(datos));
	 String view = "<!DOCTYPE html>"
            + "<html>"
            + "<body style=\"background-color:#32CD32;\">"
            + "<style>"
            + "table, th, td {"
            + "border: 1px solid black;"
            + "border-collapse: collapse;"
            + "}"
            + "</style>"
            +"<center>"
            + "<h2>Calculadora Trigonometrica</h2>"
            + "  <br><br>"
			 + "<h2>Acontinuacion encontrara una tabla con sus respectivos resultados"
			 + "  <br><br>"
			 + "<Table>"
			 + "<tr>"
		     + "<th>Function</th>"
		     + "<th>Number</th>"
		     + "<th>Respuesta</th>"
		  	 + "</tr>"
		  	 + "<tr>"
		     + "<td>"+funcion+"</td>"
		     + "<td>"+datos+"</td>"
		     + "<td>"+String.valueOf(respuesta)+"</td>"
		     + "</tr>"
		     + "</Table>"
            +"</center>"
            + "</body>"
            + "</html>";
    return view;
}
}
