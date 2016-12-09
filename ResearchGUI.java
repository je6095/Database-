import java.util.*;
import javax.swing.*;
import java.awt.*;

//this is the main view class there are subclasses for each screen.
public class ResearchGUI extends JFrame{
   final static String LOGINPANEL = "Login to System";
   final static String FACULTYPANEL = "Faculty Admin";
   final static String SEARCHPANEL = "Search for papers";
   final static String INFOPANEL = "Paper Information";
   
   private CardLayout cardlayout = new CardLayout();
   private JPanel cards = new JPanel(cardlayout);
   
   //this holds all of the components
   public ResearchGUI(){
      setTitle("Research");
      //base JPanel
         JPanel jpMain = new JPanel();
         //create the cards
            LoginScreen ls = new LoginScreen(this);
            FacultyScreen fs = new FacultyScreen(this);
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
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   //builds and deploys the gui
   public static void main(String[] args){
      ResearchGUI rg = new ResearchGUI();
   }
   
   public void swapView(String key) {
      cardlayout.show(cards, key);
   }
   
}