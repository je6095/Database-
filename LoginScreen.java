import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginScreen extends JPanel implements ActionListener{ // extends JPanel implements ActionListener{ //Login GUI - for logging into the system, checks if you are faculty, student, or other.
   
   private ResearchGUI reGUI;
	JTextField jtfUsername;
	JPasswordField jtfPassword;
	JButton jbEnter;
   JButton jbMiscStudent;
	
	public LoginScreen(ResearchGUI gui){
      this.reGUI = gui;
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
      
      jtfUsername = new JTextField(20);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 1;
      add(jtfUsername, c);
      
      JLabel jlPassword = new JLabel("Password:");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 2;
      add(jlPassword, c);
      
      jtfPassword = new JPasswordField(20);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 2;
      add(jtfPassword, c);
      
      jbEnter = new JButton("Enter");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.0;
      c.gridwidth = 2;
      c.gridx = 1;
      c.gridy = 3;
      add(jbEnter, c);
      jbEnter.addActionListener(this);
      
      jbMiscStudent = new JButton("Student/Other");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.0;
      c.gridwidth = 2;
      c.gridx = 1;
      c.gridy = 4;
      add(jbMiscStudent, c);
      jbMiscStudent.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == jbEnter){
         
   	   String user = jtfUsername.getText();
   	   String pass = jtfPassword.getText().trim();
   	   if(user.isEmpty() || pass.isEmpty())
   	   {
   		   JOptionPane.showMessageDialog(this, "Enter a username or password.");
   	   }
   	   else
   	   {
   		   ConnectDB db = new ConnectDB();
   		   faculty obj = new faculty(user, db);
   		   try 
   		   {
   			   if(obj.login(user, pass) == true)
			   {
			   	   JOptionPane.showMessageDialog(this, "Login Successful.");
			   }
			   else
			   {
				  System.out.println("Failed"); 
			   }
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	   }//end if
      }else if(e.getSource() == jbMiscStudent){
         reGUI.swapView("Search for papers");
      }//end if
   }//end method
} 
