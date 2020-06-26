package core;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrucToaDo3D extends JFrame {
    public enum Choose{Sphere, Cube}
    Choose choose = Choose.Sphere;

    public JPanel createPanel3D() {
        JPanel panel3D = new JPanel();
        panel3D.setLayout(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton sphere, cube;
        ImageIcon iconSphere, iconCube;

        iconSphere=new ImageIcon("./resources/image/sphere.png");
        sphere = new JButton(iconSphere);
        sphere.setFocusPainted(false);
        sphere.setBackground(Color.white);
        sphere.setContentAreaFilled(false);
        sphere.setOpaque(true);
        sphere.setBounds(0, 0, 50, 30);

        iconCube = new ImageIcon("./resources/image/cube.png");
        cube = new JButton(iconCube);
        cube.setFocusPainted(false);
        cube.setBackground(Color.white);
        cube.setContentAreaFilled(false);
        cube.setOpaque(true);
        cube.setBounds(50, 0, 50, 30);

        sphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                choose = Choose.Sphere;
                sphere.setBackground(Color.BLACK);
                cube.setBackground(Color.WHITE);
            }
        });

        cube.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                choose = Choose.Cube;
                sphere.setBackground(Color.WHITE);
                cube.setBackground(Color.BLACK);
            }
        });

        panel3D.add(sphere);
        panel3D.add(cube);

        JPanel panelBackground3D = createPanelBackground3D();
        panel3D.add(panelBackground3D);

        return panel3D;
    }

    public JPanel createPanelBackground3D() {
        JPanel background3D = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics arg0) {
                // TODO Auto-generated method stub
                super.paintComponent(arg0);
                arg0.drawLine(Contants.backgroundWidth/2 - 50, 0, core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2);
                for(int i = core.Contants.backgroundHeight/2; i<= core.Contants.backgroundHeight; i+=6){
                    arg0.drawLine(core.Contants.backgroundWidth/2 - 50, i, core.Contants.backgroundWidth/2 - 50,i+3);
                }
                arg0.drawLine(core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2, core.Contants.backgroundWidth, core.Contants.backgroundHeight/2);
                for(int i = core.Contants.backgroundWidth/2; i>=0; i-=6){
                    arg0.drawLine(i, core.Contants.backgroundHeight/2,i - 3, core.Contants.backgroundHeight/2);
                }
                arg0.drawLine(0, core.Contants.backgroundHeight + 100, core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2);
                int l= core.Contants.backgroundHeight/2;
                for(int i = core.Contants.backgroundWidth/2; i< core.Contants.backgroundWidth; i+=6){
                    arg0.drawLine(i - 50, l, i - 47,(int) ((int) l-2.75));
                    l-=5;
                }
            }
        };
        background3D.setLayout(null);
        JLabel labelX,labelY,labelZ,labelO,labelMaxX,labelMinX,labelMaxY,labelMinY,labelMaxZ,labelMinZ;

        labelY=new JLabel("Y");
        labelY.setBounds(core.Contants.backgroundWidth/2 - 35, 10,10 , 10);
        background3D.add(labelY);

        labelMaxY=new JLabel("300");
        labelMaxY.setBounds(core.Contants.backgroundWidth/2 - 10, 10,30 , 10);
        background3D.add(labelMaxY);

        labelMinY=new JLabel("-300");
        labelMinY.setBounds(core.Contants.backgroundWidth/2 - 30, core.Contants.backgroundHeight-15, 30, 10);
        background3D.add(labelMinY);

        labelX=new JLabel("X");
        labelX.setBounds(core.Contants.backgroundWidth-15, core.Contants.backgroundHeight/2-15,10 , 10);
        background3D.add(labelX);

        labelMaxX=new JLabel("375");
        labelMaxX.setBounds(core.Contants.backgroundWidth-30, core.Contants.backgroundHeight/2+15,30 , 10);
        background3D.add(labelMaxX);

        labelMinX=new JLabel("-375");
        labelMinX.setBounds(15, core.Contants.backgroundHeight / 2+15, 30, 10);
        background3D.add(labelMinX);

        labelZ=new JLabel("Z");
        labelZ.setBounds(115, core.Contants.backgroundHeight - 15,10 , 10);
        background3D.add(labelZ);

        labelMaxZ=new JLabel("480");
        labelMaxZ.setBounds(165, core.Contants.backgroundHeight - 15,30 , 10);
        background3D.add(labelMaxZ);

        labelMinZ=new JLabel("-480");
        labelMinZ.setBounds(core.Contants.backgroundWidth/2 + 335, 10, 30, 10);
        background3D.add(labelMinZ);

        labelO=new JLabel("0");
        labelO.setBounds(core.Contants.backgroundWidth/2 - 35, core.Contants.backgroundHeight/2+10,10 , 10);
        background3D.add(labelO);


        background3D.setPreferredSize( new Dimension( 750, 600 ) );
        Border blueBoder;
        blueBoder=BorderFactory.createLineBorder(Color.BLUE);
        background3D.setBorder(blueBoder);
        background3D.setBackground(Color.WHITE);
        background3D.setBounds(10, 50, core.Contants.backgroundWidth, core.Contants.backgroundHeight);

        background3D.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                switch(choose){
                    case Sphere:
                        Sphere s = new Sphere();
                        s.createToaDo3D();

                        Contants.btnDraw.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub


                                Contants.btnDraw.setBackground(Color.GRAY);
                                Contants.btnClear.setBackground(Color.WHITE);

                                s.processTextField();
                                background3D.add(s.draw());
                                background3D.revalidate();
                                background3D.repaint();
                            }
                        });


                        Contants.btnClear.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                Contants.btnDraw.setBackground(Color.WHITE);
                                Contants.btnClear.setBackground(Color.GRAY);

                                s.clear();
                            }
                        });
                        break;
                    case Cube:

                        break;
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

        });


        return background3D;
    }
}

