import java.util.*;
import javax.swing.*;
import java.awt.*;

public class FacultyScreen extends JPanel{ //Faculty Admin GUI
   public FacultyScreen(){
      // setLayout(new GridBagLayout());
//       GridBagConstraints c = new GridBagConstraints();
      
      JRadioButton jrbUpdate = new JRadioButton("Update");
      jrbUpdate.setActionCommand("update");
      jrbUpdate.setSelected(true);

      JRadioButton jrbInsert = new JRadioButton("Insert");
      jrbInsert.setActionCommand("insert");
      
      JRadioButton jrbDelete = new JRadioButton("Delete");
      jrbDelete.setActionCommand("delete");
      
      ButtonGroup group = new ButtonGroup();
      group.add(jrbUpdate);
      group.add(jrbInsert);
      group.add(jrbDelete);
      
      //add(group);
      add(jrbUpdate);
      add(jrbInsert);
      add(jrbDelete);
      
      JButton jbEnter = new JButton("Enter");
      add(jbEnter);
   }
}