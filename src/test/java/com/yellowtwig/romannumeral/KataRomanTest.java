/*
 * YellowTwig 2015
 */
package com.yellowtwig.romannumeral;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcprive
 */
public class KataRomanTest {
    
    public KataRomanTest() {
    }

    /**
     * Test of toRoman method, of class KataRoman.
     */
    @Test
    public void testToRoman()
    {
        System.out.println("toRoman");
        int number = 10;
        KataRoman instance = new KataRoman();
        String expResult = "X";
        String result = instance.toRoman(number);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToRomanM()
    {
        System.out.println("toRoman");
        int number = 3000;
        KataRoman instance = new KataRoman();
        String expResult = "MMM";
        String result = instance.toRoman(number);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToRomanMD()
    {
        System.out.println("toRoman");
        int number = 2500;
        KataRoman instance = new KataRoman();
        String expResult = "MMD";
        String result = instance.toRoman(number);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToRoman2927()
    {
        System.out.println("toRoman");
        int number = 2927;
        KataRoman instance = new KataRoman();
        String expResult = "MMCMXXVII";
        String result = instance.toRoman(number);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void failureTestToRoman()
    {
       System.out.println("toRoman");
        int number = 10;
        KataRoman instance = new KataRoman();
        String expResult = "I";
        String result = instance.toRoman(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
