import java.util.Scanner;

public class MorseCodeDecoder {

    static class TreeNode {
        String charValue;
        TreeNode left, right;

        public TreeNode(String charValue) {
            this.charValue = charValue;
            this.left = null;
            this.right = null;
        }
    }

    public static void insertMorse(TreeNode root, String letter, String morseCode) {
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
        current.charValue = letter;  // Atribui a letra no nó final
    }

    public static String morseToChar(TreeNode morseTree, String sequence, int index) {
        if (index == sequence.length()) {
            return morseTree.charValue;
        } else if (sequence.charAt(index) == '.') {
            return morseToChar(morseTree.left, sequence, index + 1);
        } else {
            return morseToChar(morseTree.right, sequence, index + 1);
        }
    }

    public static String decodeMorse(TreeNode morseTree, String morseString) {
        StringBuilder decoded = new StringBuilder();
        String[] sequences = morseString.split(" ");

        for (String sequence : sequences) {
            if (sequence.equals("/")) {
                decoded.append(" ");
            } else {
                decoded.append(morseToChar(morseTree, sequence, 0));
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        TreeNode morseTree = new TreeNode("");

        insertMorse(morseTree, "A", ".-");
        insertMorse(morseTree, "B", "-...");
        insertMorse(morseTree, "C", "-.-.");
        insertMorse(morseTree, "D", "-..");
        insertMorse(morseTree, "E", ".");
        insertMorse(morseTree, "F", "..-.");
        insertMorse(morseTree, "G", "--.");
        insertMorse(morseTree, "H", "....");
        insertMorse(morseTree, "I", "..");
        insertMorse(morseTree, "J", ".---");
        insertMorse(morseTree, "K", "-.-");
        insertMorse(morseTree, "L", ".-..");
        insertMorse(morseTree, "M", "--");
        insertMorse(morseTree, "N", "-.");
        insertMorse(morseTree, "O", "---");
        insertMorse(morseTree, "P", ".--.");
        insertMorse(morseTree, "Q", "--.-");
        insertMorse(morseTree, "R", ".-.");
        insertMorse(morseTree, "S", "...");
        insertMorse(morseTree, "T", "-");
        insertMorse(morseTree, "U", "..-");
        insertMorse(morseTree, "V", "...-");
        insertMorse(morseTree, "W", ".--");
        insertMorse(morseTree, "X", "-..-");
        insertMorse(morseTree, "Y", "-.--");
        insertMorse(morseTree, "Z", "--..");
        insertMorse(morseTree, "1", ".----");
        insertMorse(morseTree, "2", "..---");
        insertMorse(morseTree, "3", "...--");
        insertMorse(morseTree, "4", "....-");
        insertMorse(morseTree, "5", ".....");
        insertMorse(morseTree, "6", "-....");
        insertMorse(morseTree, "7", "--...");
        insertMorse(morseTree, "8", "---..");
        insertMorse(morseTree, "9", "----.");
        insertMorse(morseTree, "0", "-----");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código morse para decodificação (use espaços entre letras e '/' para separar palavras): ");
        String morseCode = scanner.nextLine();

        String decodedMessage = decodeMorse(morseTree, morseCode);
        System.out.println("Mensagem decodificada: " + decodedMessage);
    }
}
