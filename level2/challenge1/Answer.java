//package com.google.challenges;
public class Answer {
  public static int answer(int[] l) {
    if(l.length == 1 && isDivisible(l[0]) ){
      return l[0];
    }
    else if(l.length == 1 && !isDivisible(l[0])){
      return 0;
    }
    else{
      int sum = 0;
      //gets sum of list
      for(int i = 0; i < l.length; i++){
        sum += l[i];
      }
      if(isDivisible(sum)){
        return sortAndCon(l);
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
        if(lowestNum == 10){
          int no1 = 0;
          int no4 = 0;
          for(int i = 0; i < l.length; i++){
            if(l[i] == 1){
              no1 += 1;
            }
            else if(l[i] == 4){
              no4 += 1;
            }
          }
          if(no1 >= 2){
            l = remove(l,1);
            l = remove(l,1);
            return sortAndCon(l);
          }
          else if(no4 >= 2){
            l = remove(l, 4);
            l = remove(l, 4);
            return sortAndCon(l);
          }
          else{
            return 0;
          }
        }
        else{
          l = remove(l, lowestNum);
          return sortAndCon(l);
        }
      }
    }
  }

  public static int sortAndCon(int[] l){
    l = sort(l);
    String numString = "";
    for(int i = 0; i < l.length; i++){
        numString += l[i];
    }
    int number = Integer.parseInt(numString);
    return number;
  }

  public static int indexOf(int[] l, int num){
    for(int i = 0; i < l.length; i++){
      if(l[i] == num){
        return i;
      }
    }
    return -1;
  }

  public static int[] remove(int[] arr, int element){
      int elementIndex = indexOf(arr, element);
      int[] newArr = new int[arr.length - 1];
      int newArrayCounter = 0;
      for(int i = 0; i < arr.length; i++){
        if(i != elementIndex){
          newArr[newArrayCounter] = arr[i];
          newArrayCounter++;
        }
      }
      return newArr;
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
    int[]b = {1,1,1,1,1,1,1,1};
    System.out.println(answer(b));
    int[]c = {3,1,4,1,5,9};
    System.out.println(answer(c));
  }
}
