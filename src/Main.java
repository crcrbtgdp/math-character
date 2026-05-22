import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(600, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();
        JPanel[] table = new JPanel[3];
        JScrollPane[] scroll = new JScrollPane[3];
        for (int i = 0; i < 3; i++) {
            table[i] = new JPanel(new GridBagLayout());
            scroll[i] = new JScrollPane(table[i]);
            scroll[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }

        ArrayList<ArrayList<Character>> chars = new ArrayList<>();
        char[][] chars2 = new char[4][];
        chars2[0] = "₁₂₃₄₅₆₇₈₉₀ₐ   ₑ  ₕᵢⱼₖₗₘₙₒₚ ᵣₛₜᵤᵥ ₓ  ₊₋₌₍₎ᵦᵧ ᵨ ᵪᵩ".toCharArray();
        chars2[1] = "¹²³⁴⁵⁶⁷⁸⁹⁰ᴬᴮ ᴰᴱ ᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾ ᴿ ᵀᵁⱽᵂ   ᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖ ʳˢᵗᵘᵛʷˣʸᶻ⁺⁻⁼⁽⁾ᵝᵞᶿ ᵟᵡᵠ".toCharArray();
        char[][] greece = new char[2][25];
        int end3 = 0;
        for (char i = 0; i < 25; i++) {
            char j = 0x03B1;
            greece[0][i] = (i+0x0391 == 0x03A2?' ':(char)(i+0x0391));
            greece[1][i] = (char) (i+0x03B1);
        }
        //System.out.println(String.valueOf(greece));
        chars2[2] = greece[0];
        chars2[3] = greece[1];


        ArrayList<Character> chars3;
        for (char[] chars4 : chars2) {
            chars3 = new ArrayList<>();
            for (Character c : chars4) {
                chars3.add(c);
            }
            chars.add(chars3);
        }
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        int iii = 0;
        int times;
        end3 = 0;
        addcomponent:
        while (true) {
            gbc.gridx = 0;
            for (int j = 0; j < 10; j++) {
                gbc.gridx++;
                times = j+(iii*10);
                if (times >= chars2[0].length || times >= chars2[1].length) {break addcomponent;}
                JButton jb;
                if (end3 == 0 && times >= chars2[2].length) {end3 = 1;}
                int jj = 0;
                for (int i = 0; i < table.length-end3; i++) {
                    do {
                        jj++;
                        jb = new JButton(String.valueOf(chars2[jj-1][times]));
                        jb.setPreferredSize(new Dimension(50,50));
                        jb.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
                        jb.setMargin(new Insets(2, 2, 2, 2));
                        if (jj == 4) {gbc.gridy+=3;}
                        table[i].add(jb, gbc);
                        if (jj == 4) {gbc.gridy-=3;}
                    } while (i == 2 && jj == 3);
                }
            }
            gbc.gridy++;
            iii++;
        }

        for (int i = 0; i < 3; i++) {
            table[i] = addScrollPane(table[i], scroll[i]);
        }

        tab.addTab("下付き文字", table[0]);
        tab.addTab("上付き文字", table[1]);
        tab.addTab("ギリシャ文字", table[2]);
        

        jf.add(tab);
        
        jf.setVisible(true);
    }

    private static JPanel addScrollPane(JPanel a, JScrollPane b) {
        JPanel c = new JPanel();
        c.add(a, BorderLayout.CENTER);
        c.add(b/* , BorderLayout.EAST*/);
        return c;
    }
}