import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapWordsForm {
    private JPanel swapWordPanel;
    private JTextField firstLineIndex;
    private JTextField secondWordIndex;
    private JTextField secondLineIndex;
    private JTextField firstWordIndex;
    private Integer lineIndex1;
    private Integer wordIndex1;
    private Integer lineIndex2;
    private Integer wordIndex2;
    private JButton swapButton;
    private FileManipulatorGUI parent;

    public JPanel getSwapWordPanel() {
        return this.swapWordPanel;
    }

    public SwapWordsForm(JFrame p) {
        this.parent = (FileManipulatorGUI) p;
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    lineIndex1 = Integer.parseInt(firstLineIndex.getText());
                    wordIndex1 = Integer.parseInt(firstWordIndex.getText());
                    lineIndex2 = Integer.parseInt(secondLineIndex.getText());
                    wordIndex2 = Integer.parseInt(secondWordIndex.getText());

                    parent.setUpdatedContent(parent.getEditor().swapWords(lineIndex1,wordIndex1,lineIndex2, wordIndex2));
                    JOptionPane.showMessageDialog(swapWordPanel, "Successfully swapped words!");
                    parent.getSwapWordFrame().dispose();
                }
                catch(IndexOutOfBoundsException ex)
                {
                    JOptionPane.showMessageDialog(swapWordPanel, ex.getMessage(),
                            ex.getMessage(),
                            JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(swapWordPanel, "Only numbers are allowed!",
                            "Invalid input",
                            JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }
}
