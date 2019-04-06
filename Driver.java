public class Driver{
  public static void main(String[] commandLine){
    //testing MyLinkedList
    MyLinkedList tester = new MyLinkedList();
    // System.out.println(tester);
    // tester.add(0);
    // tester.add(4);
    // System.out.println(tester);
    MyLinkedList t1 = new MyLinkedList();
    t1.add(5);
    tester.extend(t1);
    System.out.println(tester);
    // tester.extend(t1);
    // System.out.println(tester);
    // System.out.println(t1);
    // tester.removeFront();
    // System.out.println(tester);
    // tester.removeFront();
    // System.out.println(tester);


    Radix sorter = new Radix();
    int[] list = {1, 12, 16, 32, 1, 0, 0, 39, 4, 2, 45, 9, 5};
    int[] negatives = {-4, 1, 2, -6, 19, -235, 94, 1};
    sorter.radixsort(list);
    //sorter.radixsort(negatives);


  }
}
