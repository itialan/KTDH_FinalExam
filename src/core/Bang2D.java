package core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Bang2D extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel MainPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bang2D frame = new Bang2D();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Bang2D() {
        initComponents();

    }
    public void DuongThang(Graphics2D g2d, int x1, int y1, int x2, int y2)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int x = x1;
        int y = y1;
        int P = ((2*dy) - dx);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x, y, 1, 1);
        while (x <= x2) {
            x++;
            if (P < 0) {
                P += 2*dy;
            }
            else if (P >= 0) {
                P += 2*(dy - dx);
                y++;
            }
            g2d.drawOval(x, y, 1, 1);
        }
    }
    void BresenhamLine(Graphics g, int x1, int y1, int x2, int y2)
    {

        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int x = x1;
        int y = y1;
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x, y, 1, 1);
        int D = (Dy << 1) - Dx; // ~ int D = 2*Dy - Dx;
        while(x <= x2)
        {
            x++;
            if (D < 0)
            {
                D = D + (Dy << 1); // ~ D = D + 2*Dy;
            }
            else
            {
                D = D + ((Dy - Dx) << 1); // D = D + 2*(Dy - Dx);
                y++;
            }
            g2d.drawOval(x, y, 1, 1);
        }
    }
    void DDA_Line(Graphics2D g2d, int x1, int y1, int x2, int y2, int K)
    {

        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int x = x1;
        int y = y1;
        float m = Dy/Dx;
        //g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x, y, 1, 1);
        int temp = 0;
        while(x <= x2)
        {
            x++;
            y = Math.round(m + y);
            if (K == 1) {
                temp = x % 6;
                if (temp == 1 || temp == 2 || temp == 3 ) g2d.drawOval(x, y, 1, 1);
            }
            else g2d.drawOval(x, y, 1, 1);
        }
    }
    public void HinhCN(Graphics2D g2d, int x, int y, int width, int height) {
        int x2 = x + width;
        int y2 = y + height;
        for (int i = x; i <= x2; i++) {
            g2d.drawOval(i, y, 1, 1);
            g2d.drawOval(i, y2, 1, 1);
        }
        for (int i = y; i <= y2; i++) {
            g2d.drawOval(x, i, 1, 1);
            g2d.drawOval(x2, i, 1, 1);
        }
    }
    public void HinhTron(Graphics2D g, int x, int y, int R) {
        int x1 = 0;
        int y1 = R;
        int P = (5/4) - R;

        put8Pixel(g, x, y, x1, y1);
        while(x1 < y1) {
            if (P < 0) {
                P += 2*x1 + 3;
            } else {
                P += 2*x1 - 2*y1 + 5;
                y1--;
            }
            x1 += 1;
            put8Pixel(g, x, y, x1, y1);
        }
    }

    public void put8Pixel(Graphics2D g2d, int xc, int yc, int a, int b) {

        //g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(xc + a, yc + b, 1, 1);
        g2d.drawOval(xc - a, yc + b, 1, 1);
        g2d.drawOval(xc - a, yc - b, 1, 1);
        g2d.drawOval(xc + a, yc - b, 1, 1);

        g2d.drawOval(xc + b, yc + a, 1, 1);
        g2d.drawOval(xc - b, yc + a, 1, 1);
        g2d.drawOval(xc - b, yc - a, 1, 1);
        g2d.drawOval(xc + b, yc - a, 1, 1);
    }

    public void CuaSoXe(Graphics2D g2d, int x, int y) {
        //DuongThang(g, x+40, y+20, x + 80, y + 80);
        //BresenhamLine(g, x+120, y, x + 170, y + 180);
        x += 10;
        for (int i = x; i < x+100;i++) {
            g2d.drawOval(i, y-10, 1, 1);
        }
        for (int i = y-10; i < y+72;i++) {
            g2d.drawOval(x, i, 1, 1);
        }
        for (int i = x; i < x+140;i++) {
            g2d.drawOval(i, y+72, 1, 1);
        }

        DDA_Line(g2d, x+100, y-10, x + 140, y + 70,0);
    }
    public void DauXe1(Graphics g, int x, int y) {
        int x1 = x + 450;
        int y1 = y + 300;
        y = y + 70;

        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 51, 102));
        CuaSoXe(g2d,x1+20,y+30);
        for (int i = x1; i < x1+150;i++) {
            g2d.drawOval(i, y, 1, 1);
        }
        //DuongThang(g, x1,y, x1 + 150, y);
        x1 += 150;
        DDA_Line(g2d, x1, y, x1 + 50, y + 100,0);
        x1 += 52;
        y += 103;
        DuongThang(g2d, x1, y, x1 + 78, y + 48);
        x1 +=80;
        y += 50;
        for (int i= y; i<=y1; i++)
            g2d.drawOval(x1, i, 1, 1);
        for (int i= x+450; i<=x1; i++)
            g2d.drawOval(i, y1, 1, 1);
    }
    public void Xe1(Graphics g, int x, int y)
    {
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 204, 102));
        HinhCN(g2d,x,y,450,300);
        g2d.setColor(new Color(0, 0, 51));
        HinhTron(g2d,x+120,y+290,60);
        HinhTron(g2d,x+120,y+290,43);
        HinhTron(g2d,x+560,y+290,60);
        HinhTron(g2d,x+560,y+290,43);
        DauXe1(g,x,y);

        // Bubble
        Random generator = new Random();
        g2d.setColor(new Color(12, 147, 151));
        HinhCN(g2d,x-17,y+280,17,10);

        g2d.setColor(Color.darkGray);
        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-30,y+260,i);

        //g2d.setColor(new Color(112, 47, 51));
        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-23,y+247,i);

        //g2d.setColor(new Color(115, 77, 54));
        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-34,y+278,i);

        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-37,y+240,i);
    }
    public void Xe2(Graphics g, int x, int y) {
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(102, 255, 102));
        for (int i = x; i <= x + 480; i++)
            g2d.drawOval(i, y+300, 1, 1);
        for (int i = y + 300; i >= y + 220; i--)
            g2d.drawOval(x, i, 1, 1);
        for (int i = x; i <= x + 115; i++)
            g2d.drawOval(i, y+220, 1, 1);
        DDA_Line(g2d, x+115, y+ 220, x+210, y+100,0);
        for (int i = x+213; i <= x + 430; i++)
            g2d.drawOval(i, y+123, 1, 1);
        DDA_Line(g2d, x+430, y+123, x+478, y+250,0);
        HinhCN(g2d,x+480,y+200,50,120);

        //Window Font
        g2d.drawLine(x+145, y+220 ,x+220, y + 140);
        for (int i = x+220; i <= x + 300; i++)
            g2d.drawOval(i, y+140, 1, 1);
        for (int i = x+145; i <= x + 300; i++)
            g2d.drawOval(i, y+220, 1, 1);
        for (int i = y+140; i <= y + 220; i++)
            g2d.drawOval(x+300, i, 1, 1);

        //Window Back
        //g2d.drawLine(x+145, y+220 ,x+220, y + 140);
        DDA_Line(g2d, x+415, y+140, x+454, y+220,0);
        for (int i = x+320; i <= x + 415; i++)
            g2d.drawOval(i, y+140, 1, 1);
        for (int i = x+320; i <= x + 453; i++)
            g2d.drawOval(i, y+220, 1, 1);
        for (int i = y+140; i <= y + 220; i++)
            g2d.drawOval(x+320, i, 1, 1);
        for (int i = y+123; i <= y + 300; i++)
            g2d.drawOval(x+310, i, 1, 1);

        //Tire
        g2d.setColor(new Color(255, 102, 102));
        HinhTron(g2d,x+110,y+300,50);
        HinhTron(g2d,x+110,y+300,40);

        HinhTron(g2d,x+400,y+300,50);
        HinhTron(g2d,x+400,y+300,40);

        //Light
        //g2d.setColor(new Color(255, 204, 0));
        //DuongThang(g2d,x-5, y+300,x -570, y+100);
        //DDA_Line(g2d,x-5, y+300,x -150, y+200,0);
        //for (int i = y+300; i >= y+200;i--)
        //for (int j = 0; j <= 10; j++)
        //	DuongThang(g2d,x-5, i ,x -570, i-j);
        //HinhCN(g2d,x-57, i,50,j);
        // Bubble
        Random generator = new Random();
        g2d.setStroke(new BasicStroke(2));


        for (int i =0; i < 10; i++) {
            g2d.setColor(new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
            HinhTron(g2d,x + 540 + generator.nextInt(120), y+260 - generator.nextInt(150),generator.nextInt(20)+1);
        }
//        //g2d.setColor(new Color(112, 47, 51));
//
//        HinhTron(g2d,x + 530 + generator.nextInt(12),y+247 + generator.nextInt(12),i);
//
//        //g2d.setColor(new Color(115, 77, 54));
//
//        HinhTron(g2d,x + 530 + generator.nextInt(12),y+278 + generator.nextInt(12),i);
//
//        HinhTron(g2d,x + 530 + generator.nextInt(12),y+240,i);
    }
    public void Sky(Graphics2D g2d, int x, int y, int size) {
        //g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(3));
        for (int i = 1; i <= size; i++)
            HinhTron(g2d, x,y,i);
        //g2d.setColor(Color.BLUE);


    }
    public void Tree(Graphics g, int x, int y, int height, int width) {
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        //HinhCN(g2d,x,y,50,100);
        g2d.setColor(Color.LIGHT_GRAY);
        y += Math.round(width/2) + 6;
        for (int i = y; i <= y+height; i++) g2d.drawOval(x+10, i, 1, 1);
        for (int i = y; i <= y+height; i++) g2d.drawOval(x+40, i, 1, 1);
        for (int i = x+10; i <= x+40; i++) g2d.drawOval(i, y+height, 1, 1);
        g2d.setColor(Color.GREEN);
        for (int i = 1; i <= width; i++) {
            HinhTron(g2d, x+25,y-20,i);
            HinhTron(g2d, x+50,y,i);
            HinhTron(g2d, x,y,i);
        }

    }
    public static final int x= 100;
    public static final int y = 100;
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1500, 800);
        MainPanel = new JPanel();
        MainPanel.setBackground(new Color(255, 204, 0));
        MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(MainPanel);
        MainPanel.setSize(1500, 800);
        MainPanel.setLayout(null);
        JPanel XePanel = new JPanel();
        XePanel.setBackground(Color.WHITE);
        XePanel.setBounds(0, 355, 1496, 355);
        JPanel SideWalkPanel = new JPanel();
        SideWalkPanel.setBackground(new Color(0, 153, 255));
        SideWalkPanel.setBounds(0, 158, 1496, 197);
        JPanel SkyPanel = new JPanel();
        SkyPanel.setBackground(new Color(224, 255, 255));
        SkyPanel.setBounds(0, 0, 1496, 162);
        JButton Run_Button = new JButton("Run");

        Run_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = SkyPanel.getGraphics();
                Graphics2D g2d = (Graphics2D) g.create();

                int x1 = -700;
                int y1 = 357;

                g2d.setColor(Color.ORANGE);
                Sky(g2d,750,100,100);
                //Graphics g3 = MainPanel.getGraphics();
                Graphics g1 = XePanel.getGraphics();
                Graphics g2 = SideWalkPanel.getGraphics();
                //Graphics2D g2dSW = (Graphics2D) g2.create();
                //Graphics2D g12d = (Graphics2D) g.create();
                while(x1 <= XePanel.getWidth()+67) {

                    try {

                        XePanel.update(g1);
                        SideWalkPanel.update(g2);

                        Xe1(g1,x1,y1);
                        //Xe1(g1,400,357);
                        //Tree(g2,750,255,62,25);
                        x1 += 50;

                        Thread.sleep(450);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                int y_sun = 100;
                //Xe2(g1,400,357);
                int size = 100;
                int x_moon = SkyPanel.getWidth() - 50;
                int size_moon = 50;
                for (int i = 0; i <= 6; i++) {
                    try {
                        //if (count == 2) size /= 2;
                        SkyPanel.update(g);

                        if (i <= 2) {
                            Sky(g2d,750,y_sun,size+10);
                            y_sun += 50;
                        }
                        else if (i > 2 && i < 5) {
                            Sky(g2d,750,y_sun,size+10);
                            y_sun += 50;
                            g2d.setColor(Color.LIGHT_GRAY);
                            Sky(g2d,x_moon,100,size_moon);
                            x_moon -= 200;
                            size_moon += 5;
                            g2d.setColor(Color.ORANGE);

                        }
                        else if (i == 5) {
                            SkyPanel.setBackground(Color.DARK_GRAY);
                            XePanel.setBackground(Color.DARK_GRAY);
                            SideWalkPanel.setBackground(new Color(0, 51, 102));

                            //MainPanel.update(g3);
                            SkyPanel.update(g);
                            XePanel.update(g1);
                            SideWalkPanel.update(g2);

                            g2d.setColor(Color.LIGHT_GRAY);
                            Sky(g2d,x_moon,80,60);

                        }
                        Thread.sleep(450);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //Sky(g2d,750,100,100);
                int x2 = 1500;
                int y2 = 357;
                g2d.setColor(Color.LIGHT_GRAY);
                SkyPanel.setBackground(Color.BLACK);
                SideWalkPanel.setBackground(new Color(0, 51, 102));
                XePanel.setBackground(Color.BLACK);
                Random generator = new Random();
                SkyPanel.update(g);
                XePanel.update(g1);
                SideWalkPanel.update(g2);
                Sky(g2d,750,80,60);

//				g2d.setColor(Color.WHITE);
//				g2d.setStroke(new BasicStroke(2));
//			    for (int i = 0; i < 54; i++) {
//			    	HinhTron(g2d, 10 + generator.nextInt(1494)+1,generator.nextInt(160)+1, generator.nextInt(2)+1);
//			    	//System.out.println(i);
//			    }
                while (x2 >= -660) {
                    try {
                        Xe2(g1,x2,y2);
                        x2 -= 50;
                        Thread.sleep(450);
                        XePanel.update(g1);
                        SideWalkPanel.update(g2);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            }
        });
        Run_Button.setBounds(718, 500, 170, 45);
        MainPanel.add(Run_Button);


        MainPanel.add(XePanel);


        MainPanel.add(SideWalkPanel);


        MainPanel.add(SkyPanel);

    }
}

