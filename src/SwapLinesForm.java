import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwapLinesForm {
    private JPanel swapLinePanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton swapButton;
    private Integer lineIndex1;
    private Integer lineIndex2;
    private FileManipulatorGUI parent;

    public SwapLinesForm(JFrame p) {
        this.parent = (FileManipulatorGUI) p;
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lineIndex1 = Integer.parseInt(textField1.getText());
                    lineIndex2 = Integer.parseInt(textField2.getText());
                    List<String> updatedList = parent.getEditor().swapLines(lineIndex1, lineIndex2);
                     parent.setUpdatedContent(updatedList);
                    JOptionPane.showMessageDialog(swapLinePanel, "Successfully swapped lines!");
                    parent.getSwapLineFrame().dispose();
                }
                catch(IndexOutOfBoundsException ex)
                {
                    JOptionPane.showMessageDialog(swapLinePanel, ex.getMessage(),
                            ex.getMessage(),
                            JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(swapLinePanel, "Only numbers are allowed!",
                            "Invalid input",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getSwapLinePanel() {
        return this.swapLinePanel;
    }
}
