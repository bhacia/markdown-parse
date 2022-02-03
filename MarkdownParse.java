// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if (markdown.indexOf("(", currentIndex) == -1 || markdown.indexOf(")", currentIndex) == -1 ||
                markdown.indexOf("[", currentIndex) == -1 || markdown.indexOf("]", currentIndex) == -1) {
                break;
            }

            if(markdown.indexOf("!", currentIndex) == currentIndex) {
                break; //shouldn't be an image
            }

            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);

            int openParen = nextCloseBracket + 1;
            char possibleOpenParam = markdown.charAt(openParen);
            if (possibleOpenParam != '(') {
                break; //check if openParen is actually "(" for valid link
            }

            int openParenInSite = markdown.indexOf("(", openParen + 1);
            if(openParenInSite != -1 && openParenInSite < markdown.indexOf("[", openParen)) {
                int closeParenInSite = markdown.indexOf(")", openParenInSite);
                if(openParenInSite != -1 && closeParenInSite != -1) {
                    int closeParen = markdown.indexOf(")", closeParenInSite + 1);
                    if(closeParen < markdown.indexOf("[", nextCloseBracket)) {
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                        currentIndex = closeParen + 1;
                    }
                }
            }
            else {
                //else: there's no extra open paren
                int closeParen = markdown.indexOf(")", openParen);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
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