import java.util.*;
import javax.swing.*;
import java.awt.*;

//this is the main view class there are subclasses for each screen.
public class ResearchGUI extends JFrame{
   public JPanel cards;
   final static String LOGINPANEL = "Login to System";
   final static String FACULTYPANEL = "Faculty Admin";
   final static String SEARCHPANEL = "Search for papers";
   final static String INFOPANEL = "Paper Information";
   
   //this holds all of the components
   public ResearchGUI(){
      setTitle("Research");
      //base JPanel
         JPanel jpMain = new JPanel();
         //create the cards
            //LoginScreen ls = new LoginScreen();
            FacultyScreen fs = new FacultyScreen();
            // SearchScreen ss = new SearchScreen();
//             InfoScreen is = new InfoScreen();
            
            //Create the panel that contains the "cards".
            cards = new JPanel(new CardLayout());
            //cards.add(ls, LOGINPANEL);
            cards.add(fs, FACULTYPANEL);
            // cards.add(ss, SEARCHPANEL);
//             cards.add(is, INFOPANEL);
         
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
}