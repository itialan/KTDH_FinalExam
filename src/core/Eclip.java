package core;

import org.omg.PortableServer.POA;

import javax.swing.*;
import java.awt.*;

public class Eclip {
    public Point center;
    private int id;
    private int height, width;
    public int eclipA, eclipB;

    public static int subFrameWidth=275, subFrameHight=250, xOBegin=10, yOBegin=25, distance=100, labelSize=25, textSize=75;

    public Eclip() {
        this.center = new Point();
        this.id = id;
        this.height = 0;
        this.width = 0;
    }

    public Eclip(Point center, int height, int width, int id){
        this.id = id;
        this.center = new Point(center);
        this.height = height;
        this.width = width;
    }

    public Eclip(int x1, int y1, int height, int width, int id){
        this.id = id;
        this.center = new Point(x1, y1);
        this.height = height;
        this.width = width;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Point getTamO(){
        return this.center;
    }
    public int getXTamO(){
        return this.center.getX();
    }
    public int getYTamO(){
        return this.center.getY();
    }
    public int getheight(){
        return this.height;
    }
    public int getwidth(){
        return this.width;
    }
    public void setTamO(Point tamO){
        this.center=tamO;
    }
    public void setXTamO(int x){
        this.center.setX(x);
    }
    public void setYTamO(int y){
        this.center.setY(y);
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setWidth(int width){
        this.width=width;
    }

    public int getEclipA() {
        return eclipA;
    }

    public void setEclipA(int eclipA) {
        this.eclipA = eclipA;
    }

    public int getEclipB() {
        return eclipB;
    }

    public void setEclipB(int eclipB) {
        this.eclipB = eclipB;
    }

    public JPanel draw() {
        int x = this.center.getX();
        int y = this.center.getY();

        int width = (int) getwidth();
        int height = (int) getheight();

        int xPanel = x - width;
        int yPanel = y - height;

        JPanel panelDraw = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                int x, y, fx, fy, a2, b2, p;
                x = 0;
                y = height;
                a2 = width*width;
                b2 = height*height;
                fx = 0;
                fy = 2 * a2 * y;
                g.drawOval(x+width, height-y, 1, 1);
                g.drawOval(-x+width, height-y, 1, 1);
                g.drawOval(x+width, height-(-y), 1, 1);
                g.drawOval(-x+width, height-(-y), 1, 1);
                p = (int) Math.round(b2-a2*height+0.25*a2);//p=b2 - a2*b +a2/4
                while(fx<fy)
                {
                    x++;
                    fx += 2*b2;
                    if(p<0)
                    {
                        p += b2*(2*x + 3);//p=p + b2*(2x +3)
                    }
                    else
                    {
                        y--;
                        p += b2*(2*x +3) + a2*(2- 2*y);//p=p +b2(2x +3) +a2(2-2y)
                        fy -= 2*a2;
                    }
                    g.drawOval(x+width, height-y, 1, 1);
                    g.drawOval(-x+width, height-y, 1, 1);
                    g.drawOval(x+width, height-(-y), 1, 1);
                    g.drawOval(-x+width, height-(-y), 1, 1);
                }
                p = (int) Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
                //
                while(y > 0)
                {
                    y--;
                    fy -= 2*a2;

                    if(p >= 0)
                    {
                        p += a2 * (3 - 2*y); //p=p +a2(3-2y)
                    }
                    else
                    {
                        x++;
                        fx += 2 * b2;
                        p += b2*(2*x +2) +a2*(3- 2*y);//p=p+ b2(2x +2) + a2(3-2y)
                    }
                    g.drawOval(x+width, height-y, 1, 1);
                    g.drawOval(-x+width, height-y, 1, 1);
                    g.drawOval(x+width, height-(-y), 1, 1);
                    g.drawOval(-x+width, height-(-y), 1, 1);
                }
            }

        };
        panelDraw.setOpaque(false);

        panelDraw.setBounds(xPanel, yPanel, width*2+1,height*2+1);
        return panelDraw;
    }
}
