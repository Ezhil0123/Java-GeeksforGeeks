class Solution {
    public int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, parentMap, target);
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    burned = true;
                    visited.add(curr.left);
                    q.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    burned = true;
                    visited.add(curr.right);
                    q.add(curr.right);
                }
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    burned = true;
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
            if (burned) time++;
        }
        return time;
    }
    private Node buildParentMap(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) {
                targetNode = curr;
            }
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }
}