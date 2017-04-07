package yangqi.yangqi.leetcode;

/**
 * Created by yangqi on 26/03/2017.
 */
public class AddTwoNumbersSolution {

    private static final String CONNECTER_CHAR = "->";

    public static void main(String[] args) {

        int[] a2 = {2,4,3};
        int[] a1 = {5,6,9};

        ListNode l1 = createList(a1);
        ListNode l2 = createList(a2);

        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        ListNode resultListNode = solution.addTwoNumbers(l1, l2);
        printListNode(resultListNode);


    }

    public static ListNode createList(int[] array) {
        ListNode listNode = null;
        ListNode head = null;
        for (int i : array) {
            if (listNode == null) {
                listNode = new ListNode(i);
                head = listNode;
            } else {
                head.next = new ListNode(i);
                head = head.next;
            }
        }
        return listNode;
    }

    /**
     * @param listNode
     */
    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        StringBuilder valString = new StringBuilder();

        ListNode tempNode = listNode;
        do {
            valString.append(tempNode.val);
            if (tempNode.next != null) {
                valString.append(CONNECTER_CHAR);
            }
        } while ((tempNode = tempNode.next) != null);

        System.out.println(valString.toString());

    }

    /**
     * 正确的，并且简单的实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode resultHead = null;
        ListNode resultListNode = null;
        int sum = 0;
        int carray = 0;
        int reminder = 0;

        while (head1 != null || head2 != null || carray != 0) {
            int val1 = 0, val2 = 0;
            val1 = head1 != null ? head1.val : 0;
            val2 = head2 != null ? head2.val : 0;
            sum = val1 + val2 + carray;
            carray = sum / 10;
            reminder = sum % 10;

            if (resultHead == null) {
                resultHead = new ListNode(reminder);
                resultListNode = resultHead;
            } else {
                resultHead.next = new ListNode(reminder);
                resultHead = resultHead.next;
            }

            head1=head1!=null ? head1.next :null;
            head2=head2!=null ? head2.next :null;

        }
        return resultListNode;


    }


    /**
     * 愚蠢的，而且还是错误的实现；
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode resultList = null;
        ListNode headList = null;

        int l1Size = getSize(l1);

        int l2Size = getSize(l2);

        int radx = 0, resultVal = 0;

        ListNode head = l1;
        if (l1Size < l2Size) {
            head = l2;
        }
        while (head != null) {
            int val1, val2;
            if (head1 != null) {
                val1 = head1.val;
            } else {
                val1 = 0;
            }
            if (head2 != null) {
                val2 = head2.val;
            } else {
                val2 = 0;
            }
            int sum = val1 + val2 + radx;
            if (sum >= 10) {
                radx = 1;
            } else {
                radx = 0;
            }

            resultVal = sum % 10;
            if (resultList == null) {
                resultList = new ListNode(resultVal);
                headList = resultList;
            } else {
                headList.next = new ListNode(resultVal);
                headList = headList.next;
            }
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            head = head.next;
        }

        return resultList;
    }

    private int getSize(ListNode list) {
        int size = 0;
        if (list == null) {
            return size;
        }
        ListNode head = list;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int v) {
            this.val = v;
        }
    }
}

