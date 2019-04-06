public class MyLinkedList{
  private Node headReference;
  private Node tailReference;

  public String toString() {
    Node currentNode = headReference;
    String ans = "";
    ans += "# elements: " + size() + " ";
    ans += " [";

    for (int i = 0; i < size(); i++){
      ans += currentNode.getCargoReference() + ", ";
      currentNode = currentNode.getReferenceToNextNode();
    }

    return ans + "]";
  }

  public int size() {
    Node check = headReference;
    int count = 0;
    if (headReference != null){
      count++;
      while (check.getReferenceToNextNode() != null){
        count++;
        check = check.getReferenceToNextNode();
      }
    }
    return count;
  }

    //not REQUIRED, but it would be crazy of you not to have this
  public MyLinkedList() {
    headReference = null;
    tailReference = null;
  }

  public void clear(){
    headReference = null;
    tailReference = null;
  }
    //reset the list to an empty state. Very similar to the constructor.
  public boolean add(Object val){
    if (size() == 0){
      Node head = new Node(val);
      headReference = head;
      tailReference = head;
    }else{
      Node nextNode = new Node(val);
      tailReference.setReferenceToNextNode(nextNode);
      tailReference = nextNode;
    }
    return true;
  }

    //add an element to the end of the list (the boolean would be true all the time if you want to conform to list standards)
  public void extend(MyLinkedList other){
    if (headReference == null){
      headReference = other.headReference;
      tailReference = other.tailReference;
      other.clear();
    }else if (other.headReference == null) {
      return;
    }else{
      tailReference.setReferenceToNextNode(other.headReference);
      tailReference = other.tailReference;
      other.clear();
    }
  }

  public int firstElement(){
    return (int)headReference.getCargoReference();
  }
     /**in O(1) time, connect the other list to the end of this list.
    The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
    This is how you will merge lists together for your radix sort.
    **/
  public Object removeFront(){
    if (size() == 0){
      return -1;
    }
    Object returner = headReference.getReferenceToNextNode();
    headReference = headReference.getReferenceToNextNode();
    return returner;
  }


    //remove the 1st element of the list, and return that value.

  public class Node {
      private Object cargoReference;
      private Node   referenceToNextNode;


      /**
        Construct an instance
       */
      public Node( Object cargoReference) {
          this.cargoReference = cargoReference;
          // default value is fine for Node.next
      }
      public Node( Object cargoReference, Node referenceToNextNode) {
          this( cargoReference);
          this.referenceToNextNode = referenceToNextNode;
      }

      /**
        @return a string representation of this instance
       */
      public String toString() {
          String result =
              cargoReference.toString()  // polymorphically use appropriately toString!
            + " id " // include a usually-unique identifier for this node
            + super.toString()
            ;

          // Show rest of chain of nodes
          if( referenceToNextNode == null)
               result += " [no next]";
          else result += " --> " + referenceToNextNode;
          return result;
      }

      // classic accessor and mutator
      public Node getReferenceToNextNode() {
          return referenceToNextNode;
      }

      public Node setReferenceToNextNode( Node referenceToNextNode) {
          Node saveForReturn = this.referenceToNextNode;
          this.referenceToNextNode = referenceToNextNode;
          return saveForReturn;
      }

      public Object getCargoReference() {
          return cargoReference;
      }

      public Object setCargoReference( Object newValue) {
          Object saveForReturn = cargoReference;
          cargoReference = newValue;
          return saveForReturn;
      }
  }
}
