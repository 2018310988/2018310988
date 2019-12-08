package xinxi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import gongneng.Login;

public class LoginFrame extends JFrame implements ActionListener {

    private Icon welcomeIcon=new ImageIcon("welcome.png");
    private JLabel lbWelcome=new JLabel(welcomeIcon);
    private JLabel lbAccount=new JLabel("�������˺�");
    private JTextField tfAccount=new JTextField(10);
    private JLabel lbPassword=new JLabel("����������");
    private JPasswordField pfPassword=new JPasswordField(10);
    private JButton btLogin=new JButton("��¼");
    private JButton btRegister=new JButton("ע��");
    private JButton btExit=new JButton("�˳�");
    public LoginFrame() {

        super("��¼");
        this.setLayout(new FlowLayout());
        this.add(lbWelcome);
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegister);
        this.add(btExit);
        this.setSize(240,180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /*****************************���Ӽ���************************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=new String(pfPassword.getPassword());
            FileOpe.getInfoByAccount(account);
            if(Conf.account==null||!Conf.password.equals(password)) {
                JOptionPane.showMessageDialog(this,"��¼ʧ��");
                return;
            }
            JOptionPane.showMessageDialog(this,"��¼�ɹ�");
            this.dispose();
            new Login();
        }
        else if(e.getSource()==btRegister) {
            this.dispose();
            new RegisterFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"���");
            System.exit(0);
        }
    }
}
