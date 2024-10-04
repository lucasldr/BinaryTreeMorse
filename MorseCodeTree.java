public class MorseCodeTree {
    private TreeNode root;

    public MorseCodeTree() {
        root = new TreeNode("");
        insertMorse(root, "A", ".-");
        insertMorse(root, "B", "-...");
        insertMorse(root, "C", "-.-.");
        insertMorse(root, "D", "-..");
        insertMorse(root, "E", ".");
        insertMorse(root, "F", "..-.");
        insertMorse(root, "G", "--.");
        insertMorse(root, "H", "....");
        insertMorse(root, "I", "..");
        insertMorse(root, "J", ".---");
        insertMorse(root, "K", "-.-");
        insertMorse(root, "L", ".-..");
        insertMorse(root, "M", "--");
        insertMorse(root, "N", "-.");
        insertMorse(root, "O", "---");
        insertMorse(root, "P", ".--.");
        insertMorse(root, "Q", "--.-");
        insertMorse(root, "R", ".-.");
        insertMorse(root, "S", "...");
        insertMorse(root, "T", "-");
        insertMorse(root, "U", "..-");
        insertMorse(root, "V", "...-");
        insertMorse(root, "W", ".--");
        insertMorse(root, "X", "-..-");
        insertMorse(root, "Y", "-.--");
        insertMorse(root, "Z", "--..");

    }

    private void insertMorse(TreeNode root, String letter, String morseCode) {
        TreeNode current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new TreeNode("");
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new TreeNode("");
                }
                current = current.right;
            }
        }
        current.charValue = letter;
    }

    public String decodeMorse(String sequence) {
        StringBuilder decoded = new StringBuilder();
        String[] sequences = sequence.split(" ");

        for (String morse : sequences) {
            if (morse.equals("/")) {
                decoded.append(" ");
            } else {
                decoded.append(morseToChar(root, morse, 0));
            }
        }
        return decoded.toString();
    }

    private String morseToChar(TreeNode morseTree, String sequence, int index) {
        if (index == sequence.length()) {
            return morseTree.charValue;
        } else if (sequence.charAt(index) == '.') {
            return morseToChar(morseTree.left, sequence, index + 1);
        } else {
            return morseToChar(morseTree.right, sequence, index + 1);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "", true);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb, String prefix, boolean isTail) {
        if (node.right != null) {
            buildString(node.right, sb, prefix + (isTail ? "│   " : "    "), false);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.charValue).append("\n");
        if (node.left != null) {
            buildString(node.left, sb, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
