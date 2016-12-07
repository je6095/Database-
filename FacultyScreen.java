import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FacultyScreen extends JPanel implements ActionListener{ //Faculty Admin GUI
   
   String[] columnNames = {"Title",
                        "Abstract",
                        "Citation"
                                 };
   Object[][] tableData = null;                           
   
   JRadioButton jrbUpdate;
   JRadioButton jrbInsert;
   JRadioButton jrbDelete;
   ButtonGroup group;
   private ResearchGUI reGUI;
   
   public FacultyScreen(ResearchGUI gui){
    this.reGUI = gui;
      setLayout(new BorderLayout());
//       GridBagConstraints c = new GridBagConstraints();
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
      
      //JTable with the data
      
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