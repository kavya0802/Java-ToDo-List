import javax.swing.*;
import java.awt.*;

public class ToDoListGUI extends JFrame {

    private JTextField taskField;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public ToDoListGUI() {
        setTitle("To-Do List Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JButton completeButton = new JButton("Mark Completed");
        JButton deleteButton = new JButton("Delete Task");

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(completeButton);
        bottomPanel.add(deleteButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);

        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        completeButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                String task = listModel.get(index);
                if (!task.startsWith("✔ ")) {
                    listModel.set(index, "✔ " + task);
                }
            }
        });

        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListGUI::new);
    }
}
