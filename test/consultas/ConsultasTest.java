/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fatycalderon
 */
public class ConsultasTest {
    
    public ConsultasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of findIdByNombreSuperior method, of class Consultas.
     */
    @Test
    public void testFindIdByNombreSuperior() throws Exception {
        System.out.println("findIdByNombreSuperior");
        String nombreSuperior = "Activo";
        String esperado = null;
        Consultas instance = new Consultas();
        ResultSet rs;
       String expResult = "A0";
        ResultSet result = instance.findIdByNombreSuperior(nombreSuperior);
        if(result.next()){
           esperado= result.getString(1);
        }
        assertEquals(expResult, esperado);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
