package ia32.koliada.finance.ui;

import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.service.FinanceService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private FinanceService service;
    private JTable accountsTable;
    private JTable transactionsTable;
    private DefaultTableModel accountsModel;
    private DefaultTableModel transactionsModel;

    public MainWindow(FinanceService service) {
        this.service = service;

        setTitle("Особиста бухгалтерія");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Мої Рахунки"));

        accountsModel = new DefaultTableModel(new String[]{"ID", "Назва", "Баланс (грн)"}, 0);
        accountsTable = new JTable(accountsModel);
        topPanel.add(new JScrollPane(accountsTable), BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Історія Транзакцій"));

        transactionsModel = new DefaultTableModel(new String[]{"Сума", "Опис", "Дата"}, 0);
        transactionsTable = new JTable(transactionsModel);
        centerPanel.add(new JScrollPane(transactionsTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdd = new JButton("Додати операцію");
        JButton btnRefresh = new JButton("Оновити дані");

        btnAdd.addActionListener(e -> {
            TransactionDialog dialog = new TransactionDialog(this, service);
            dialog.setVisible(true);
        });

        btnRefresh.addActionListener(e -> refreshData());

        bottomPanel.add(btnRefresh);
        bottomPanel.add(btnAdd);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, centerPanel);
        splitPane.setDividerLocation(200);

        add(splitPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshData();
    }

    public void refreshData() {
        accountsModel.setRowCount(0);
        transactionsModel.setRowCount(0);

        List<Account> accounts = service.getAllAccounts();
        for (Account acc : accounts) {
            accountsModel.addRow(new Object[]{acc.getId(), acc.getName(), acc.getBalance()});
        }

        List<Transaction> transactions = service.getAllTransactions();
        for (Transaction tx : transactions) {
            transactionsModel.addRow(new Object[]{tx.getAmount(), tx.getDescription(), tx.getFormattedDate()});
        }
    }
}