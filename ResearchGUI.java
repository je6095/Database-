import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//this is the main view class there are subclasses for each screen.
public class ResearchGUI extends JFrame{
   final static String LOGINPANEL = "Login to System";
   final static String FACULTYPANEL = "Faculty Admin";
   final static String SEARCHPANEL = "Search for papers";
   final static String INFOPANEL = "Paper Information";
   
   private CardLayout cardlayout = new CardLayout();
   private JPanel cards = new JPanel(cardlayout);
   private BusinessLayer currentFaculty=null;
   private ConnectDB connect = null;
   
   //this holds all of the components
   public ResearchGUI(){
      setTitle("Research");
      //base JPanel
         JPanel jpMain = new JPanel();
         //create the cards
            FacultyScreen fs = new FacultyScreen(this);
            LoginScreen ls = new LoginScreen(this,fs);
            SearchScreen ss = new SearchScreen(this);
            InfoScreen is = new InfoScreen(this);
            
            //add all these to cards
            cards.add(ls, LOGINPANEL);
            cards.add(fs, FACULTYPANEL);
            cards.add(ss, SEARCHPANEL);
            cards.add(is, INFOPANEL);
         
         jpMain.add(cards, BorderLayout.CENTER);//adds the jPanel to the jframe
      add(jpMain);
      pack();
      //setResizable(false);
      setLocationRelativeTo(null);
      setVisible(true);
      this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                  try{
                    connect.close();
                 }catch(SQLException se){
                     se.printStackTrace();
                     System.exit(0);
                 }
                    System.exit(1);
                }
            });
   }
   
   //builds and deploys the gui
   public static void main(String[] args){
      ResearchGUI rg = new ResearchGUI();
   }
   
   public void swapView(String key) {
      cardlayout.show(cards, key);
   }
   
   public void setFaculty(BusinessLayer curr){
      this.currentFaculty = curr;
   }
   
   public BusinessLayer getFaculty(){
      return this.currentFaculty;
   }
   public void setDB(ConnectDB db){
      this.connect = db;
   }
}