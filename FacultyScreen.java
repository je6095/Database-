import java.util.*;
import javax.swing.*;
import java.awt.*;

public class FacultyScreen extends JPanel{ //Faculty Admin GUI
   
   String[] columnNames = {"Title",
                        "Abstract",
                        "Citation"
                                 };
   Object[][] tableData = null;                           
   
   JRadioButton jrbUpdate;
   JRadioButton jrbInsert;
   JRadioButton jrbDelete;
   ButtonGroup group;
   
   public FacultyScreen(String email){
      setLayout(new BorderLayout());
//       GridBagConstraints c = new GridBagConstraints();
      
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
      add(jrbUpdate,BorderLayout.NORTH);
      add(jrbInsert,BorderLayout.NORTH);
      add(jrbDelete,BorderLayout.NORTH);
      
      //JTable with the data
      
      JButton jbEnter = new JButton("Enter");
      add(jbEnter,BorderLayout.SOUTH);
   }//end of constructor
   
   //for the insert and update buttons
    @Override
    public void actionPerformed(ActionEvent e) {
      if
    }
    
    public void createObject(){
    
    }
}