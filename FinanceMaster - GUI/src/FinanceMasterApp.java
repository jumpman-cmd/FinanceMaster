import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FinanceMasterApp
{
    private JFrame frame;
    private JPanel panel;
    private CardLayout cardLayout;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField countryField;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> workingComboBox;
    private JTextField salaryField;
    private JComboBox<String> kidsComboBox;
    private JComboBox<String> funeralCoverComboBox;
    private JComboBox<String> carComboBox;
    private JComboBox<String> medicalAidComboBox;
    private JTextField funeralCoverField;
    private JTextField carInstallmentField;
    private JTextField medicalAidField;
    private JTextField rentField;
    private JTextField internetField;

    private String[] greetings =
            {
            "Hello Mr/Ms %s, we're here to help you save your money. How much do you make each month?",
            "Welcome %s! Let's get started on managing your finances. How much do you make each month?",
            "Hi %s! Ready to take control of your finances? How much do you make each month?",
            "Greetings %s! We're excited to help you save more. How much do you make each month?",
            "Hello %s! Let's see how we can optimize your spending. How much do you make each month?"
    };

    private String[] motivationalPhrases =
            {
            "Press here to find healing",
            "You've finally found a big financial break",
            "Click to discover your financial potential",
            "Let's unveil your financial growth",
            "Unlock your financial wisdom"
    };

    public FinanceMasterApp()
    {
        frame = new JFrame("FinanceMaster");
        panel = new JPanel();
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);

        initialize();
    }

    private void initialize()
    {
        createUserInfoPage();
        createGreetingPage();
        createAdditionalInfoPage();
        createFuneralCoverPage();
        createCarInstallmentPage();
        createMedicalAidPage();
        createAdvicePage();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    private void createUserInfoPage()
    {
        JPanel userInfoPanel = new JPanel(new GridLayout(6, 2));
        userInfoPanel.setBackground(Color.RED);

        userInfoPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        userInfoPanel.add(nameField);

        userInfoPanel.add(new JLabel("Surname:"));
        surnameField = new JTextField();
        userInfoPanel.add(surnameField);

        userInfoPanel.add(new JLabel("Country:"));
        countryField = new JTextField();
        userInfoPanel.add(countryField);

        userInfoPanel.add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        userInfoPanel.add(genderComboBox);

        userInfoPanel.add(new JLabel("Are you working?"));
        workingComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        userInfoPanel.add(workingComboBox);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> cardLayout.show(panel, "GreetingPage"));
        userInfoPanel.add(nextButton);

        panel.add(userInfoPanel, "UserInfoPage");
    }

    private void createGreetingPage()
    {
        JPanel greetingPanel = new JPanel(new BorderLayout());
        greetingPanel.setBackground(Color.RED);

        JLabel greetingLabel = new JLabel();
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greetingLabel.setForeground(Color.WHITE);
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        greetingPanel.add(greetingLabel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e ->
        {
            String name = nameField.getText().toUpperCase();
            Random random = new Random();
            String greeting = greetings[random.nextInt(greetings.length)];
            greetingLabel.setText(String.format(greeting, name));
            cardLayout.show(panel, "AdditionalInfoPage");
        });
        greetingPanel.add(nextButton, BorderLayout.SOUTH);

        panel.add(greetingPanel, "GreetingPage");
    }

    private void createAdditionalInfoPage()
    {
        JPanel additionalInfoPanel = new JPanel(new GridLayout(9, 2));
        additionalInfoPanel.setBackground(Color.RED);

        additionalInfoPanel.add(new JLabel("Monthly Income (numbers only):"));
        salaryField = new JTextField();
        additionalInfoPanel.add(salaryField);

        additionalInfoPanel.add(new JLabel("Do you have kids?"));
        kidsComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        additionalInfoPanel.add(kidsComboBox);

        additionalInfoPanel.add(new JLabel("Do you have a funeral cover?"));
        funeralCoverComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        additionalInfoPanel.add(funeralCoverComboBox);

        additionalInfoPanel.add(new JLabel("Do you have a car?"));
        carComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        additionalInfoPanel.add(carComboBox);

        additionalInfoPanel.add(new JLabel("Do you have medical aid?"));
        medicalAidComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        additionalInfoPanel.add(medicalAidComboBox);

        additionalInfoPanel.add(new JLabel("Rent:"));
        rentField = new JTextField();
        additionalInfoPanel.add(rentField);

        additionalInfoPanel.add(new JLabel("Internet:"));
        internetField = new JTextField();
        additionalInfoPanel.add(internetField);

        Random random = new Random();
        String motivationalPhrase = motivationalPhrases[random.nextInt(motivationalPhrases.length)];
        JButton nextButton = new JButton(motivationalPhrase);
        nextButton.addActionListener(e ->
        {
            if (funeralCoverComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "FuneralCoverPage");
            }

            else if (carComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "CarInstallmentPage");
            }

            else if (medicalAidComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "MedicalAidPage");
            }

            else
            {
                cardLayout.show(panel, "AdvicePage");
            }
        });
        additionalInfoPanel.add(nextButton);

        panel.add(additionalInfoPanel, "AdditionalInfoPage");
    }

    private void createFuneralCoverPage()
    {
        JPanel funeralCoverPanel = new JPanel(new GridLayout(2, 2));
        funeralCoverPanel.setBackground(Color.RED);

        funeralCoverPanel.add(new JLabel("Funeral Cover Amount (numbers only):"));
        funeralCoverField = new JTextField();
        funeralCoverPanel.add(funeralCoverField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e ->
        {
            if (carComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "CarInstallmentPage");
            }

            else if (medicalAidComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "MedicalAidPage");
            }

            else
            {
                cardLayout.show(panel, "AdvicePage");
            }
        });
        funeralCoverPanel.add(nextButton);

        panel.add(funeralCoverPanel, "FuneralCoverPage");
    }

    private void createCarInstallmentPage()
    {
        JPanel carInstallmentPanel = new JPanel(new GridLayout(2, 2));
        carInstallmentPanel.setBackground(Color.RED);

        carInstallmentPanel.add(new JLabel("Monthly Car Installment (numbers only):"));
        carInstallmentField = new JTextField();
        carInstallmentPanel.add(carInstallmentField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e ->
        {
            if (medicalAidComboBox.getSelectedItem().equals("Yes"))
            {
                cardLayout.show(panel, "MedicalAidPage");
            }

            else
            {
                cardLayout.show(panel, "AdvicePage");
            }
        });
        carInstallmentPanel.add(nextButton);

        panel.add(carInstallmentPanel, "CarInstallmentPage");
    }

    private void createMedicalAidPage()
    {
        JPanel medicalAidPanel = new JPanel(new GridLayout(2, 2));
        medicalAidPanel.setBackground(Color.RED);

        medicalAidPanel.add(new JLabel("Monthly Medical Aid (numbers only):"));
        medicalAidField = new JTextField();
        medicalAidPanel.add(medicalAidField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> cardLayout.show(panel, "AdvicePage"));
        medicalAidPanel.add(nextButton);

        panel.add(medicalAidPanel, "MedicalAidPage");
    }

    private void createAdvicePage()
    {
        JPanel advicePanel = new JPanel(new BorderLayout());
        advicePanel.setBackground(Color.RED);

        JTextPane adviceTextPane = new JTextPane();
        adviceTextPane.setEditable(false);
        adviceTextPane.setContentType("text/html");
        advicePanel.add(new JScrollPane(adviceTextPane), BorderLayout.CENTER);

        JButton calculateButton = new JButton("Just Click Here");
        calculateButton.addActionListener(e ->
        {
            try
            {
                String name = nameField.getText().toUpperCase();
                String surname = surnameField.getText().toUpperCase();
                String country = countryField.getText().toUpperCase();
                String gender = genderComboBox.getSelectedItem().toString().toUpperCase();
                double salary = parseDouble(salaryField.getText());
                boolean hasKids = kidsComboBox.getSelectedItem().equals("Yes");
                double funeralCover = parseDouble(funeralCoverField.getText());
                double carInstallment = parseDouble(carInstallmentField.getText());
                double medicalAid = parseDouble(medicalAidField.getText());
                double rent = parseDouble(rentField.getText());
                double internet = parseDouble(internetField.getText());

                double totalExpenses = funeralCover + carInstallment + medicalAid + rent + internet;
                double remainingIncome = salary - totalExpenses;

                double kidsExpense = hasKids ? remainingIncome * 0.20 : 0;
                remainingIncome -= kidsExpense;

                String currency = getCurrencySymbol(country);

                StringBuilder advice = new StringBuilder("<html><body>");
                advice.append("<h2>Hello ").append(name).append(" ").append(surname).append("</h2>");
                advice.append("<p><b>What good is first class if your people can't sit? </b> ").append("</p>");
                advice.append("<p><b>Everything can change, it all depends on what you do today. Make wiser decisions bruv! </b> ").append("</p>");
                advice.append("<p><b>Country:</b> ").append(country).append("</p>");
                advice.append("<p><b>Gender:</b> ").append(gender).append("</p>");
                advice.append("<p><b>Monthly Income:</b> ").append(currency).append(String.format("%.2f", salary)).append("</p>");
                advice.append("<p><b>Total Expenses:</b> ").append(currency).append(String.format("%.2f", totalExpenses)).append("</p>");
                advice.append("<p><b>Remaining Income:</b> ").append(currency).append(String.format("%.2f", remainingIncome)).append("</p>");
                advice.append("<h3>Advice:</h3>");
                if (hasKids)
                {
                    advice.append("<p><b>Kids Expense (please spoil your kid(s):</b> ").append(currency).append(String.format("%.2f", kidsExpense)).append("</p>");
                }
                advice.append("<p><b>===== ===== ===== ===== ===== ===== ===== ===== ===== ===== =====</b> ").append("</p>");
                advice.append("<p><b> ---- Spend the remaining money on the following ---- </b> ").append("</p>");
                advice.append("<p><b>==== ===== ===== ===== ===== ===== ===== ===== ===== ===== =====</b> ").append("</p>");
                advice.append("<p><b>30% for Food, Home Needs and Cosmetics:</b> ").append(currency).append(String.format("%.2f", remainingIncome * 0.30)).append("</p>");
                advice.append("<p><b>20% savefor Emergencies:</b> ").append(currency).append(String.format("%.2f", remainingIncome * 0.20)).append("</p>");
                advice.append("<p><b>30% for Fun:</b> ").append(currency).append(String.format("%.2f", remainingIncome * 0.30)).append("</p>");
                advice.append("</body></html>");

                adviceTextPane.setText(advice.toString());
            }

            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        advicePanel.add(calculateButton, BorderLayout.SOUTH);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        advicePanel.add(exitButton, BorderLayout.WEST);

        JButton playGameButton = new JButton("Play Tic-Tac-Toe");
        playGameButton.addActionListener(e -> new TicTacToeGame());
        advicePanel.add(playGameButton, BorderLayout.EAST);

        panel.add(advicePanel, "AdvicePage");
    }

    private double parseDouble(String text)
    {
        try
        {
            return Double.parseDouble(text);
        }

        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    private String getCurrencySymbol(String country)
    {
        switch (country.toUpperCase())
        {
            case "USA":
                return "$";
            case "UK":
                return "£";
            case "EUROPE":
                return "€";
            case "JAPAN":
                return "¥";
            case "SOUTH AFRICA":
                return "R";
            default:
                return "R";
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(FinanceMasterApp::new);
    }
}

class TicTacToeGame
{
    private JFrame frame;
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameWon;

    public TicTacToeGame()
    {
        frame = new JFrame("Tic-Tac-Toe");
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameWon = false;

        initialize();
    }

    private void initialize()
    {
        frame.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                frame.add(buttons[i][j]);
            }
        }

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener
    {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (buttons[row][col].getText().equals("") && !gameWon)
            {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                buttons[row][col].setEnabled(false);

                if (checkWin())
                {
                    gameWon = true;
                    JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " freaking wins!");
                }

                else if (isBoardFull())
                {
                    JOptionPane.showMessageDialog(frame, "The game is a tie!");
                }

                else
                {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][2].getText().equals(String.valueOf(currentPlayer)))
            {
                return true;
            }

            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[2][i].getText().equals(String.valueOf(currentPlayer)))
            {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer)))
        {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer)))
        {
            return true;
        }
        return false;
    }

    private boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (buttons[i][j].getText().equals(""))
                {
                    return false;
                }
            }
        }
        return true;
    }
}