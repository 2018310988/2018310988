package xinxi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame implements ActionListener {
    /**********************������ؼ�********************************/
    private JLabel lbAccount=new JLabel("���������˺�");
    private JTextField tfAccount=new JTextField(10);
    private JLabel lbPassword=new JLabel("������������");
    private JPasswordField pfPassword=new JPasswordField(10);
    private JLabel lbPassword2=new JLabel("����ȷ������");
    private JPasswordField pfPassword2=new JPasswordField(10);
    private JLabel lbName=new JLabel("������������");
    private JTextField tfName=new JTextField(10);
    
    private JButton btRegister=new JButton("ע��");
    private JButton btLogin=new JButton("��¼");
    private JButton btExit=new JButton("�˳�");
    public RegisterFrame() {

        super("ע��");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);

        
        this.add(btRegister);
        this.add(btLogin);
        this.add(btExit);
        this.setSize(240,220);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
            String password1=new String(pfPassword.getPassword());
            String password2=new String(pfPassword2.getPassword());
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"�������벻��ͬ");
                return;
            }
            String account=tfAccount.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account!=null) {
                JOptionPane.showMessageDialog(this,"�û��Ѿ�ע��");
                return;
            }
            String name=tfName.getText();
            
            FileOpe.updateCustomer(account,password1,name, name);
            JOptionPane.showMessageDialog(this,"ע��ɹ�");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new LoginFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"лл����");
            System.exit(0);
        }
    }
}
