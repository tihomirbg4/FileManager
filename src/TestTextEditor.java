
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTextEditor {

    @Test

    void testFirstLineIndexNegative()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapLines(-1,0);});
    }

    @Test
    void testSecondLineIndexNegative()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapLines(0,-1);});
    }

    @Test
    void testFirstLineIndexOutOfBounds()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapLines(10,0);});
    }

    @Test
    void testSecondLineIndexOutOfBounds()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapLines(2,8);});
    }

    @Test
    void testFirstWordIndexNegative()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapWords(1,-1, 0, 0);});
    }

    @Test
    void testSecondWordIndexNegative()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapWords(1,0, 1, -1);});
    }

    @Test
    void testFirstWordIndexOutOfBounds()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapWords(1,-1, 1, 0);});
    }

    @Test
    void testSecondWordIndexOutOfBounds()
    {
        TextEditor editor = getTextEditor();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {  editor.swapWords(1,0, 1, 3);});
    }
    private TextEditor getTextEditor() {
        List<String> list = new ArrayList<>();

        list.add("asd");
        list.add("agadg");

        return new TextEditor(list);
    }
}
