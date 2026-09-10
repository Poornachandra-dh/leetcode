class Solution {
    public Node connect(Node root) {

        Node current = root;

        while (current != null) {

            Node dummy = new Node(0);
            Node prev = dummy;

            // Traverse current level using next pointers
            while (current != null) {

                // Add left child
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }

                // Add right child
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }

                current = current.next;
            }

            // Move to first node of next level
            current = dummy.next;
        }

        return root;
    }
}