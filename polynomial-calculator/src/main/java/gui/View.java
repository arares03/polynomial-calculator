package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private AppListener appListener;
    private JPanel contentPane;
    private JPanel numbersPanel;
    private JLabel firstNumberLabel;
    private JTextField firstNumberTextField;
    private JLabel secondNumberLabel;
    private JTextField secondNumberTextField;
    private JLabel operationsLabel;
    private JRadioButton addRadioButton;
    private JRadioButton subtractRadioButton;
    private JRadioButton multiplyRadioButton;

    private JRadioButton divisionRadioButton;
    private JRadioButton derivativeRadioButton;
    private JRadioButton integrationRadioButton;

    private ButtonGroup operationButtonGroup;
    private JButton computeButton;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JLabel resultValueLabel;

    public View(String name, AppListener appListener) {
        super(name);
        this.appListener = appListener;
        prepareGui();
    }

    private void prepareGui() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = new JPanel(new GridLayout(2, 1));
        prepareNumbersPanel();
        prepareResultPanel();
        setContentPane(contentPane);
    }

    private void prepareResultPanel() {
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 1));
        resultLabel = new JLabel("Result", JLabel.CENTER);
        resultValueLabel = new JLabel("", JLabel.CENTER);
        resultPanel.add(resultLabel);
        resultPanel.add(resultValueLabel);
        contentPane.add(resultPanel);
    }

    private void prepareNumbersPanel() {
        numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(7, 1, 5, 5));

        firstNumberLabel = new JLabel("First number", JLabel.CENTER);
        numbersPanel.add(firstNumberLabel);
        firstNumberTextField = new JTextField();
        numbersPanel.add(firstNumberTextField);

        secondNumberLabel = new JLabel("Second number", JLabel.CENTER);
        numbersPanel.add(secondNumberLabel);
        secondNumberTextField = new JTextField();
        numbersPanel.add(secondNumberTextField);

        operationsLabel = new JLabel("Select operation", JLabel.CENTER);
        numbersPanel.add(operationsLabel);
        addRadioButton = new JRadioButton("Add");
        subtractRadioButton = new JRadioButton("Subtract");
        multiplyRadioButton = new JRadioButton("Multiply");
        divisionRadioButton = new JRadioButton("Division");
        derivativeRadioButton = new JRadioButton("Derivative");
        integrationRadioButton = new JRadioButton("Integrate");

        operationButtonGroup = new ButtonGroup();
        operationButtonGroup.add(addRadioButton);
        operationButtonGroup.add(subtractRadioButton);
        operationButtonGroup.add(multiplyRadioButton);

        operationButtonGroup.add(divisionRadioButton);
        operationButtonGroup.add(derivativeRadioButton);
        operationButtonGroup.add(integrationRadioButton);

        JPanel operationPanel = new JPanel(new GridLayout(1, 6));
        operationPanel.add(addRadioButton);
        operationPanel.add(subtractRadioButton);
        operationPanel.add(multiplyRadioButton);
        operationPanel.add(divisionRadioButton);
        operationPanel.add(derivativeRadioButton);
        operationPanel.add(integrationRadioButton);
        numbersPanel.add(operationPanel);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        computeButton = new JButton("Compute");


        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOperation = "";
                if (addRadioButton.isSelected()) {
                    selectedOperation = addRadioButton.getText();
                } else if (subtractRadioButton.isSelected()) {
                    selectedOperation = subtractRadioButton.getText();
                } else if (multiplyRadioButton.isSelected()) {
                    selectedOperation = multiplyRadioButton.getText();
                } else if (divisionRadioButton.isSelected()) {
                    selectedOperation = divisionRadioButton.getText();
                } else if (derivativeRadioButton.isSelected()) {
                    selectedOperation = derivativeRadioButton.getText();
                } else if (integrationRadioButton.isSelected()) {
                    selectedOperation = integrationRadioButton.getText();
                }

                String firstPolynomial = firstNumberTextField.getText();
                String secondPolynomial = secondNumberTextField.getText();

                String ans = appListener.processData(firstPolynomial, secondPolynomial, selectedOperation);
                resultValueLabel.setText(ans);
            }
        });

        buttonPanel.add(computeButton);
        numbersPanel.add(buttonPanel);

        contentPane.add(numbersPanel);
    }

    public JTextField getFirstNumberTextField() {
        return firstNumberTextField;
    }

    public JTextField getSecondNumberTextField() {
        return secondNumberTextField;
    }

    public JRadioButton getAddRadioButton() {
        return addRadioButton;
    }

    public JRadioButton getSubtractRadioButton() {
        return subtractRadioButton;
    }

    public JRadioButton getMultiplyRadioButton() {
        return multiplyRadioButton;
    }

    public JButton getComputeButton() {
        return computeButton;
    }

    public JLabel getResultValueLabel() {
        return resultValueLabel;
    }

}
