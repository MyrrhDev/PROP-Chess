package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalGUI {
    private JPanel menuPanel;
    private JButton rankingButton;
    static private JFrame jf;
    private JButton jugarButton;
    private JPanel tabImg;
    private JButton newProblemaButton;
    private JPanel jpButtons;
    private JLabel img;
    private JLabel menuLabel;

    public MenuPrincipalGUI() {
        jf = new JFrame("Logic: Entorno de resolución de problemas de ajedrez");
        jf.setPreferredSize(new Dimension(900, 750));
        jf.setContentPane(menuPanel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        img.setIcon(new ImageIcon(this.getClass().getResource("/res/tableroMenu.png")));
        //img.setIcon(new ImageIcon("./res/tableroMenu.png"));
        menuLabel.setFont(new Font(menuLabel.getName(), Font.PLAIN, 30));
        newProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProblemaGUI();
                jf.setVisible(false);
            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RankingGUI();
                jf.setVisible(false);
            }
        });
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuPartidaGUI();
                jf.setVisible(false);
            }
        });

    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipalGUI();
            }
        });
    }*/
}
