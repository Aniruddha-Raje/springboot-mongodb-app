package com.example.utils;

public class Singleton implements Cloneable {

    private static volatile Singleton instance = null;

    private Singleton(){
        if(instance != null){

        }
    }

    public static Singleton getInstance(){

        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                    return instance;
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("not allowed");
    }
}
