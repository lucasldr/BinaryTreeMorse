import java.util.Scanner;

public class MorseCodeDecoder {

    public static void main(String[] args) {
        MorseCodeTree morseTree = new MorseCodeTree();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código morse para decodificação (use espaços entre letras e '/' para separar palavras): ");
        String morseCode = scanner.nextLine();

        String decodedMessage = morseTree.decodeMorse(morseCode);
        System.out.println("Mensagem decodificada: " + decodedMessage);
        System.out.println("Caminho: " + getPath(morseTree, morseCode));

        System.out.println("\nÁrvore binária de código Morse:");
        System.out.println(morseTree);
    }

    private static String getPath(MorseCodeTree morseTree, String morseCode) {
        StringBuilder pathBuilder = new StringBuilder();
        String[] sequences = morseCode.split(" ");

        for (String sequence : sequences) {
            if (!sequence.equals("/")) {
                String letter = morseTree.decodeMorse(sequence);
                String letterPath = getLetterPath(morseTree.getRoot(), sequence);
                pathBuilder.append(letter).append(" (caminho: ").append(letterPath).append(") ");
            }
        }
        return pathBuilder.toString();
    }

    private static String getLetterPath(TreeNode root, String morse) {
        StringBuilder path = new StringBuilder();
        TreeNode current = root;

        for (char symbol : morse.toCharArray()) {
            if (symbol == '.') {
                path.append("L");
                current = current.left;
            } else if (symbol == '-') {
                path.append("R");
                current = current.right;
            }
        }
        return path.toString();
    }
}
