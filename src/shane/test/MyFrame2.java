package shane.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//鼠标监听
public class MyFrame2 extends JFrame implements MouseListener {
    JButton button = new JButton("Click Me");


    MyFrame2() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("My Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        button.setBounds(0,0,100,100);
        button.addMouseListener(this);//绑定鼠标事件，调用方法
        this.getContentPane().add(button);


        this.setVisible(true);

    }




    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }
}
