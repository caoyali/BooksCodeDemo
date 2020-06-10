package com.example.exceptions;

import com.example.util.print.Print;

class FourException extends Exception{}

public class AlwaysFinally {
    public static void main(String[] args) {
        Print.print("Entering first try block");
        try {
            Print.print("Entering second try block");
            try {
                throw new FourException();
            } finally {
                Print.print("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}
