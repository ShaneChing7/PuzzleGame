package shane.test;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Test2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("演示");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setAutoRequestFocus(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        //按钮对象
        JButton button = new JButton("按钮");
        button.setBounds(0, 0, 100, 50);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("hhh");
            }
        });//实现类对象或匿名内部类的对象
        jFrame.getContentPane().add(button);



        jFrame.setVisible(true);

    }
}
