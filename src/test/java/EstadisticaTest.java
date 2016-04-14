/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author Dito
 */
public class EstadisticaTest extends TestCase {
    
    public EstadisticaTest(String testName) {
        super(testName);
    }

    /**
     * Test of calcularXDistribucionT method, of class Estadistica.
     */
    public void testCalcularXDistribucionT() {
        System.out.println("calcularXDistribucionT");
        double p = 0.45;
        int dof = 15;
        double expResult = 1.75305;
        double result = Estadistica.calcularXDistribucionT(p, dof);
        System.out.println("esperado:"+expResult+" resultado:"+result);
        assertEquals(expResult, result, 0.00001);
    }
    
}
