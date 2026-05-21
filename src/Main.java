import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(600, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();
        JPanel subscript = new JPanel(new GridBagLayout());
        JPanel superscript = new JPanel(new GridBagLayout());

        tab.addTab("下付き文字", subscript);
        tab.addTab("上付き文字", superscript);

        ArrayList<ArrayList<Character>> chars = new ArrayList<>();
        char[][] chars2 = new char[3][];
        chars2[0] = "₁₂₃₄₅₆₇₈₉₀ₐ   ₑ  ₕᵢⱼₖₗₘₙₒₚ ᵣₛₜᵤᵥ ₓ  ₊₋₌₍₎ᵦᵧ ᵨ ᵪᵩ".toCharArray();
        chars2[1] = "¹²³⁴⁵⁶⁷⁸⁹⁰ᴬᴮ ᴰᴱ ᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾ ᴿ ᵀᵁⱽᵂ   ᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖ ʳˢᵗᵘᵛʷˣʸᶻ⁺⁻⁼⁽⁾ᵝᵞᶿ ᵟᵡᵠ".toCharArray();
        char[] greece = new char[25];
        for (char i = 0x0391; i <= 0x03A9; i++) {
            greece[i-0x0391] = i;
        }
        //System.out.println(String.valueOf(greece));
        chars2[2] = greece;


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
        int i = 0;
        int times;
        addcomponent:
        while (true) {
            gbc.gridx = 0;
            for (int j = 0; j < 10; j++) {
                gbc.gridx++;
                times = j+(i*10);
                if (times >= chars2[0].length || times >= chars2[1].length) {break addcomponent;}
                JButton jb = new JButton(String.valueOf(chars2[0][times]));
                jb.setFont(new Font(Font.DIALOG, Font.ITALIC, 28));
                subscript.add(jb, gbc);
                jb = new JButton(String.valueOf(chars2[1][times]));
                jb.setFont(new Font(Font.DIALOG, Font.ITALIC, 28));
                superscript.add(jb, gbc);
            }
            gbc.gridy++;
            i++;
        }
        jf.add(tab);
        
        jf.setVisible(true);
    }
}