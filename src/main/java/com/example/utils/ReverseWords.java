package com.example.utils;

public class ReverseWords {

    private static final System.Logger logger = System.getLogger(ReverseWords.class.getName());

    public static void main(String[] args) {
        String str = "hello world";
        ReverseWords test = new ReverseWords();
        StringBuilder sb = new StringBuilder();

        String[] arr = str.split(" ");

        for(String curr: arr){
            sb.append(test.reverse(curr) + " ");
        }

        System.out.println(sb);

    }

    public StringBuilder reverse(String str){
        String[] arr = str.split("");
        StringBuilder sb =  new StringBuilder();

        for(int i = arr.length -1; i >= 0 ; i--){
            sb.append(arr[i]);
        }

        return sb;
    }
}
