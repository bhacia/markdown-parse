import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;

        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1) {
                break;
            }
            if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                currentIndex = nextOpenBracket + 1;
                continue;
            }
            if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '`') {
                currentIndex = nextOpenBracket + 1;
                continue;
            }
            System.out.println("NOB = " + nextOpenBracket);

            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket == -1) {
                break;
            }
            int temp = nextCloseBracket + 1;
            char p = markdown.charAt(nextCloseBracket + 1);
            while(p != '(') {
                nextCloseBracket = markdown.indexOf("]", temp);
                System.out.println("NCB = " + nextCloseBracket);
                temp = nextCloseBracket;
                p = markdown.charAt(nextCloseBracket + 1);
            }
            System.out.println("NCB = " + nextCloseBracket);

            int nextOpenParen = nextCloseBracket + 1;
            if(nextOpenParen == -1) {
                break;
            }
            System.out.println("NOP = " + nextOpenParen);

            int nextCloseParen = markdown.indexOf(")", nextOpenParen);
            if(nextCloseParen == -1) {
                break;
            }
            int temp2 = nextCloseParen + 1;
            char c = markdown.charAt(nextCloseParen - 1);
            
            while(c != 'v' || c != 'u' ||
            c != 'g' || c != 'm' ||
            c != 't' || c != 'z' ||
            c != 'o') {
                if(c == 'v' || c == 'u' ||
                c == 'g' || c == 'm' ||
                c == 't' || c == 'z' ||
                c == 'o') {
                    break;
                }
                if(markdown.charAt(nextCloseParen + 1) != ')') {
                    break;
                }
                nextCloseParen = markdown.indexOf(")", temp2);
                System.out.println("NCP = " + nextCloseParen);
                temp2 = nextCloseParen + 1;
                c = markdown.charAt(nextCloseBracket - 1);
            }

            toReturn.add(markdown.substring(nextOpenParen + 1, nextCloseParen));
            System.out.println(toReturn);

            currentIndex = nextCloseParen + 1;
            System.out.println("CI = " + currentIndex + "\n\n");
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}