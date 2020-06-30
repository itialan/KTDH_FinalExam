package core;

import core.TrucToaDo3D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel contentPane;
    static Main frame = new Main();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setSize(400, 300);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);

                    frame.setLocationRelativeTo(null);
                    frame.setLayout(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main(){
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn2D = new JButton("2D");
        btn2D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                Bang2D program2D = new Bang2D();
                program2D.setVisible(true);
                program2D.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        btn2D.setForeground(new Color(135, 120, 235));
        btn2D.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn2D.setBounds(160, 80, 96, 21);
        contentPane.add(btn2D);

        JButton btn3D = new JButton("3D");
        btn3D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                TrucToaDo3D trucToaDo3D = new TrucToaDo3D();
                trucToaDo3D.setSize(1370, 750);
//                trucToaDo3D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                trucToaDo3D.setResizable(false);
                trucToaDo3D.add(trucToaDo3D.createPanel3D());
                trucToaDo3D.setVisible(true);
            }
        });
        btn3D.setForeground(new Color(135, 120, 235));
        btn3D.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn3D.setBounds(160, 120, 96, 21);
        contentPane.add(btn3D);

    }
}
