
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dito
 */
public class Visual {
    
    
    
    public static List tranformarDecimales(List<Double> listadoValores, int numDecimales){
        String parametroDecimales="0.00000000";
        switch(numDecimales){
            case 1:
                parametroDecimales = "0.0";
                break;
            case 2:
                parametroDecimales = "0.00";
                break;
            case 3:
                parametroDecimales = "0.000";
                break;
            case 4:
                parametroDecimales = "0.0000";
                break;
            case 5:
                parametroDecimales = "0.00000";
                break;
            case 6:
                parametroDecimales = "0.000000";
                break;
            case 7:
                parametroDecimales = "0.0000000";
                break;
            case 8:
                parametroDecimales = "0.00000000";
                break;
        }
        List valoresTranformados = new ArrayList();
        DecimalFormat decimales = new DecimalFormat(parametroDecimales);
        String valorConvertido;
        for (int i = 0; i < listadoValores.size(); i++) {
            valorConvertido = decimales.format(listadoValores.get(i));
            valoresTranformados.add(valorConvertido);
        }
        return valoresTranformados;
    }
    
    public static String tranformarDecimales(double valorTransformar, int numDecimales){
        String parametroDecimales="0.00000000";
        switch(numDecimales){
            case 1:
                parametroDecimales = "0.0";
                break;
            case 2:
                parametroDecimales = "0.00";
                break;
            case 3:
                parametroDecimales = "0.000";
                break;
            case 4:
                parametroDecimales = "0.0000";
                break;
            case 5:
                parametroDecimales = "0.00000";
                break;
            case 6:
                parametroDecimales = "0.000000";
                break;
            case 7:
                parametroDecimales = "0.0000000";
                break;
            case 8:
                parametroDecimales = "0.00000000";
                break;
        }
       
        DecimalFormat decimales = new DecimalFormat(parametroDecimales);  
        return decimales.format(valorTransformar);
    }
            
    
}
