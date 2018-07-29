//package com.google.challenges;
import java.util.Arrays;
public class Answer {
  public static int answer(int[] l) {
    int sum = 0;
    //gets sum of list
    for(int i = 0; i < l.length; i++){
      sum += l[i];
    }
    if(isDivisible(sum)){
      return sortAndCon(l, true, 0);
    }
    else{
      int lowestNum = 10;
      for(int i = 0; i < l.length; i++){
        int checkSum = 0;
        for(int j = 0; j < l.length; j++){
          if(i != j){
            checkSum += l[j];
          }
        }
        if(isDivisible(checkSum) && l[i] < lowestNum){
          lowestNum = l[i];
        }
      }
      return sortAndCon(l,false,lowestNum);
    }
  }

  public static int sortAndCon(int[] l, boolean divisible, int lowestNum){
    l = sort(l);
    String numString = "";
    if (divisible){
      for(int i = 0; i < l.length; i++){
        numString += l[i];
      }
      int number = Integer.parseInt(numString);
      return number;
    }
    else{
      boolean done = false;
      for(int i = 0; i < l.length; i++){
        if(i != indexOf(l, lowestNum)){
          numString += l[i];
        }
      }
      int number = Integer.parseInt(numString);
      return number;
    }
  }

  public static int indexOf(int[] l, int num){
    for(int i = 0; i < l.length; i++){
      if(l[i] == num){
        return i;
      }
    }
    return -1;
  }

  public static boolean isDivisible(int number){
    return (number % 3 == 0);
  }

  public static int[] sort(int[] data){
    for(int i = 0; i < data.length; i++){
      for (int n = i + 1; n<data.length; n ++ ){
        if (data[n]>data[i]) {
          int tempI = data[i];
          int tempN = data[n];
          data[n] = tempI;
          data[i] = tempN;
        }
      }
    }
    return data;
  }

  public static void main(String[] args) {
    int[]a = {3,1,4,1};
    System.out.println(answer(a));
    int[]b = {3, 1, 4, 1, 5, 9};
    System.out.println(answer(b));
  }
}
