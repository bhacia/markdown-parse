import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void goodMath() {
        assertEquals(19, 9 + 10);
    }

    @Test
    public void testFile1() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file1.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file1.md")); //"./test-file1.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }
    
    @Test
    public void testFile2() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file2.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file2.md")); //"./test-file2.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file3.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file3.md")); //"./test-file3.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    //professor's tests

    @Test
    public void TF1() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF1.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF1.md")); //"./TF1.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(labMDP.getLinks(contents), expect);
    }

    @Test
    public void TF2() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF2.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF2.md")); //"./TF2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(labMDP.getLinks(contents), expect);
    }

    @Test
    public void TF3() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF3.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/TF3.md")); //"./TF3.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    @Test
    public void testFile4() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file4.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file4.md")); //"./test-file4.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    @Test
    public void testFile5() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file5.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file5.md")); //"./test-file5.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    /**@Test
    public void testFile6() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file6.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file6.md")); //"./test-file6.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(labMDP.getLinks(contents), expect);
    }**/

    @Test
    public void testFile7() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file7.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file7.md")); //"./test-file7.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, labMDP.getLinks(contents));
    }

    @Test
    public void testFile8() throws IOException { //"C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file8.md"
        String contents = Files.readString(Path.of("C:/Users/15624/OneDrive/Documents/GitHub/markdown-parse/test-file8.md")); //"./test-file8.md"));
        List<String> expect = List.of("a link on the first line");
        assertEquals(expect, labMDP.getLinks(contents));
    }
}