package listNode;


    public class ListNode {
        private static final Object DUMMY = new Object();

        private ListNode next = null;
        private Integer data = null;

        public ListNode() { }

        public ListNode(int data) {
            this.data = data; }

        public  ListNode(Integer data, ListNode next) {
            this.data = data;
            this.next = next;
        }
}


