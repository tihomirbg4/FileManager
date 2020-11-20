import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class FileManipulatorGUI extends JFrame {
    private JButton saveButton;
    private JButton saveChangesButton;
    private JButton openFileButton;
    private JButton swapLinesButton;
    private JButton swapWordsButton;
    private JPanel rootPanel;
    private FileManipulator file;
    private TextEditor editor;
    private JFrame self;
    private JFrame swapLineFrame;
    private JFrame swapWordFrame;
    private List<String> updatedContent;

    public JFrame getSwapWordFrame() {
        return this.swapWordFrame;
    }

    public void setUpdatedContent(List<String> updatedContent) {
        this.updatedContent = updatedContent;
    }

    public JFrame getSwapLineFrame() {
        return this.swapLineFrame;
    }

    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public TextEditor getEditor() {
        return this.editor;
    }

    public FileManipulatorGUI(String title) {
        super(title);
        self = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        final JFileChooser fc = new JFileChooser();
        enableButtons(false);

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Handle open button action.
                if (e.getSource() == openFileButton) {
                    int returnVal = fc.showOpenDialog(FileManipulatorGUI.this);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String fileName = fc.getSelectedFile().getAbsolutePath();

                        file = new FileManipulator(fileName);
                        if (file.isValid("txt")) {
                            try {
                                editor = new TextEditor(file.readContent());
                                JOptionPane.showMessageDialog(rootPanel, "Successfully opened file: " + file.getFileName());
                                enableButtons(true);

                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Choose a valid fileName",
                                    "Invalid fileName",
                                    JOptionPane.ERROR_MESSAGE);
                        }


                        //This is where a real application would open the fileName.
                    }
                }
            }
        });
        swapLinesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                swapLineFrame = new JFrame("Swap Lines");
                swapLineFrame.setSize(500, 400);
                swapLineFrame.setContentPane(new SwapLinesForm(self).getSwapLinePanel());
                swapLineFrame.setVisible(true);
            }
        });
        swapWordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapWordFrame = new JFrame("Swap Words");
                swapWordFrame.setSize(500, 400);
                swapWordFrame.setContentPane(new SwapWordsForm(self).getSwapWordPanel());
                swapWordFrame.setVisible(true);
            }
        });
        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!updatedContent.isEmpty())
                    {
                        file.saveContent(updatedContent);
                        JOptionPane.showMessageDialog(rootPanel, "Successfully saved data!");
                    }
                } catch (NullPointerException | IOException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Make sure you choose one of the swap options!",
                            "Invalid operation",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void enableButtons(boolean enabled) {
        swapLinesButton.setEnabled(enabled);
        swapWordsButton.setEnabled(enabled);
        saveChangesButton.setEnabled(enabled);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
