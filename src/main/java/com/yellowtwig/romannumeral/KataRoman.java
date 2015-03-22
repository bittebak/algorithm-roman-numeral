/*
 * YellowTwig 2015
 */
package com.yellowtwig.romannumeral;

/**
 *
 * @author marcprive
 */
public class KataRoman {

    private enum Symbol
    {
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M');
        private final int value;
        private final char symbol;
        
        private int weight;

        Symbol(int value, char symbol){
            this.value = value;
            this.symbol = symbol;
        }

        public int getValue() {
            return value;
        }
        
        /**
         * Get the value of symbol
         *
         * @return the value of symbol
         */
        public char getSymbol() {
            return symbol;
        }
        
    }
    
    private enum CompoundSymbol{
        CM(Symbol.C, Symbol.M),
        CD(Symbol.C, Symbol.D),
        XC(Symbol.X, Symbol.C),
        XL(Symbol.X, Symbol.L),
        IX(Symbol.I, Symbol.X),
        IV(Symbol.I, Symbol.V);
        
        private final Symbol high;
        private final Symbol low;
        private final int value;
        
        CompoundSymbol(Symbol low, Symbol high){
            this.low = low;
            this.high = high;
            this.value = high.getValue() - low.getValue();
        }

        /**
         * @return the high
         */
        public Symbol getHigh() {
            return high;
        }

        /**
         * @return the low
         */
        public Symbol getLow() {
            return low;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }
    }
    
    /**
     */
    String toRoman(int number){
        int M;
        int rest = number;
        
        StringBuilder romanNumber = new StringBuilder();
        
        //M - 1000
        if(rest >= Symbol.M.getValue()) {
            M = number / Symbol.M.value;
            rest -= addSymbols(romanNumber, Symbol.M, M );
        }
        
        //CM - 900
        if(rest >= CompoundSymbol.CM.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.CM );
        }
        
        //D - 500
        //
        if(rest >= Symbol.D.value) {
            rest -= addSymbol(romanNumber, Symbol.D );
        }

        //CD
        if(rest >= CompoundSymbol.CD.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.CD );
        }
        
        //C
        if(rest >= Symbol.C.value) {
            //C
            int C = rest / Symbol.C.value;
            rest -= addSymbols(romanNumber, Symbol.C, C);
        } 
        
        //XC
        if(rest >= CompoundSymbol.XC.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.XC );
        }
            
        //L
        if(rest >= Symbol.L.value) {
            rest -= addSymbol(romanNumber, Symbol.L );
        } 
        
        //XL
        if(rest >= CompoundSymbol.XL.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.XL );
        }
        
        //X
        if(rest >= Symbol.X.value) {
            int X = rest / Symbol.X.value;
            rest -= addSymbols(romanNumber, Symbol.X, X);
        } 
        
        //IX
        if(rest >= CompoundSymbol.IX.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.IX );
        }
        
        //V
        if(rest >= Symbol.V.value) {
            rest -= addSymbol(romanNumber, Symbol.V );
        } 
        
        //IV
        if(rest >= CompoundSymbol.IV.getValue()) {
            rest -= addSymbol(romanNumber, CompoundSymbol.IV );
        }
        
        //I
        if(rest >= Symbol.I.value) {
            int I = rest / Symbol.I.value;
            rest -= addSymbols(romanNumber, Symbol.I, I);
        } 
        
        return romanNumber.toString();
    }
    
    
    /**
     * 
     * @param builder
     * @param symbol
     * @param count
     * @return total value of the added symbols
     */
    private int addSymbol(StringBuilder builder, Symbol symbol){
        return addSymbols(builder, symbol, 1);
    }
    
    /**
     * 
     * @param builder
     * @param symbol
     * @param count
     * @return total value of the added symbols
     */
    private int addSymbols(StringBuilder builder, Symbol symbol, int count){
       
        for (int i = 0; i < count; i++ ) {
            builder.append(symbol.getSymbol());
        }
        return symbol.value * count;
    }
    
     /**
     * 
     * @param builder
     * @param symbol
     * @return  value of the added symbol
     */
    private int addSymbol(StringBuilder builder, CompoundSymbol symbol){
        builder.append(symbol.getLow().getSymbol());
        builder.append(symbol.getHigh().getSymbol());
        return symbol.value;
    }
    
}
