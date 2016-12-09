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
   private JButton jbAll;
   private JButton jbEnter;
   
   public FacultyScreen(ResearchGUI gui){
    this.reGUI = gui;
      setLayout(new BorderLayout());
      GridBagConstraints c = new GridBagConstraints();
      JPanel jpRadio = new JPanel();
         jrbUpdate = new JRadioButton("Update");
         jrbUpdate.setActionCommand("Update");
         jrbUpdate.setSelected(true);
   
         jrbInsert = new JRadioButton("Insert");
         jrbInsert.setActionCommand("Insert");
         
         jrbDelete = new JRadioButton("Delete");
         jrbDelete.setActionCommand("Delete");
         
         group = new ButtonGroup();
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
      //get the selectied radio button
      String actionSelection = group.getSelection().getActionCommand();
      int rowIndex = resultsTable.getSelectedRow();
      if(rowIndex == -1){
         JOptionPane.showMessageDialog(this, "Please select a row.");
      }else{
         if(actionSelection == "Update"){
            System.out.println("Update");
         }else if(actionSelection == "Insert"){
            System.out.println("Insert");
         }else if(actionSelection == "Delete"){
            System.out.println("Delete");
         }
      }
    }
   
   public void fillTable(){
		   try 
		   {
            int id = reGUI.getFaculty().getID();
            ArrayList<Object[]> papers = reGUI.getFaculty().getFacultyPapers(id); // returns arraylist of objects
            for(int i=0;i<papers.size();i++){
               ((DefaultTableModel) resultsTable.getModel()).addRow(papers.get(i));
            }
          }catch(Exception e){
            e.printStackTrace();
          }
   }//end fillTable
 }