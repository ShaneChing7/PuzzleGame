package shane.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//键盘监听
public class MyFrame3 extends JFrame implements KeyListener {

    MyFrame3() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("My Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setAlwaysOnTop(true);

        //给整个窗体添加键盘监听
        //调用者this：本类对象，当前界面的对象表示给整个界面添加键盘监听
        //this.addKeyListener(new MyFrame3());//绑定键盘事件，调用方法
        this.addKeyListener(this);//绑定键盘事件，调用方法



        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //如果按下一个键不松开，就会重复调用此方法
    //每个按键都有一个编号与之对应
    @Override
    public void keyPressed(KeyEvent e) {//e：事件对象

        System.out.println("按下了"+e.getKeyChar()+"键");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开了"+e.getKeyChar()+"键");
    }
}
