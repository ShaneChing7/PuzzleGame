package shane.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {

    public RegisterJFrame() {

        this.setSize(488,500);

        // 初始化游戏界面,标题
        this.setTitle("拼图 注册");

        //设置页面置顶（应用的最上层）
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置页面关闭（只会出现一个界面
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
