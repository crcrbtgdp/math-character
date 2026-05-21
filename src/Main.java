import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new GridBagLayout());
        jf.setSize(600, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        jf.setVisible(true);
    }
}