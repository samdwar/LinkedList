/**
 * Created by sam on 2/3/17.
 */
public class LinkedList {
    public void setHead(Node head) {
        this.head = head;
    }

    Node head;

    public Node getHead() {
        return head;
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void printLinkedList() {
        Node temp = getHead();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void mergeSort() {
        Node start = getHead();
        setHead(mergeSortUtils(start));
    }

    private Node mergeSortUtils(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node middle = getMiddleFromLinkedList(start);
        Node secondHalf = middle.next;
        middle.next = null;
        Node left = mergeSortUtils(start);
        Node right = mergeSortUtils(secondHalf);
        return merge(left, right);
    }

    private Node getMiddleFromLinkedList(Node start) {
        if (start == null) return null;
        Node slowPointer = start;
        Node fastPointer = start;
        while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    public Node merge(Node a, Node b) {

        Node newHead = new Node();
        Node sortedList = newHead;
        while (a != null && b != null) {
            if (a.data < b.data) {
                if (sortedList == null) {
                    sortedList = new Node(a.data);
                } else {
                    sortedList.next = new Node(a.data);
                }
                a = a.next;
            } else {
                if (sortedList == null) {
                    sortedList = new Node(b.data);
                } else {
                    sortedList.next = new Node(b.data);
                }
                b = b.next;
            }
            sortedList = sortedList.next;
        }
        while (a != null) {
            if (sortedList == null) {
                sortedList = new Node(a.data);
            } else {
                sortedList.next = new Node(a.data);
            }
            a = a.next;
            sortedList = sortedList.next;
        }

        while (b != null) {
            if (sortedList == null) {
                sortedList = new Node(b.data);
            } else {
                sortedList.next = new Node(b.data);
            }
            b = b.next;
            sortedList = sortedList.next;
        }

        return newHead.next;
    }
}
