import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FacultyScreen extends JPanel implements ActionListener{ //Faculty Admin GUI                         
   
   JRadioButton jrbUpdate;
   JRadioButton jrbInsert;
   JRadioButton jrbDelete;
   ButtonGroup group;
   private ResearchGUI reGUI;
   
   public FacultyScreen(ResearchGUI gui){
    this.reGUI = gui;
      setLayout(new BorderLayout());
      GridBagConstraints c = new GridBagConstraints();
      JPanel jpRadio = new JPanel();
         jrbUpdate = new JRadioButton("Update");
         jrbUpdate.setActionCommand("update");
         jrbUpdate.setSelected(true);
   
         jrbInsert = new JRadioButton("Insert");
         jrbInsert.setActionCommand("insert");
         
         jrbDelete = new JRadioButton("Delete");
         jrbDelete.setActionCommand("delete");
         
         ButtonGroup group = new ButtonGroup();
         group.add(jrbUpdate);
         group.add(jrbInsert);
         group.add(jrbDelete);
         
         //add(group);
         jpRadio.add(jrbUpdate);
         jpRadio.add(jrbInsert);
         jpRadio.add(jrbDelete);
         
         add(jpRadio,BorderLayout.NORTH);
      
      JPanel jpData = new JPanel(new GridBagLayout());
         JLabel jlTitle = new JLabel("Title");
         c.fill = GridBagConstraints.HORIZONTAL;
         c.anchor = GridBagConstraints.WEST;
         c.gridx = 0;
         c.gridy = 0;
         jpData.add(jlTitle, c);

         JTextField jtfTitle = new JTextField(30);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.anchor = GridBagConstraints.WEST;
         c.gridx = 1;
         c.gridy = 0;
         jpData.add(jtfTitle,c);
         
         JLabel jlCitation = new JLabel("Citation");
         c.fill = GridBagConstraints.HORIZONTAL;
         c.anchor = GridBagConstraints.EAST;
         c.gridx = 0;
         c.gridy = 1;
         jpData.add(jlCitation,c);
         
         JTextField jtfCitation = new JTextField(30);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.anchor = GridBagConstraints.EAST;
         c.gridx = 1;
         c.gridy = 1;
         jpData.add(jtfCitation,c);
         
         JTextArea jtaAbstract = new JTextArea(50,50);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.gridx = 0;
         c.gridy = 2;
         jpData.add(jtaAbstract,c);
         
      add(jpData,BorderLayout.CENTER);
      
      JButton jbEnter = new JButton("Enter");
      add(jbEnter,BorderLayout.SOUTH);
   }//end of constructor
   
   //for the insert and update buttons
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
    public void createObject(){
    
    }
}