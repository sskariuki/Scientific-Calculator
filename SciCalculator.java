package SciCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;


public class SciCalculator extends JFrame implements ActionListener {



    private String[] btnLabels = {
            "(", ")", "mc", "m+", "m-", "mr", "C", "+/-", "%", "÷",
            "2ⁿᵈ", "x²", "x³", "xʸ", "eˣ", "10ˣ", "7", "8", "9", "x",
            "1/x", "²√x", "³√x", "ʸ√x", "ln", "log₁₀", "4", "5", "6", "-",
            "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+",
            "Rad", "sinh", "cosh", "tanh", "π", "Rand", "0", ".", "="
    };
    private boolean isDegreeMode = true;
    private int operator = 0;
    private JPanel panel = new JPanel(new BorderLayout(5, 5));
    private JPanel btnPanel = new JPanel(new GridLayout(5, 10, 2, 2));
    private JButton[] btns = new JButton[49];
    private JTextArea screen = new JTextArea(5, 40);
    private double firstNum = 0, secondNum = 0;


    public SciCalculator() {
        init();
    }

    private void init() {
        screen.setFont(new Font("Times New Roman", Font.BOLD, 30));
        setTitle("Calculator");
        screen.setBackground(Color.black);
        panel.setBackground(Color.GRAY  );
        btnPanel.setBackground(Color.LIGHT_GRAY);
        screen.setForeground(Color.WHITE);


            for (int i = 0; i < btns.length; i++) {
                btns[i] = new JButton(btnLabels[i]);
                btns[i].setOpaque(true);
                btns[i].setBorderPainted(false);
                btns[i].setBackground(Color.DARK_GRAY);
                btns[i].setForeground(Color.WHITE);
                btns[i].addActionListener(this);
                btnPanel.add(btns[i]);
            }


            btns[0].setBackground(Color.darkGray);
            btns[1].setBackground(Color.darkGray);
            btns[2].setBackground(Color.darkGray);
            btns[3].setBackground(Color.darkGray);
            btns[4].setBackground(Color.darkGray);
            btns[5].setBackground(Color.darkGray);
            btns[6].setBackground(Color.darkGray);
            btns[7].setBackground(Color.darkGray);
            btns[8].setBackground(Color.darkGray);
            btns[9].setBackground(Color.red);
            btns[10].setBackground(Color.darkGray);
            btns[11].setBackground(Color.darkGray);
            btns[12].setBackground(Color.darkGray);
            btns[13].setBackground(Color.darkGray);
            btns[14].setBackground(Color.darkGray);
            btns[15].setBackground(Color.darkGray);
            btns[16].setBackground(Color.gray);
            btns[17].setBackground(Color.gray);
            btns[18].setBackground(Color.gray);
            btns[19].setBackground(Color.red);
            btns[20].setBackground(Color.darkGray);
            btns[21].setBackground(Color.darkGray);
            btns[22].setBackground(Color.darkGray);
            btns[23].setBackground(Color.darkGray);
            btns[24].setBackground(Color.darkGray);
            btns[25].setBackground(Color.darkGray);
            btns[26].setBackground(Color.gray);
            btns[27].setBackground(Color.gray);
            btns[28].setBackground(Color.gray);
            btns[29].setBackground(Color.red);
            btns[30].setBackground(Color.darkGray);
            btns[31].setBackground(Color.darkGray);
            btns[32].setBackground(Color.darkGray);
            btns[33].setBackground(Color.darkGray);
            btns[34].setBackground(Color.darkGray);
            btns[35].setBackground(Color.darkGray);
            btns[36].setBackground(Color.gray);
            btns[37].setBackground(Color.gray);
            btns[38].setBackground(Color.gray);
            btns[39].setBackground(Color.red);
            btns[40].setBackground(Color.darkGray);
            btns[41].setBackground(Color.darkGray);
            btns[42].setBackground(Color.darkGray);
            btns[43].setBackground(Color.darkGray);
            btns[44].setBackground(Color.darkGray);
            btns[45].setBackground(Color.darkGray);
            btns[46].setBackground(Color.gray);
            btns[47].setBackground(Color.gray);
            btns[48].setBackground(Color.red);




        panel.add(btnPanel, BorderLayout.CENTER);
        panel.add(screen, BorderLayout.NORTH);
        screen.setEditable(false);
        add(panel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SciCalculator::new);
    }
    private double memory = 0.0;
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cmd = e.getActionCommand().toString();
            double y = 0.0;


            switch (cmd) {



                case ".":
                    if (!screen.getText().contains(".")) {
                        screen.setText(screen.getText() + ".");
                    }
                    break;
                case "0":
                    screen.setText(screen.getText() + "0");
                    break;
                case "1":
                    screen.setText(screen.getText() + "1");
                    break;
                case "2":
                    screen.setText(screen.getText() + "2");
                    break;
                case "3":
                    screen.setText(screen.getText() + "3");
                    break;
                case "4":
                    screen.setText(screen.getText() + "4");
                    break;
                case "5":
                    screen.setText(screen.getText() + "5");
                    break;
                case "6":
                    screen.setText(screen.getText() + "6");
                    break;
                case "7":
                    screen.setText(screen.getText() + "7");
                    break;
                case "8":
                    screen.setText(screen.getText() + "8");
                    break;
                case "9":
                    screen.setText(screen.getText() + "9");
                    break;
                case "(":
                    screen.setText(screen.getText() + "(");
                    break;
                case ")":
                    screen.setText(screen.getText() + ")");
                    break;

                case "π":
                    screen.setText(screen.getText() + Math.PI);
                    break;
                case "e":
                    screen.setText(screen.getText() + Math.exp(1));
                    break;


                case "+":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 1;
                        screen.setText("");
                    }
                    break;
                case "-":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 2;
                        screen.setText("");
                    }
                    break;
                case "x":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 3;
                        screen.setText("");
                    }
                    break;
                case "÷":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 4;
                        screen.setText("");
                    }
                    break;
                case "xʸ":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 5;
                        screen.setText("");
                    }
                    break;
                case "ʸ√x":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 6;
                        screen.setText("");
                    }
                    break;

                case "%":
                    double num = Double.parseDouble(screen.getText().toString());
                    screen.setText(String.valueOf(num / 100.0));
                    break;
                case "+/-":
                    String text = screen.getText().toString();
                    if (!text.isEmpty()) {
                        double neg = Double.parseDouble(text);
                        neg *= -1;
                        screen.setText(String.valueOf(neg));
                    }
                    break;
                case "x!":
                    double currentInput = Double.parseDouble(screen.getText().toString());
                    int fact = 1;
                    for(int i=1;i<=currentInput;i++){
                        fact = fact*i;
                    }
                    screen.setText(String.valueOf(fact));
                    break;
                case "C":
                    screen.setText("");
                    break;

                case "sin", "cos", "tan", "²√x", "x²", "x³", "³√x", "10ˣ", "1/x",
                        "log₁₀", "ln", "eˣ", "sinh", "cosh", "tanh":
                    specialFunctions(cmd);
                    break;
                case "mc":
                    memory = 0;
                    break;
                case "m+":
                    if (!screen.getText().isEmpty()) {
                        memory += Double.parseDouble(screen.getText());
                    }
                    break;
                case "m-":
                    if (!screen.getText().isEmpty()) {
                        memory -= Double.parseDouble(screen.getText());
                    }
                    break;
                case "mr":
                    screen.setText(String.valueOf(memory));
                    break;
                case "2ⁿᵈ":
                    screen.setText(String.valueOf(Math.pow(Double.parseDouble(screen.getText()), 2)));
                    break;


                case "Rand":
                    screen.setText(String.valueOf(Math.random()));
                    break;
                case "EE":
                    if (!screen.getText().isEmpty()) {
                        double currentNumber = Double.parseDouble(screen.getText());
                        double result = currentNumber * Math.pow(10, currentNumber);
                        screen.setText(String.valueOf(result));
                    }
                    break;
                case "Rad":

                    isDegreeMode = !isDegreeMode;
                    break;


                default:
            }
            if (isDegreeMode && (cmd.equals("sin") || cmd.equals("cos") || cmd.equals("tan"))) {


                double radian = Math.toRadians(Double.parseDouble(screen.getText()));
                switch (cmd) {
                    case "sin":
                        screen.setText(String.valueOf(Math.sin(radian)));
                        break;
                    case "cos":
                        screen.setText(String.valueOf(Math.cos(radian)));
                        break;
                    case "tan":
                        screen.setText(String.valueOf(Math.tan(radian)));
                        break;
                }
            }

            if (cmd.equalsIgnoreCase("=")) {

                if (!screen.getText().isEmpty()) {

                    secondNum = Double.parseDouble(screen.getText().toString());

                    switch (operator) {
                        case 1:
                            screen.setText(String.valueOf(firstNum + secondNum));
                            break;
                        case 2:
                            screen.setText(String.valueOf(firstNum - secondNum));
                            break;
                        case 3:
                            screen.setText(String.valueOf(firstNum * secondNum));
                            break;
                        case 4:
                            if (secondNum != 0){
                                screen.setText(String.valueOf(firstNum / secondNum));
                            }else {
                                throw new ArithmeticException("Cannot divide by zero");
                            }
                            break;
                        case 5:
                            screen.setText(String.valueOf(Math.pow(firstNum, secondNum)));
                            break;
                        case 6:
                            screen.setText(String.valueOf(Math.pow(firstNum, (1 / secondNum))));
                            break;
                        default:
                    }
                }
            }
        }catch (NumberFormatException e1){
            screen.setText("Syntax Error");
        }catch (ArithmeticException e2){
            screen.setText("Math Error " + e2.getMessage());
        }
    }

    private void specialFunctions(String operation) {
        try {
            if (!screen.getText().isEmpty()) {
                double currentInput = Double.parseDouble(screen.getText().toString());
                double result = 0;
                double radian = (currentInput * (Math.PI / 180));

                switch (operation) {
                    case "sin":
                        result = Math.sin(radian);
                        break;
                    case "cos":
                        result = Math.cos(radian);
                        break;
                    case "tan":
                        result = Math.tan(radian);
                        break;
                    case "x²":
                        result = Math.pow(currentInput, 2);
                        break;
                    case "²√x":
                        result = Math.sqrt(currentInput);
                        break;
                    case "x³":
                        result = Math.pow(currentInput, 3);
                        break;
                    case "³√x":
                        result = Math.cbrt(currentInput);
                        break;
                    case "10ˣ":
                        result = Math.pow(10, currentInput);
                        break;
                    case "eˣ":
                        result = Math.exp(currentInput);
                        break;
                    case "1/x":
                        if (currentInput != 0){
                            result = 1 / currentInput;
                        }else {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        break;
                    case "log₁₀":
                        result = Math.log10(currentInput);
                        break;
                    case "ln":
                        result = Math.log(currentInput);
                        break;
                    case "sinh":
                        result = Math.sinh(currentInput);
                        break;
                    case "cosh":
                        result = Math.cosh(currentInput);
                        break;
                    case "tanh":
                        result = Math.tanh(currentInput);
                        break;


                }
                screen.setText(String.valueOf(result));
            }
        }catch (NumberFormatException e1){
            screen.setText("Syntax Error");
        }catch (ArithmeticException e2){
            screen.setText("Math Error" + e2.getMessage());
        }
    }

}
