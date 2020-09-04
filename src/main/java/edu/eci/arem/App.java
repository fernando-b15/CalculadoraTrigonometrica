package edu.eci.arem;

import static spark.Spark.*;
import java.util.ArrayList;
import edu.eci.arem.Calculators.Calculator;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	port(getPort());
    	get("/respuesta", (req, res) ->  resultsView(req, res));
    }
    
 private static int getPort() {
   	 if (System.getenv("PORT") != null) {
   		 return Integer.parseInt(System.getenv("PORT"));
   	 }
   	 return 5000; //returns default port if heroku-port isn't set
   }

private static String resultsView(Request req, Response res) {
	 System.out.println("legooooooooooooooooooooooooooooooooo");
	 System.out.println(req);
	 String funcion=req.queryParams("funcion");
	 System.out.println("xddddddddddddddddddddd");
	 System.out.println(funcion);
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
