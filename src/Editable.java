import java.util.List;

public interface Editable {
    List<String> swapLines(int firstIndex, int secondIndex);

    List<String> swapWords(int firstLineIndex, int firstWordIndex,
                           int secondLineIndex, int secondWordIndex);
}
