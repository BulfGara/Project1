package co.edu.politecnicointernacional.Prografinal.vista;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class Vist extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_4;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vist frame = new Vist();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Vist() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 644, 475);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 12, 609, 410);
        contentPane.add(tabbedPane);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Crear", null, panel, null);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("ENVIAR");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(495, 337, 99, 34);
        panel.add(btnNewButton);
        
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    java.sql.Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3308/prografinal",
                            "root", "polint2023");
                    java.sql.Statement comando = conexion.createStatement();
                    String nombre = textField.getText();
                    String apellido = textField_1.getText();
                    String correo = textField_2.getText();
                    char[] passwordChars = passwordField.getPassword();
                    String contrasena = new String(passwordChars);
                    System.out.println("el nombre del empleado es " + nombre + apellido + " y el correo es " + correo);

                    comando.executeUpdate(
                            "insert into crear(nombre,apellido,correo,contrasena) values ('" + nombre + "','"
                                    + apellido + "','" + correo + "','" + contrasena + "')");
                } catch (SQLException ex) {
                    System.out.println("error en SQL: " + ex);
                }
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                passwordField.setText("");
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("Apellidos");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(88, 93, 89, 28);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Correo");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(88, 142, 67, 26);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Contraseña");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setBounds(88, 179, 108, 40);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel = new JLabel("Nombres");
        lblNewLabel.setBounds(88, 48, 77, 28);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        textField = new JTextField();
        textField.setBounds(198, 54, 165, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(198, 99, 164, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(198, 147, 165, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(198, 191, 165, 20);
        panel.add(passwordField);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Consultar", null, panel_1, null);
        panel_1.setLayout(null);
        
        JButton btnNewButton_4 = new JButton("ENVIAR");
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4.setBounds(495, 337, 99, 34);
        panel_1.add(btnNewButton_4);
        
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblId.setBounds(95, 92, 77, 28);
        panel_1.add(lblId);
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCorreo.setBounds(95, 131, 77, 28);}
}