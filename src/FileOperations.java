import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileOperations {
    List<String> readContent() throws FileNotFoundException;

    void saveContent(List<String> updatedList) throws IOException;
}
