import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FacultyScreen extends JPanel implements ActionListener{ //Faculty Admin GUI                         
   
   private JRadioButton jrbUpdate;
   private JRadioButton jrbInsert;
   private JRadioButton jrbDelete;
   private ButtonGroup group;
   private ResearchGUI reGUI;
   private JTable resultsTable = new JTable(new DefaultTableModel(new Object[]{"Paper Title","Abstract","Citation"}, 0));
   JButton jbAll;
   JButton jbEnter;
   
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
      
      add(BorderLayout.CENTER, new JScrollPane(resultsTable));
      
      JPanel jpButtons = new JPanel();
         JButton jbEnter = new JButton("Enter");
         jbEnter.addActionListener(this);
         jpButtons.add(jbEnter);
         
         JButton jbAll = new JButton("View All Papers");
         jbAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               reGUI.swapView("Search for papers");
            }
         });
         jpButtons.add(jbAll);
         
      add(jpButtons,BorderLayout.SOUTH);
   }//end of constructor
   
   //for the insert and update buttons
    public void actionPerformed(ActionEvent e) {
      System.out.println("they hit enter");
    }
   
   public void fillTable(){
      ConnectDB db = new ConnectDB();
	   BusinessLayer bl = reGUI.getFaculty();
	   try 
	   {
		   if(db.connect())
		   {
            System.out.println("Connected to Database");
            
            int id = reGUI.getFaculty().getID();

            ArrayList<Object[]> papers = bl.getFacultyPapers(id); // returns arraylist of objects
            for(int i=0;i<papers.size();i++){
               ((DefaultTableModel) resultsTable.getModel()).addRow(papers.get(i));
            }
         }
       }catch(SQLException se){
         se.printStackTrace();
       }catch(ClassNotFoundException ce){
         ce.printStackTrace();
       }
   }
}