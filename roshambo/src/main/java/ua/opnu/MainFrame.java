package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JLabel statusLabel, playerChoiceLabel, computerChoiceLabel;
    private Random random = new Random();

    public MainFrame() {
        super("Гра: Камінь-Ножиці-Папір");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        // Панель для кнопок
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        rockButton = new JButton("Камінь");
        paperButton = new JButton("Папір");
        scissorsButton = new JButton("Ножиці");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        // Панель для інформації
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        playerChoiceLabel = new JLabel("Ваш вибір: ");
        computerChoiceLabel = new JLabel("Вибір комп'ютера: ");
        statusLabel = new JLabel("Результат: Зробіть свій хід!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 16));

        infoPanel.add(playerChoiceLabel);
        infoPanel.add(computerChoiceLabel);

        add(buttonPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    // ЗАВДАННЯ: Дописати логіку цього методу
    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape playerShape = null;
        Object source = e.getSource();

        // 1. Створюємо об'єкт фігури гравця в залежності від натиснутої кнопки
        if (source == rockButton) {
            playerShape = new Rock();
            playerChoiceLabel.setText("Ваш вибір: Камінь");
        } else if (source == paperButton) {
            playerShape = new Paper();
            playerChoiceLabel.setText("Ваш вибір: Папір");
        } else if (source == scissorsButton) {
            playerShape = new Scissors();
            playerChoiceLabel.setText("Ваш вибір: Ножиці");
        }

        // 2. Генеруємо фігуру для комп'ютера
        GameShape computerShape = generateShape();
        if (computerShape instanceof Rock) {
            computerChoiceLabel.setText("Вибір комп'ютера: Камінь");
        } else if (computerShape instanceof Paper) {
            computerChoiceLabel.setText("Вибір комп'ютера: Папір");
        } else {
            computerChoiceLabel.setText("Вибір комп'ютера: Ножиці");
        }

        // 3. Визначаємо переможця
        int result = checkWinner(playerShape, computerShape);

        // 4. Оновлюємо статус гри
        if (result == 1) {
            statusLabel.setText("Результат: Ви виграли!");
        } else if (result == -1) {
            statusLabel.setText("Результат: Ви програли.");
        } else {
            statusLabel.setText("Результат: Нічия!");
        }
    }

    // ЗАВДАННЯ: Написати логіку методу, який повертає одну з трьох випадкових фігур
    private GameShape generateShape() {
        int choice = random.nextInt(3); // 0, 1 або 2
        switch (choice) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default: // case 2
                return new Scissors();
        }
    }

    // ЗАВДАННЯ: Реалізувати метод, який визначає переможця
    private int checkWinner(GameShape player, GameShape computer) {
        // Використовуємо instanceof для визначення фактичного типу об'єкта
        if (player instanceof Rock) {
            if (computer instanceof Scissors) return 1;  // Камінь б'є ножиці
            if (computer instanceof Paper) return -1; // Папір накриває камінь
        } else if (player instanceof Paper) {
            if (computer instanceof Rock) return 1;      // Папір накриває камінь
            if (computer instanceof Scissors) return -1; // Ножиці ріжуть папір
        } else if (player instanceof Scissors) {
            if (computer instanceof Paper) return 1;    // Ножиці ріжуть папір
            if (computer instanceof Rock) return -1;      // Камінь б'є ножиці
        }
        // Якщо жодна з умов не спрацювала, значить фігури однакові
        return 0; // Нічия
    }
}
