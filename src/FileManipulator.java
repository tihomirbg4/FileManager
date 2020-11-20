import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManipulator implements FileOperations {
    private File file;

    public  boolean checkFileExtension(String extension) {
        String fileName = file.getName();

        return fileName.endsWith(extension);
    }

    public boolean isValid(String extension) {
        return file.exists() && file.canRead() && file.canWrite() && checkFileExtension(extension);
    }

    public FileManipulator(String fileName) {
        this.file = new File(fileName);
    }

    public String getFileName()
    {
        return file.getName();
    }

    @Override
    public List<String> readContent() throws FileNotFoundException {
        List<String> fileContent = new ArrayList<>();

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                fileContent.add(reader.nextLine());
            }
        }

        return fileContent;
    }

    @Override
    public void saveContent(List<String> updatedList) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (String s : updatedList) {
            writer.write(s
                    .replaceAll("[\\[\\],]", ""));
            writer.write(System.lineSeparator());
        }

        writer.close();
    }
}
