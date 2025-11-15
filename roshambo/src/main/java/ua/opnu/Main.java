package ua.opnu;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Запускаємо GUI в безпечному для потоків режимі
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
