public class Radix{
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    numDigits = 0;
    for (int i = 0; i < data.length; i++){
      if (data[i] > Math.pow(10, numDigits)){
        numDigits++;
        i--;
      }
    }
    System.out.println(numDigits);
  }
}
