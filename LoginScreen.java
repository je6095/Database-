import java.util.*;
import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JPanel{ //Login GUI - for logging into the system, checks if you are faculty, student, or other.
   public LoginScreen(){
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      
      JLabel jlLogin = new JLabel("<html><h1>Login</h1></html>");
      jlLogin.setHorizontalAlignment(SwingConstants.LEFT);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 0;
      add(jlLogin, c);

      
      //labels
      JLabel jlUsername = new JLabel("Username: ");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 1;
      add(jlUsername, c);
      
      JTextField jtfUsername = new JTextField(20);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 1;
      add(jtfUsername, c);
      
      JLabel jlPassword = new JLabel("Password:");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 2;
      add(jlPassword, c);
      
      JTextField jtfPassword = new JTextField(20);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 2;
      add(jtfPassword, c);
      
      JButton jbEnter = new JButton("Enter");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.0;
      c.gridwidth = 2;
      c.gridx = 1;
      c.gridy = 3;
      add(jbEnter, c);
   }
}
