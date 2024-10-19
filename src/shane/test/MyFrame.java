package shane.test;

import shane.ui.GameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//动作监听
public class MyFrame extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    MyFrame(){
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("My Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.button1 = new JButton("游戏");
        button1.setBounds(0,0,100,50);
        this.button1.addActionListener(this);
        this.getContentPane().add(button1);


        this.button2 = new JButton("学习");
        button2.setBounds(100,0,100,50);
        this.button2.addActionListener(this);
        this.getContentPane().add(button2);
        this.setVisible(true);


    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button1){
            Random rand = new Random();
            button1.setLocation(rand.nextInt(400),rand.nextInt(450));
        }
        if(e.getSource() == this.button2){
            new GameJFrame();
        }
    }

}
