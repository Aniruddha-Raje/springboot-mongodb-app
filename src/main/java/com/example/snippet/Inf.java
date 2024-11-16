package com.example.snippet;

public interface Inf {

    void doSomething();

    //to provide backward compatibility, does not force impl classes to override
    default void defMethod(){

    }

    //call without creating obj, shared amongst all obj instances, utility functionality, cannot be overridden
    static void staticUtilsMethod() {

    }

    private void helperMethod(){

    }
}
