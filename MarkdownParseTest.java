import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents = Files.readString(Path.of("./test-file1.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents = Files.readString(Path.of("./test-file2.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException {
        String contents = Files.readString(Path.of("./test-file3.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
