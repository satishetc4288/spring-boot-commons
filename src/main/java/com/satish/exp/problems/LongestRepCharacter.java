package com.satish.exp.problems;

public class LongestRepCharacter {
    public static void main(String[] args) {
        String str = "gasakkmmaaaaajgsiuarrrrrrrrrrrhsjbaskja";
        printLongestRepCharacter(str);
    }
    private static void printLongestRepCharacter(String str){
        Integer current = 0;
        Integer last = 0;
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1))
                current++;
            else if(current > last){
                last = current;
                current=0;
            }else {
                current=0;
            }
        }
        if(current > last)
            System.out.println(current);
        else
            System.out.println(last);
    }
}
