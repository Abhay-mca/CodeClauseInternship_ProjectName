import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MainUI {
    private static EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Management");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextArea output = new JTextArea();
        JButton addBtn = new JButton("Add Employee");
        JButton showBtn = new JButton("Show All");

        addBtn.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Enter Name:");
                String dept = JOptionPane.showInputDialog("Enter Department:");
                double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));
                int id = new Random().nextInt(9999);
                manager.addEmployee(new Employee(id, name, dept, salary));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        showBtn.addActionListener(e -> {
            output.setText("");
            for (Employee emp : manager.getAllEmployees()) {
                output.append(emp.toString() + "\n");
            }
        });

        JPanel panel = new JPanel();
        panel.add(addBtn);
        panel.add(showBtn);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
