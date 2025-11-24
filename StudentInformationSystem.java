import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentInformationSystem extends JFrame implements ActionListener {

    // Personal Information
    JTextField fullNameField, ageField, dobField, addressField, emailField, contactField;
    JComboBox<String> genderBox;

    // Academic Information
    JTextField studentNumberField, enrollmentDateField, sectionField;
    JComboBox<String> schoolYearBox, statusBox;

    // Emergency Contact
    JTextField guardianNameField, relationshipField, guardianContactField;

    // Buttons and Output
    JButton deleteButton, saveButton, confirmButton;
    JTextArea outputArea;
    
    // DATABASE CREDENTIALS
    private final String DB_URL = ""; //JDBC LOCAL HOST
    private final String DB_USER = ""; //USERNAME
    private final String DB_PASSWORD = ""; //PASSWORD

    public StudentInformationSystem() {
        setTitle("STUDENT INFORMATION SYSTEM");
        setSize(750, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // SCROLLABLE MAIN PANEL
        JPanel mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(780, 2000));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(scrollPane);

        // FIXED DIMENSIONS
        int labelWidth = 200; // FIXED WIDTH for JLabels
        int fieldWidth = 250; // FIXED WIDTH for JTextfields
        int height = 25; // FIXED HEIGHT for JTextfields
        int labelX = 50; // FIXED X position for JLabels

        // PERSONAL INFORMATION
        JLabel personalInfo = new JLabel("Personal Information");
        personalInfo.setFont(new Font("Arial", Font.BOLD, 19));
        personalInfo.setBounds(50, 40, 300, 30);
        mainPanel.add(personalInfo);

        // Personal Information - Full Name 
        JLabel fullNameLabel = new JLabel("Full Name (First Name, Middle Initial, Last Name):");
        fullNameLabel.setBounds(labelX, 80, 300, height);
        mainPanel.add(fullNameLabel);
        fullNameField = new JTextField();
        fullNameField.setBounds(335, 80, 350, height);
        mainPanel.add(fullNameField);

        // Personal Information - Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(labelX, 120, labelWidth, height);
        mainPanel.add(ageLabel);
        ageField = new JTextField();
        ageField.setBounds(85, 120, 60, height);
        mainPanel.add(ageField);

        // Personal Information - Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100 + 80, 120, 80, height);
        mainPanel.add(genderLabel);
        genderBox = new JComboBox<>(new String[]{"Female", "Male"});
        genderBox.setBounds(90 + 150, 120, 100, height);
        mainPanel.add(genderBox);

        // Personal Information - Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth (Month, Date, Year):");
        dobLabel.setBounds(labelX, 160, labelWidth + 100, height);
        mainPanel.add(dobLabel);
        dobField = new JTextField();
        dobField.setBounds(245, 160, fieldWidth, height);
        mainPanel.add(dobField);

        // Personal Information - Email Address
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(labelX, 200, labelWidth, height);
        mainPanel.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(140, 200, fieldWidth, height);
        mainPanel.add(emailField);

        // Personal Information - Home Address
        JLabel addressLabel = new JLabel("Home Address:");
        addressLabel.setBounds(labelX, 240, labelWidth, height);
        mainPanel.add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(145, 240, fieldWidth, height);
        mainPanel.add(addressField);

        // Personal Information - Contact Number
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(labelX, 280, labelWidth, height);
        mainPanel.add(contactLabel);
        contactField = new JTextField();
        contactField.setBounds(155, 280, fieldWidth, height);
        mainPanel.add(contactField);

        // ACADEMIC INFORMATION
        JLabel academicInfo = new JLabel("Academic Information");
        academicInfo.setFont(new Font("Arial", Font.BOLD, 19));
        academicInfo.setBounds(50, 330, 300, 30);
        mainPanel.add(academicInfo);

        // Academic Information - Student Number
        JLabel studentNumLabel = new JLabel("Student Number:");
        studentNumLabel.setBounds(labelX, 370, labelWidth, height);
        mainPanel.add(studentNumLabel);
        studentNumberField = new JTextField();
        studentNumberField.setBounds(155, 370, fieldWidth, height);
        mainPanel.add(studentNumberField);

        // Academic Information - Enrollment Date
        JLabel enrollmentLabel = new JLabel("Enrollment Date (Month, Date, Year):");
        enrollmentLabel.setBounds(labelX, 410, labelWidth + 100, height);
        mainPanel.add(enrollmentLabel);
        enrollmentDateField = new JTextField();
        enrollmentDateField.setBounds(270, 410, fieldWidth, height);
        mainPanel.add(enrollmentDateField);

        // Academic Information - Section, School Year, Status
        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(labelX, 450, labelWidth, height);
        mainPanel.add(sectionLabel);
        sectionField = new JTextField();
        sectionField.setBounds(105, 450, 100, height);
        mainPanel.add(sectionField);

        // Academic Information - School Year
        JLabel schoolYearLabel = new JLabel("School Year:");
        schoolYearLabel.setBounds(130 + 120, 450, 100, height);
        mainPanel.add(schoolYearLabel);
        schoolYearBox = new JComboBox<>(new String[]{"2020-2021", "2021-2022", "2023-2024", "2025-2026"});
        schoolYearBox.setBounds(120 + 210, 450, 120, height);
        mainPanel.add(schoolYearBox);

        // Academic Information - Status
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(labelX, 490, labelWidth, height);
        mainPanel.add(statusLabel);
        statusBox = new JComboBox<>(new String[]{"Enrolled", "Dropped", "Transferred"});
        statusBox.setBounds(100, 490, 150, height);
        mainPanel.add(statusBox);

        // EMERGENCY CONTACT INFORMATION
        JLabel emergencyInfo = new JLabel("Emergency Contact Information");
        emergencyInfo.setFont(new Font("Arial", Font.BOLD, 19));
        emergencyInfo.setBounds(50, 540, 350, 30);
        mainPanel.add(emergencyInfo);

        // Emergency Contact - Guardian Name
        JLabel guardianNameLabel = new JLabel("Guardian Name:");
        guardianNameLabel.setBounds(labelX, 580, labelWidth, height);
        mainPanel.add(guardianNameLabel);
        guardianNameField = new JTextField();
        guardianNameField.setBounds(150, 580, fieldWidth, height);
        mainPanel.add(guardianNameField);

        // Emergency Contact - Relationship
        JLabel relationshipLabel = new JLabel("Relationship:");
        relationshipLabel.setBounds(labelX, 620, labelWidth, height);
        mainPanel.add(relationshipLabel);
        relationshipField = new JTextField();
        relationshipField.setBounds(135, 620, fieldWidth, height);
        mainPanel.add(relationshipField);

        // Emergency Contact - Guardian Contact Number
        JLabel guardianContactLabel = new JLabel("Guardian Contact Number:");
        guardianContactLabel.setBounds(labelX, 660, labelWidth + 50, height);
        mainPanel.add(guardianContactLabel);
        guardianContactField = new JTextField();
        guardianContactField.setBounds(210, 660, fieldWidth, height);
        mainPanel.add(guardianContactField);

        // NOTE JLabel
        JLabel note = new JLabel("Note: Please save all entered data before clicking Confirm.");
        note.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        note.setForeground(Color.RED);
        note.setBounds(50, 700, 500, 20);
        mainPanel.add(note);

        // REVIEW INFORMATION TEXT AREA
        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBounds(50, 730, 660, 400);
        outputScroll.setBorder(BorderFactory.createTitledBorder("Review Information"));
        mainPanel.add(outputScroll);

        // DELETE BUTTON
        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(180, 1150, 100, 30);
        mainPanel.add(deleteButton);

        // SAVE BUTTON
        saveButton = new JButton("SAVE");
        saveButton.setBounds(320, 1150, 100, 30);
        mainPanel.add(saveButton);

        // CONFIRM BUTTON
        confirmButton = new JButton("CONFIRM");
        confirmButton.setBounds(460, 1150, 100, 30);
        confirmButton.setBackground(new Color(51, 153, 255)); 
        confirmButton.setForeground(Color.WHITE);
        mainPanel.add(confirmButton);

        // ACTION LISTENERS FOR BUTTONS
        deleteButton.addActionListener(this);
        saveButton.addActionListener(this);
        confirmButton.addActionListener(this);

    }
    // METHOD FOR BUTTON ACTIONS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) clearFields();
        else if (e.getSource() == saveButton) showData();
        else if (e.getSource() == confirmButton)
            JOptionPane.showMessageDialog(this, "Data confirmed successfully.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

    }
    // METHOD FOR DELETE BUTTON
    private void clearFields() {
        JTextField[] fields = {
            fullNameField, ageField, dobField, addressField, emailField, contactField,
            studentNumberField, enrollmentDateField, sectionField,
            guardianNameField, relationshipField, guardianContactField
        };
        for (JTextField f : fields) f.setText("");
        genderBox.setSelectedIndex(0);
        schoolYearBox.setSelectedIndex(0);
        statusBox.setSelectedIndex(0);
        outputArea.setText("");
    }
    // METHOD FOR SAVE BUTTON
    private void showData() {
        String data = String.format(
            "-- PERSONAL INFORMATION\nFull Name: %s\nAge: %s\nGender: %s\nDate of Birth: %s\nEmail: %s\nHome Address: %s\nContact Number: %s\n\n" +
            "-- ACADEMIC INFORMATION \nStudent Number: %s\nEnrollment Date: %s\nSection: %s\nSchool Year: %s\nStatus: %s\n\n" +
            "-- EMERGENCY CONTACT INFORMATION\nGuardian Name: %s\nRelationship: %s\nGuardian Contact: %s",
            fullNameField.getText(),
            ageField.getText(),
            genderBox.getSelectedItem(),
            dobField.getText(),
            emailField.getText(),
            addressField.getText(),
            contactField.getText(),
            studentNumberField.getText(),
            enrollmentDateField.getText(),
            sectionField.getText(),
            schoolYearBox.getSelectedItem(),
            statusBox.getSelectedItem(),
            guardianNameField.getText(),
            relationshipField.getText(),
            guardianContactField.getText()
        );
            outputArea.setText(data);
    }
 private void saveToDatabase() {
    String sql = "INSERT INTO students (full_name, age, gender, dob, email, address, contact, " +
                 "student_number, enrollment_date, section, school_year, status, guardian_name, relationship, guardian_contact) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, fullNameField.getText());
        stmt.setInt(2, Integer.parseInt(ageField.getText()));
        stmt.setString(3, (String) genderBox.getSelectedItem());
        stmt.setString(4, dobField.getText());
        stmt.setString(5, emailField.getText());
        stmt.setString(6, addressField.getText());
        stmt.setString(7, contactField.getText());
        stmt.setString(8, studentNumberField.getText());
        stmt.setString(9, enrollmentDateField.getText());
        stmt.setString(10, sectionField.getText());
        stmt.setString(11, (String) schoolYearBox.getSelectedItem());
        stmt.setString(12, (String) statusBox.getSelectedItem());
        stmt.setString(13, guardianNameField.getText());
        stmt.setString(14, relationshipField.getText());
        stmt.setString(15, guardianContactField.getText());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved to database successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
    // MAIN METHOD
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentInformationSystem().setVisible(true));
    }
}


