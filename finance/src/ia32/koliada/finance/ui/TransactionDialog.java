package ia32.koliada.finance.ui;

import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.service.FinanceService;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class TransactionDialog extends JDialog {
    private FinanceService service;
    private MainWindow parent;

    private JComboBox<Account> accountCombo;
    private JTextField amountField;
    private JTextField descField;

    public TransactionDialog(MainWindow parent, FinanceService service) {
        super(parent, "Нова операція", true);
        this.parent = parent;
        this.service = service;

        setSize(400, 350);
        setLayout(new GridLayout(6, 1, 10, 10));

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Рахунок:"));
        accountCombo = new JComboBox<>();
        // Завантажуємо рахунки в комбобокс
        for(Account acc : service.getAllAccounts()) {
            accountCombo.addItem(acc);
        }
        p1.add(accountCombo);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Сума (+/-):"));
        amountField = new JTextField(15);
        amountField.setText("-100"); // Дефолтне значення
        p2.add(amountField);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("Опис:"));
        descField = new JTextField(15);
        p3.add(descField);

        JButton btnSave = new JButton("Зберегти");

        add(new JLabel(" Введіть деталі операції:", SwingConstants.CENTER));
        add(p1);
        add(p2);
        add(p3);
        add(new JLabel("")); // Відступ
        add(btnSave);

        btnSave.addActionListener(e -> {
            try {
                Account selectedAcc = (Account) accountCombo.getSelectedItem();
                BigDecimal amount = new BigDecimal(amountField.getText());
                String desc = descField.getText();

                service.addTransaction(selectedAcc.getId(), 1L, amount, desc);

                JOptionPane.showMessageDialog(this, "Успішно збережено!");

                parent.refreshData();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Помилка: " + ex.getMessage());
            }
        });

        setLocationRelativeTo(parent);
    }
}