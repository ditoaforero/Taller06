
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;
import spark.Response;

public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        get("/taller06", (Request request, Response response) -> {

            double p = 0;
            int dof = 0;
            double x1 = 0;
            double x2 = 0;
            double x3 = 0;

            p = 0.20;
            dof = 6;
            x1 = Estadistica.calcularXDistribucionT(p, dof);

            p = 0.45;
            dof = 15;
            x2 = Estadistica.calcularXDistribucionT(p, dof);

            p = 0.495;
            dof = 4;
            x3 = Estadistica.calcularXDistribucionT(p, dof);

            Map<String, Object> atributes = new HashMap<>();
            atributes.put("x1", Visual.tranformarDecimales(x1,7));
            atributes.put("x2", Visual.tranformarDecimales(x2,7));
            atributes.put("x3", Visual.tranformarDecimales(x3,7));
            return new ModelAndView(atributes, "taller06.ftl");

        }, new FreeMarkerEngine());

        get("/hello", (req, res) -> "Hello World");

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/db", (req, res) -> {
            Connection connection = null;
            Map<String, Object> attributes = new HashMap<>();
            try {
                connection = DatabaseUrl.extract().getConnection();

                Statement stmt = connection.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
                stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
                ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

                ArrayList<String> output = new ArrayList<String>();
                while (rs.next()) {
                    output.add("Read from DB: " + rs.getTimestamp("tick"));
                }

                attributes.put("results", output);
                return new ModelAndView(attributes, "db.ftl");
            } catch (Exception e) {
                attributes.put("message", "There was an error: " + e);
                return new ModelAndView(attributes, "error.ftl");
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }, new FreeMarkerEngine());

//
//        System.out.println("Tarea 05");
//        
//        double valor = 0;
//        DecimalFormat decimales = new DecimalFormat("0.00000000000");
//        int dof = 0;
//        double x = 0;
//        
//
//        // =============== Primer caso ===============//
//        // Se inicializan los valores para el caso
//        dof = 9;
//        x = 1.1f;
//
//        valor = Estadistica.calcularDistribucionT(x, dof);
//        System.out.println("El valor calculado es:" +valor);
//        
//        
//        dof = 10;
//        x = 1.1812f;
//
//        valor = Estadistica.calcularDistribucionT(x, dof);
//        System.out.println("El valor calculado es:" +valor);
//        
//        dof = 30;
//        x = 2.750f;
//
//        valor = Estadistica.calcularDistribucionT(x, dof);
//        System.out.println("El valor calculado es:" +valor);
//        
//        
//        System.out.println("Tarea 06");
//        
//        
//        double p = 0;
//        double x1 = 0;
//        double x2 = 0;
//        double x3 = 0;
//        
//        p= 0.20;
//        dof = 6;
//        
//        x1 = Estadistica.calcularXDistribucionT(p, dof);
//        System.out.println("==================================");
//        System.out.println("El valor de X calculado es:"+x1+" para P:"+p);
//        System.out.println("Verificacion:");
//        valor = Estadistica.calcularDistribucionT(x1, dof);
//        System.out.println("El valor calculado es:" +valor);
//        
//        
//        p= 0.45;
//        dof = 15;
//        
//        x2 = Estadistica.calcularXDistribucionT(p, dof);
//        System.out.println("==================================");
//        System.out.println("El valor de X calculado es:"+x2+" para P:"+p);
//        System.out.println("Verificacion:");
//        valor = Estadistica.calcularDistribucionT(x2, dof);
//        System.out.println("El valor calculado es:" +valor);
//        
//        p= 0.495;
//        dof = 4;
//        
//        x3 = Estadistica.calcularXDistribucionT(p, dof);
//        System.out.println("==================================");
//        System.out.println("El valor de X calculado es:"+x3+" para P:"+p);
//        System.out.println("Verificacion:");
//        valor = Estadistica.calcularDistribucionT(x3, dof);
//        System.out.println("El valor calculado es:" +valor);
//    }
    }
}