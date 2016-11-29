import java.util.*;
import javax.swing.*;
import java.awt.*;

public class InfoScreen extends JPanel{ //Info GUI
   public InfoScreen(){
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      
      JLabel jlTitle = new JLabel("Title:");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 0;
      add(jlTitle, c);
      
      JLabel jlTitleInfo = new JLabel("Some title"); //temp to be replaced with data
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 0;
      add(jlTitleInfo, c);
      
      JLabel jlCitation = new JLabel("Citation:");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 1;
      add(jlCitation, c);
      
      JLabel jlCitationInfo = new JLabel("some citation"); //temp to be replaced with data
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 1;
      add(jlCitationInfo, c);
      
      JTextArea jtaAbstract = new JTextArea(); //information added with data
      jtaAbstract.setPreferredSize(new Dimension(450, 110));
      jtaAbstract.setEnabled(false);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx=1.0;
      c.weighty = 1;
      c.gridwidth = 2;
      c.gridx = 0;
      c.gridy = 3;
      c.anchor = GridBagConstraints.SOUTH;
      add(jtaAbstract, c);
      
      JScrollPane scroll = new JScrollPane (jtaAbstract);
      add(scroll);   
   }
}