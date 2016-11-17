import java.util.*;
import javax.swing.*;
import java.awt.*;

//this is the main view class there are subclasses for each screen.
public class ResearchGUI extends JFrame{
   
   //this holds all of the components
   public ResearchGUI(){
      setTitle("Research");
      JPanel jpMain = new JPanel(); //main jpanel
      
      
      add(jpMain);//adds the jPanel to the jframe
      setSize(1000,1000);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   //builds and deploys the gui
   public static void main(String[] args){
      ResearchGUI rg = new ResearchGUI();
   }
}