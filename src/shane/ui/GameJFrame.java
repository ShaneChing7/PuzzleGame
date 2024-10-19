package shane.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建Random对象
    Random rand = new Random();

    //创建一个二维数组
    //加载图片时，会根据数组里的值打乱图片
    int[][] data = new int[4][4];

    //判断胜利数组
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //统计步数
    int step = 0;

    //在二维数组中，0的位置
    int x = 0;
    int y = 0;

    //创建选项下的条目对象
    JMenuItem bar_function_replay = new JMenuItem("Replay");
    JMenuItem bar_function_relogin = new JMenuItem("Relogin");
    JMenuItem bar_function_close = new JMenuItem("CloseGame");

    JMenuItem bar_about_Account = new JMenuItem("Official Account");

    //创建二级菜单changePicture下的条目对象
    JMenuItem Sport = new JMenuItem("Sport");
    JMenuItem Girl = new JMenuItem("Girl");
    JMenuItem Animal = new JMenuItem("Animal");


    //初始随机图片路径
    String path = "";


    //方法的空参构造-------------------------------------------------------------------------
    public GameJFrame() {
        //初始化游戏界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //最初始的随机图片
        initGraph();

        //初始化数据（打乱）
        initData();

        //初始化图片
        initImage();

        //设置页面可见
        this.setVisible(true);

    }




    //创建最外层的弹窗----------------------------------------------------------------------------
    private void initJFrame() {
        // 初始化游戏界面
        // 初始化游戏界面,宽高
        this.setSize(603, 680);

        // 初始化游戏界面,标题
        this.setTitle("拼图游戏1.0");

        //设置页面置顶（应用的最上层）
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置页面关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中布局,之有取消了才能按照xy轴的方式布局添加组件
        this.setLayout(null);

        //给游戏界面添加键盘监听
        this.addKeyListener(this);
    }


    //创建菜单以及菜单按键的监听绑定-------------------------------------------------------------
    private void initJMenuBar() {
        //创建菜单对象bar
        JMenuBar menuBar = new JMenuBar();

        //创建菜单bar上面的两个选项的对象（功能 关于我们）
        JMenu bar_function = new JMenu("Function");
        JMenu bar_about = new JMenu("About Us");
        //创建菜单下的二级菜单对象
        JMenu changePicture = new JMenu("Change Picture");



        //将每一个选项下面的条目添加到对应的选项中去
        bar_function.add(bar_function_replay);
        bar_function.add(bar_function_relogin);
        bar_function.add(bar_function_close);

        bar_about.add(bar_about_Account);

        //将条目运动、美女、动物、添加到二级菜单changePicture下
        changePicture.add(Sport);
        changePicture.add(Animal);
        changePicture.add(Girl);


        //给条目绑定监听事件
        bar_function_replay.addActionListener(this);
        bar_function_relogin.addActionListener(this);
        bar_function_close.addActionListener(this);
        bar_about_Account.addActionListener(this);
        Sport.addActionListener(this);
        Girl.addActionListener(this);
        Animal.addActionListener(this);
        //将两个选项添加到菜单中去
        menuBar.add(bar_function);
        menuBar.add(bar_about);
        //将二级菜单changePicture添加到一级菜单function中
        bar_function.add(changePicture);

        //给整个界面设置菜单
        this.setJMenuBar(menuBar);
    }

    //打开软件最初的随街图片生成-----------------------------------------------------------------------
    public void initGraph(){
        //初始随机图片路径
        int a = rand.nextInt(3);
        if(a == 0){
            path = "image\\sport\\sport"+rand.nextInt(1,11)+"\\";
        } else if(a == 1){
            path = "image\\girl\\girl"+rand.nextInt(1,14)+"\\";
        } else {
            path = "image\\animal\\animal"+rand.nextInt(1,9)+"\\";
        }
    }


    //初始化数据（打乱）------------------------------------------------------------------------------
    private void initData() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(16);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = arr[i];
        }

    }

    //初始化图片----------------------------------------------------------------------------------------
    private void initImage() {
        this.getContentPane().removeAll();

        if (checkWin()) {
            JLabel winJLabel = new JLabel(new ImageIcon("image/win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }


    //创建一个JLabel对象，管理图片
        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        //先加载的图片在上方，后添加的图片在下方

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path + data[i][j] + ".jpg"));
                //指定图片位置,此界面二维xy坐标与二维数组xy坐标相反注意
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //设置图片边框
                //设置图片边框的类型
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        ImageIcon background = new ImageIcon("image\\background.png");
        JLabel bg = (new JLabel(background));
        bg.setBounds(40, 40, background.getIconWidth(), background.getIconHeight());
        this.getContentPane().add(bg);

        this.repaint();
    }



    //接口方法的重写------------------------------------------------------------------------------------

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //一直按住时调用此方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //删除界面中所有图片
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon background = new ImageIcon("image\\background.png");
            JLabel bg = (new JLabel(background));
            bg.setBounds(40, 40, background.getIconWidth(), background.getIconHeight());
            this.getContentPane().add(bg);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    //松开时调用此方法
    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否胜利
        if (checkWin()) {
            return;
        }

        int code = e.getKeyCode();
        if (code == 38) {//上
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            //每移动一次，步数加一
            step++;
            initImage();
        }
        if (code == 40) {//下
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        }
        if (code == 37) {//左
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        }
        if (code == 39) {//右
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        }
        if (code == 65) {
            initImage();
        }
        if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    //判断data数组中的数据是否和win数组中的数据一致
    public boolean checkWin() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //当前被点击的对象
        Object obj = e.getSource();
        if(obj == bar_function_replay) {
            System.out.println("重新游戏");

            //重新设置步数
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //再次加载图片
            initImage();



        }else if(obj == bar_function_relogin) {
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录陆界面
            new LoginJFrame();
        }else if(obj == bar_function_close) {
            System.out.println("关闭游戏");
           //关闭虚拟机
            System.exit(0);
        }else if(obj == bar_about_Account) {
            System.out.println("关于我们");

            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon( "image/about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(400, 400);
            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框可见
            jDialog.setVisible(true);


        }else if(obj == Sport){
            System.out.println("运动");
            //改变图片路径
            path = "image\\sport\\sport"+rand.nextInt(1,11)+"\\";//1~10
            //重新设置步数
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //再次加载图片
            initImage();
        }else if(obj == Girl){
            System.out.println("美女");
            //改变图片路径
            path = "image\\girl\\girl"+rand.nextInt(1,14)+"\\";//1~13
            //重新设置步数
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //再次加载图片
            initImage();
        }else if(obj == Animal){
            System.out.println("动物");
            //改变图片路径
            path = "image\\animal\\animal"+rand.nextInt(1,9)+"\\";//1~8
            //重新设置步数
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //再次加载图片
            initImage();
        }
    }
}
