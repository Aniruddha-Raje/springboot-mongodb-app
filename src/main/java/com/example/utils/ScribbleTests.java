package com.example.utils;

import java.util.List;

public class ScribbleTests {
    public static void main(String[] args) {
        String str = "hello world";
        ScribbleTests test = new ScribbleTests();
        StringBuilder sb = new StringBuilder();

        String[] arr = str.split(" ");

        for(String curr: arr){
            sb.append(test.rev(curr) + " ");
        }

        System.out.println(sb);

    }

    public StringBuilder rev(String str){
        String[] arr = str.split("");
        StringBuilder sb =  new StringBuilder();

        for(int i = arr.length -1; i >= 0 ; i--){
            sb.append(arr[i]);
        }

        return sb;
    }
}
