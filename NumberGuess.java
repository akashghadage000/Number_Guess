import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuess extends JFrame {
    int targetNumber;
    JTextField t1;
    JLabel L1;

    public NumberGuess() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);

        targetNumber = (int) (Math.random() * 100) + 1;

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        L1 = new JLabel("Guess a number between 1 and 100:");
        panel.add(L1);

        t1 = new JTextField(10);
        panel.add(t1);

        JButton B1 = new JButton("Guess");
        B1.addActionListener(new GuessButtonListener());
        panel.add(B1);

        add(panel);
        setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                int guess = Integer.parseInt(t1.getText());
                if (guess < targetNumber) {
                    L1.setText("Too low! Guess a higher number:");
                } else if (guess > targetNumber) {
                    L1.setText("Too high! Guess a lower number:");
                } else {
                    L1.setText("Congratulations! You guessed the correct number.");
                    t1.setEditable(false);
                    t1.setEnabled(false);
                }
            } catch (NumberFormatException e) {
                L1.setText("Invalid input! Please enter a valid number.");
            }
            t1.setText("");
            t1.requestFocus();
        }
    }

    public static void main(String[] args) {
        NumberGuess ob=new NumberGuess();
    }
}

