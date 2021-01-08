package systemanalysis;
import Form.MainMenu;
import Form.T_A_M;
import Form.home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login_screen extends JFrame implements ActionListener {

    public static JTextField user_name;
    JButton signin, home;
    JPasswordField password;
      JLabel sign_in , pass;
    imglog ii = new imglog();

    public login_screen() {
        show_login();
    }

    public void show_login() {
      
     // jlabel 
     sign_in= new JLabel("sign in");
     pass= new JLabel("password");
     sign_in.setBounds(10, 50, 50, 25);
      pass.setBounds(10, 110, 50, 25);
      ii.add(sign_in);
      ii.add(pass);
        // jtextfield 
        user_name = new JTextField();
        password = new JPasswordField();
      user_name.setBounds(100, 50, 200, 25);
         password.setBounds(100, 110, 200, 25);
        ii.add(user_name);
         ii.add(password);

        // jbutton 
        signin = new JButton("sign in");
        signin.setBounds(200, 200, 80, 30);
       
         home = new JButton("home");
        home.setBounds(80, 200, 80, 30); 
        
        ii.add(home);
       ii.add(signin);
       
        signin.addActionListener(this);
        home.addActionListener(this);
        //main
        this.setTitle("record student");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 304);
        this.setLocation(500,140);
        this.setVisible(false);
        this.add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(home)) {
            
            this.dispose();
            Form.home n = new home();
          n.setVisible(true);
            
        }
       
        if (e.getSource().equals(signin)) {

            int i = database.login_database.check_user(user_name.getText(), password.getText());
            switch (i) {
                case 1:
                     if(user_name.getText().equalsIgnoreCase("admin@admin.com")){
             Form.MainMenu x = new MainMenu();
             x.setVisible(true);
          
              this.dispose();
              }else{
                       Form.T_A_M y = new T_A_M();
                       y.setVisible(true);
                   this.dispose();
              }
        
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "password error");
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "user is not found");
                    break;
            }
        }

    }
 
        
    }