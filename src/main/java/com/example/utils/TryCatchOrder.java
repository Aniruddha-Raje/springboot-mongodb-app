package com.example.utils;

public class TryCatchOrder {
    public static void main(String[] args) {

        try {
            throw new NullPointerException("catch this");
            // Some code that throws NullPointerException
        } catch (NullPointerException npe) {
            // Handle NullPointerException
            System.out.println("NpeEx -> " + npe.getMessage());
        } catch (Exception e) {
            // Handle general exceptions
            System.out.println("Ex -> "+e.getMessage());
        }  finally {
            System.out.println("Finally called");
        }
    }
}
