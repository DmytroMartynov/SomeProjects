import java.util.HashSet;

public class TaskNumber6 {
    static private char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};

    static private String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
            "-..-", "-.--", "--.."};
    static private String[] userInput = {"gin", "zen", "gig", "msg"};

    public static void main(String[] args) {

        uniqueMorseRepresentations(userInput);
    }

    public static void uniqueMorseRepresentations(String[] words) {
        char[] ch = words[0].toCharArray();
        char[] ch1 = words[1].toCharArray();
        char[] ch2 = words[2].toCharArray();
        char[] ch3 = words[3].toCharArray();
        HashSet<String> str = new HashSet<>();
        str.add(morze(ch));
        str.add(morze(ch1));
        str.add(morze(ch2));
        str.add(morze(ch3));
        System.out.println(str.toString());
        System.out.println(str.size());

    }

    public static String morze(char[] character) {
        String str = "";
        for (int i = 0; i < character.length; i++) {
            for (int j = 0; j < english.length; j++) {

                if (english[j] == character[i]) {
                    str = str + morse[j];
                }
            }
        }
        return str;
    }
}
