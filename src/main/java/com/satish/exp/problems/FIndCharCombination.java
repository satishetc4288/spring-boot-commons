package com.satish.exp.problems;

import java.util.List;

public class FIndCharCombination {
    private static String str = "cars";
    public static void main(String[] args) {

        String[] arr = {"ca","r","car","ars"} ;
        findWord(arr, 0, "", "");

    }
    public static void findWord(String[] arr, Integer index, String word , String indexCom){
        System.out.println(indexCom + ", " + word);
        if(word.equals(str)){
            System.out.println(indexCom);
            return;
        }
        if(index == str.length()-1){
            return;
        }
        findWord(arr, index+1, word + arr[index], indexCom + " " + index);
        findWord(arr, index+1, word , indexCom);
    }
}
