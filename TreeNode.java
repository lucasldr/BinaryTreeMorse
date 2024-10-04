public class TreeNode {
    String charValue;
    TreeNode left;
    TreeNode right;

    public TreeNode(String charValue) {
        this.charValue = charValue;
        this.left = null;
        this.right = null;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(charValue.isEmpty() ? "*" : charValue).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
