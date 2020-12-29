package Weeks10and11;

import java.util.*;

public class ScalesSolution {
    private String scasol;

    //Creates a new scales solution based on a string parameter
    //The string parameter is checked to see if it contains all zeros and ones
    //Otherwise the random binary string generator is used (n = length of parameter)
    public ScalesSolution(String s) {
        boolean ok = true;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char si = s.charAt(i);
            if (si != '0' && si != '1') ok = false;
        }
        if (ok) {
            scasol = s;
        } else {
            scasol = RandomBinaryString(n);
        }
    }

    private static String RandomBinaryString(int n) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++) {
            s.append(CS2004.UI(0, 1));
        }

        return s.toString();
    }

    public ScalesSolution(int n) {
        scasol = RandomBinaryString(n);
    }

    //This is the fitness function for the Scales problem
    //This function returns -1 if the number of weights is less than
    //the size of the current solution
    public double ScalesFitness(ArrayList<Double> weights) {
        if (scasol.length() > weights.size()) return (-1);
        double lhs = 0.0, rhs = 0.0;
        int n = scasol.length();

        //Code goes here
        //Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
        //to variables lhs and rhs as appropriate
        for (int i = 0; i < scasol.length(); i++) {
            if (scasol.charAt(i) == '0') {
                lhs += weights.get(i);
            } else {
                rhs += weights.get(i);
            }
        }

        return (Math.abs(lhs - rhs));
    }

    public void SmallChange() {
        int r = CS2004.UI(0, scasol.length() - 1);
        char[] scasolChars = scasol.toCharArray();
        scasolChars[r] = scasolChars[r] == '0' ? '1' : '0';
        scasol = String.valueOf(scasolChars);
    }

    public String GetSol() {
        return scasol;
    }

    //Display the string without a new line
    public void print() {
        System.out.print(scasol);
    }

    //Display the string with a new line
    public void println() {
        print();
        System.out.println();
    }
}