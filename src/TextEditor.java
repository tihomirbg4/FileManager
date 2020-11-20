import java.util.List;

public class TextEditor implements Editable {
    public static final String ALL_INDEXES_MUST_BE_POSITIVE_MESSAGE = "All indexes must be positive";
    public static final String LINE_INDEX_OUT_OF_BOUNDS_MESSAGE = "Line index out of bounds";
    public static final String WORD_INDEX_OUT_OF_BOUNDS_MESSAGE = "Word index out of bounds";
    private List<String> list;

    public TextEditor(List<String> list) {
        this.list = list;
    }

    @Override
    public List<String> swapLines(int firstIndex, int secondIndex) {
        checkLinesIndices(firstIndex, secondIndex, list.size());

        String temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

        return list;
    }

    private void checkLinesIndices(int firstIndex, int secondIndex, int size) {
        if (firstIndex < 0 || secondIndex < 0) {
            throw new IndexOutOfBoundsException(LINE_INDEX_OUT_OF_BOUNDS_MESSAGE);
        } else if (firstIndex >= size || secondIndex >= size) {
            throw new IndexOutOfBoundsException(LINE_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
    }

    @Override
    public List<String> swapWords(int firstLineIndex, int firstWordIndex, int secondLineIndex, int secondWordIndex) {
        checkLinesIndices(firstLineIndex, secondLineIndex, list.size());
        try
        {

            String[] wordsOnFirstLine = list.get(firstLineIndex).split("\\s+\\t?");

            String[] wordsOnSecondLine = list.get(secondLineIndex).split("\\s+\\t?");

            String temp = wordsOnFirstLine[firstWordIndex];
            wordsOnFirstLine[firstWordIndex] = wordsOnSecondLine[secondWordIndex];
            wordsOnSecondLine[secondWordIndex] = temp;

            String swappedWordsOnFirstLine = String.join(" ", wordsOnFirstLine);
            String swappedWordsOnSecondLine = String.join(" ", wordsOnSecondLine);

            list.set(firstLineIndex, swappedWordsOnFirstLine);
            list.set(secondLineIndex, swappedWordsOnSecondLine);
        }
        catch(IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException(WORD_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }

        return list;
    }
}
