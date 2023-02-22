import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "/Users/maryna/Desktop/FileSaver/Java.txt")
public class TextContainer {
    private final String text = "Some text" ;

    public TextContainer() {
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "text='" + text + '\'' +
                '}';
    }
    @Saver
    public void save(String path){
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.write(text);
            System.out.println("DONE!");
        } catch (FileNotFoundException e) {
            System.out.println("Not saved" + e.getMessage());
            throw new RuntimeException(e);

        }
    }
}
