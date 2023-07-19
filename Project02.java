import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project02 extends JFrame implements ActionListener, KeyListener {
    private Container container;
    private AnimationPanel ap;
    private JPanel panel;

    public Project02() {
        super("Project02");
        container = getContentPane();
        container.setLayout(new FlowLayout());
        getRootPane().setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));

        addKeyListener(this);

        ap = new AnimationPanel();
        container.add(ap);

        this.createPanel();
        container.add(panel);

        setSize(1024, 768);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        panel.getGraphics().drawString("P - Play    S - Stop    1 - 5    2 - 10    3 - 15    4 - 20    5 - 25    6 - 30", 10, 30);
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(970, 50));
        panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.blue));
        panel.setFont(new Font("Tahoma", 1, 17));
    }

    public void actionPerformed(ActionEvent e) {}

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 49:
                ap.setStatus(1);
                break;
            case 50:
                ap.setStatus(2);
                break;
            case 51:
                ap.setStatus(3);
                break;
            case 52:
                ap.setStatus(4);
                break;
            case 53:
                ap.setStatus(5);
                break;
            case 54:
                ap.setStatus(6);
                break;
            case 80:
                ap.play();
                break;
            case 83:
                ap.stop();
                break;
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
    
    public static void main(String[] args) {
        new Project02();
    }
}
