public class MyLinkedList{
  private Node headReference;

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
    //not REQUIRED, but it would be crazy of you not to have this
  public MyLinkedList() {
    headReference = null;
  }

  public void clear(){
    headReference = null;
  }
    //reset the list to an empty state. Very similar to the constructor.
  public boolean add(E){
    if (index == 0){
      addAsHead(val);
    }else{
      Node prevReference = findReferenceAtIndex(index - 1);
      // Node prevReference = headReference;
      // for (int counter = 0; counter < index-1; counter++){
      //   prevReference = prevReference.getReferenceToNextNode();
      //}

      Node referenceAtIndex = prevReference.getReferenceToNextNode();
      Node newNode = new Node(val, referenceAtIndex);
      prevReference.setReferenceToNextNode(newNode);
    }
  }

  public boolean addAsHead( Object val) {
     Node head = new Node(val, headReference);
     headReference = head;
     return true;
  }
    //add an element to the end of the list (the boolean would be true all the time if you want to conform to list standards)
  public void extend(MyLinkedList<E> other){
    
  }
     /**in O(1) time, connect the other list to the end of this list.
    The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
    This is how you will merge lists together for your radix sort.
    **/
  public Object removeFront(){
    remove(0);
  }

  public Object remove(int index){
    Object returner = 0;
    if (index == 0){
      returner = headReference.getCargoReference();
      headReference = headReference.getReferenceToNextNode();
    }else if (index == size() - 1){
      Node secondToLast = findReferenceAtIndex(index - 2);
      Node newLastReference = secondToLast.getReferenceToNextNode();
      returner = newLastReference.getReferenceToNextNode().getCargoReference();
      Node newLast = new Node(newLastReference.getCargoReference());
      secondToLast.setReferenceToNextNode(newLast);

    }else{
      Node refBefore = findReferenceAtIndex(index - 1);
      returner = refBefore.getReferenceToNextNode().getCargoReference();
      Node refAfter = findReferenceAtIndex(index+1);
      refBefore.setReferenceToNextNode(refAfter);
    }
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
