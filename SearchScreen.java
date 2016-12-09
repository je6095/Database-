import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class SearchScreen extends JPanel implements ActionListener{// Search GUI
   
   private ResearchGUI reGUI;
   private JTextField keywordField = new JTextField(20);
   private JTable resultsTable = new JTable(new DefaultTableModel(new Object[]{"Paper Title","Abstract","Citation"}, 0));
   private JButton searchButton;
   private JButton refreshButton;
   
   public SearchScreen(ResearchGUI gui){
    this.reGUI = gui;
    setLayout(new BorderLayout());
    
    JPanel searchPanel = new JPanel(new FlowLayout());
    searchPanel.add(new JLabel("Keyword: "));
    searchPanel.add(keywordField);
    
    searchButton = new JButton("Search");
    searchButton.addActionListener(this);
    searchPanel.add(searchButton);
    
    refreshButton = new JButton("Refresh");
    refreshButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
         keywordField.setText("");
         clearTable();
         fillTable();
      
      }
    });
    searchPanel.add(refreshButton);
    
    add(BorderLayout.NORTH, searchPanel);
    add(BorderLayout.CENTER, new JScrollPane(resultsTable));
    
    fillTable();
    //resultsTable.setEnabled(false);  
   }
   
   public void actionPerformed(ActionEvent e) {
      ConnectDB db = new ConnectDB();
	   BusinessLayer bl = new BusinessLayer(db);
	   try 
	   {
		   if(db.connect())
		   {
            String keyword = keywordField.getText().trim();
 
             if (keyword.isEmpty()) {
                 JOptionPane.showMessageDialog(this, "Enter a keyword.");
                 return;
             }
         
            //clear the table
            clearTable();

            ((DefaultTableModel) resultsTable.getModel()).addRow(bl.keywordSearch(keyword));
         }
       }catch(SQLException se){
         se.printStackTrace();
       }catch(ClassNotFoundException ce){
         ce.printStackTrace();
       }
         
   }//end actionPRepared
   
   public void fillTable(){
      ConnectDB db = new ConnectDB();
		   BusinessLayer bl = new BusinessLayer(db);
		   try 
		   {
            
			   if(db.connect())
			   {
               reGUI.setDB(db);
               System.out.println("Connected to Database");
            
               //clear the table
               clearTable();
               ArrayList<Object[]> papers = bl.getAllPapers(); // returns arraylist of objects
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
   
   public void clearTable(){
      while (((DefaultTableModel) resultsTable.getModel()).getRowCount() > 0) {
         ((DefaultTableModel) resultsTable.getModel()).removeRow(0);
      }
   }
}