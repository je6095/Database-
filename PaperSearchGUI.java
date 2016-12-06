
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PaperSearchGUI extends JFrame implements ActionListener {
    
    private static final String DB_NAME = "FacResearchDB";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    
    private Connection dbConnection;
    private JTextField keywordField = new JTextField(20);
    private JTable resultsTable = new JTable(new DefaultTableModel(new Object[]{"Paper Title"}, 0));

    // Initialize the window layout and database connection
    public PaperSearchGUI() {
        setTitle("Paper Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Keyword: "));
        searchPanel.add(keywordField);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);
        
        add(BorderLayout.NORTH, searchPanel);
        add(BorderLayout.CENTER, new JScrollPane(resultsTable));

        // Connect DB
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(0);
        }
    }

    // Handle searching
    @Override
    public void actionPerformed(ActionEvent e) {
        String keyword = keywordField.getText().trim();
        
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a keyword.");
            return;
        }

        // Query the database
        try {
            PreparedStatement statement = dbConnection.prepareStatement("SELECT papers.title FROM papers, paper_keywords WHERE papers.id = paper_keywords.id AND paper_keywords.keyword = ?");
            statement.setString(1, keyword);

            // Clear the table
            while (((DefaultTableModel) resultsTable.getModel()).getRowCount() > 0) {
                ((DefaultTableModel) resultsTable.getModel()).removeRow(0);
            }

            // Display result
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                String title = rs.getString(1);
                ((DefaultTableModel) resultsTable.getModel()).addRow(new Object[]{title});
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    // Entry point of the program to start the GUI
    public static void main(String[] args) {
        new PaperSearchGUI().setVisible(true);
    }
}
