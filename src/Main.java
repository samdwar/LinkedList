import java.util.Arrays;

/**
 * Created by sam on 2/3/17.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);

        System.out.println("Before Sorting the LL");
        linkedList.printLinkedList();

        linkedList.mergeSort();
        System.out.println("After sorting the LL");
        linkedList.printLinkedList();
    }
}
