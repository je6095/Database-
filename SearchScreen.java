import java.util.*;
import javax.swing.*;
import java.awt.*;

public class SearchScreen extends JPanel{// Search GUI
   public SearchScreen(){
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      JLabel jlSearch = new JLabel("<html><h1>Search</h1></html>");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 0;
      add(jlSearch, c);
      
      JTextField jtfSearch = new JTextField(30);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 1;
      add(jtfSearch, c);
      
      JButton jbSearch = new JButton("Enter");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 1;
      add(jbSearch, c);
      
      JPanel jpResults = new JPanel();//this panel shows the results
      jpResults.setPreferredSize(new Dimension(800, 800));
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 2;
      add(jpResults, c);
      
   }
}