public class Radix{
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList();
    }
    int numDigits = 0;
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, numDigits)){
        numDigits++;
        i--;
      }
    } // numDigits is the number of maximum digits in the list --> working

    //FIRST INITIALIZATION
    for (int i = 0; i < data.length; i++){
      int num = digitAt(data[i], 0);
      if (data[i] >= 0){
        buckets[num+10].add(data[i]);
      }else{
        buckets[10-num].add(data[i]);
      }
    }
    for(int i = 0; i < 20; i++){
      System.out.println("index: " + i + " " + buckets[i]);
    }
    // for (int nBuckets = 1; nBuckets < 20; nBuckets++){
    //   buckets[0].extend(buckets[nBuckets]);
    //   System.out.println(buckets[0]);
    // }
    for (int nBuckets = 8; nBuckets >= 0; nBuckets--){
      buckets[9].extend(buckets[nBuckets]);
      System.out.println("CHECK THIS" + buckets[9]);
    }
    for (int nBuckets = 10; nBuckets < 20; nBuckets++){
      buckets[9].extend(buckets[nBuckets]);
      System.out.println(buckets[9]);
    }
    System.out.println(buckets[9].toString());

    //SAME THING BUT NOW USE THE BUCKET INSTEAD OF DATA
    System.out.println("using buckets");
    for (int n = 1; n < numDigits; n++){
      MyLinkedList[] newBuckets = new MyLinkedList[20];
      for (int i = 0; i < 20; i++){
        newBuckets[i] = new MyLinkedList();
      }
      while(buckets[9].size() > 0){
        System.out.println(buckets[9].firstElement());
        System.out.println(Math.pow(10, n));
        System.out.println(buckets[9].firstElement() > Math.pow(10, n));
        //if (buckets[0].firstElement() >= Math.pow(10, n)){
          int num = digitAt(buckets[9].firstElement(), n);
          if (buckets[9].firstElement() >= 0){
            newBuckets[num+10].add(buckets[9].firstElement());
            System.out.println(newBuckets[num+10]);
          }else{
            newBuckets[10-num].add(buckets[9].firstElement());
            System.out.println(newBuckets[10-num]);
          }

        buckets[9].removeFront();
      }
      for(int i = 0; i < 20; i++){
        System.out.println("index: " + i + " " + newBuckets[i]);
      }
      // for (int nBuckets = 1; nBuckets < 20; nBuckets++){
      //   newBuckets[0].extend(newBuckets[nBuckets]);
      //   System.out.println(newBuckets[0]);
      // }
      for (int nBuckets = 8; nBuckets >= 0; nBuckets--){
        newBuckets[9].extend(newBuckets[nBuckets]);
        System.out.println(newBuckets[9]);
      }
      for (int nBuckets = 10; nBuckets < 20; nBuckets++){
        newBuckets[9].extend(newBuckets[nBuckets]);
        System.out.println(newBuckets[9]);
      }

      buckets = newBuckets;
    }
  }
  //Remember to change which bucket is what

  private static int digitAt(int num, int index){
    if (Math.abs(num) < Math.pow(10, index))
      return 0;
    String s = String.valueOf(num);
    if (num < 0)
      s = s.substring(1);
    String reverse = new StringBuffer(s).reverse().toString();
    char ch = reverse.charAt(index);
    return Character.getNumericValue(ch);
  }
}
