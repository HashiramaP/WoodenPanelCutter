import javax.swing.*;

public class Swingtake2  extends JFrame{
    private JButton undoButton;
    private JButton redoButton;
    private JButton saveButton1;
    private JButton discardButton;
    private JButton coupeEnLButton;
    private JButton coupeRectangulaireButton;
    private JButton coupeEnBordureButton;
    private JButton coupeHorizontaleButton;
    private JButton coupeParalleleButton;
    private JButton coupeReguliereButton;
    private JButton addButton1;
    private JButton deleteButton1;
    private JButton enregistreButton;
    private JButton annulerButton;
    private JButton deleteButton;
    private JButton addButton;
    private JComboBox Outil;
    private JTextField textField1;
    private JTextField textField2;
    private JList list1;
    private JPanel Panel;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton saveButton;
    private JTextField textField3;
    private DrawingPanel drawingPanel1;

    // This method is required for the IntelliJ Form Designer to handle custom components
    private void createUIComponents() {
        // Create an instance of the custom component
        drawingPanel1 = new DrawingPanel();
    }


    public static void main(String[] args) {
        Swingtake2 h=new Swingtake2();
        h.setContentPane(h.Panel);
        h.setTitle("Panel");
        h.setSize(300,400);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
