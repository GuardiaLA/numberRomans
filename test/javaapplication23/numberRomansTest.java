/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class numberRomansTest {
    numberRomans romans = new numberRomans();
    public numberRomansTest() {
    }

    /**
     * Test of main method, of class numberRomans.
     */
    @Test
    public void test_when_send_value_empty() {  
        String numberRoman = "";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_value_valid() {  
        String numberRoman = "XXX";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 30;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_value_invalid() {  
        String numberRoman = "IIII";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_characters_special() {  
        String numberRoman = "???";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_numbers_natural() {  
        String numberRoman = "XX23";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_space_white() {  
        String numberRoman = "";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_letters() {  
        String numberRoman = "LCABAB";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 0;
        assertEquals(expected, valueRoman);
    }
    
    @Test
    public void test_when_send_values_in_uppercase() {  
        String numberRoman = "clv";
        int valueRoman = romans.convertToInt(numberRoman);
        int expected = 155;
        assertEquals(expected, valueRoman);
    }
}
