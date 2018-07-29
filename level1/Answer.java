//package com.google.challenges;

public class Answer {
  public static int answer(int[] x, int[] y) {

    //if length of x is greater than y
    if(x.length > y.length){
      for(int i = 0; i < x.length; i++){
        int k = 0;
        for(int j = 0; j < y.length; j++){
          if(x[i] == y[j]){
            k++;
          }
          if(j == y.length - 1 && k == 0){
            return x[i];
          }
        }
      }
    }
    else{
      for(int i = 0; i < y.length; i++){
        int k = 0;
        for(int j = 0; j < x.length; j++){
          if(y[i] == x[j]){
            k++;
          }
          if(j == x.length - 1 && k == 0){
            return y[i];
          }
        }
      }
    }
    return -1;
  }

    public static void main(String[] args) {
      int[] abc = {13,5,6,2,5};
      int[] def = {5,2,5,13};
      System.out.println(answer(abc,def));
      int[] ABC = {14, 27, 1, 4, 2, 50, 3, 1};
      int[] DEF = {2, 4, -4, 3, 1, 1, 14, 27, 50};
      System.out.println(answer(ABC,DEF));
    }
}
