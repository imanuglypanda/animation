import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AnimationPanel extends JPanel implements ActionListener {
    private Picture pic[];
    private Timer time;
    private int intPic;
    private ImageIcon ufo[];
    private Random rand;
    private int panelWidth; 
    private int panelHeight;

    public void setUFO(int intUfo) {
        ufo = null;
        pic = null;
        System.gc();
        this.intPic = intUfo;
        ufo = new ImageIcon[intPic];
        loadUFO();
        pic = new Picture[intPic];
        createUfoPosition();
        repaint();

    }

    public void setStatus(int status) {
        switch(status) {
            case 1:
                this.setUFO(5);
                break;
            case 2:
                this.setUFO(10);
                break;
            case 3:
                this.setUFO(15);
                break;
            case 4:
                this.setUFO(20);
                break;
            case 5:
                this.setUFO(25);
                break;
            case 6:
                this.setUFO(30);
                break;
        }
    }

    public AnimationPanel() {
        time = new Timer(1, this);
        panelWidth = 970;
        panelHeight = 660;
        rand = new Random();
        createPanel();
        ufo = new ImageIcon[intPic];
        loadUFO();
        pic = new Picture[intPic];
        createUfoPosition();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int num = 0; num < intPic; num++) { ufo[num].paintIcon(this, g, pic[num].getX(), pic[num].getY()); }
    }

    public void actionPerformed(ActionEvent e) {
        for (int num = 0; num < intPic; num++) { pic[num].animate(); }
        repaint();
    }

    public void loadUFO() {
        for (int i = 0; i < intPic; i++) {
            ufo[i] = new ImageIcon("images/ufo.png");
        }
    }

    public void createUfoPosition() {
        for (int i = 0; i < intPic; i++) {
            int x = rand.nextInt(panelWidth - ufo[i].getIconWidth());
            int y = rand.nextInt(panelHeight - ufo[i].getIconHeight());

            int dx = (rand.nextInt(2) == 0)? rand.nextInt(6) + 1 : -(rand.nextInt(6) + 1);
            int dy = (rand.nextInt(2) == 0)? rand.nextInt(6) + 1 : -(rand.nextInt(6) + 1);

            pic[i] = new Picture(x, y, ufo[i].getIconWidth(), ufo[i].getIconHeight(), panelWidth, panelHeight, dx, dy);
        }
    }

    public void createPanel() {
        setDoubleBuffered(true);
        setPreferredSize(getPreferredSize());
        setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.blue));
    }

    public Dimension getPreferredSize() { return new Dimension(panelWidth, panelHeight); }

    public void play() { time.start(); }
    public void stop() { time.stop(); }
}
