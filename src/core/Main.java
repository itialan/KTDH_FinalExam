package core;

import core.TrucToaDo3D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel contentPane;
    private JTextField textField_R;
    static Main frame = new Main();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setSize(1200, 650);
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

    public Main() {
//        JFrame frame = new JFrame("Ve Hinh Can Ban");
//
//        frame.setSize(1200, 650);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
//
//        TrucToaDo3D toaDo3D = new TrucToaDo3D();
//        frame.add(toaDo3D.createPanel3D());
//        frame.setVisible(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton Button_nhap = new JButton("3D");
        Button_nhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TrucToaDo3D trucToaDo3D = new TrucToaDo3D();
                trucToaDo3D.setSize(1370, 750);
                trucToaDo3D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                trucToaDo3D.setResizable(false);
                trucToaDo3D.add(trucToaDo3D.createPanel3D());
                trucToaDo3D.setVisible(true);
            }
        });
        Button_nhap.setForeground(new Color(135, 120, 235));
        Button_nhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Button_nhap.setBounds(160, 120, 96, 21);
        contentPane.add(Button_nhap);

    }
}
