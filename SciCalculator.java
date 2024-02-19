import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;



public class SciCalculator extends JFrame implements ActionListener {
    private JTextField display;

    public SciCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setPreferredSize(new Dimension(300, 100));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 25));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setForeground(Color.ORANGE);


        String[] buttonLabels = {
                "(",")","C","%" ,"/", "^", "10^x",
                "7", "8", "9","*", "1/x","sqrt", "cbrt", "ln" ,
                "log", "4", "5", "6", "-", "!","sin", "cos",
                "tan", "e","1", "2", "3", "+", "sinh","cosh",
                "tanh","PI", "0", ".", "=",

        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            button.setBackground(Color.lightGray);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String expression = display.getText();

        switch (command) {
            case "=":
                try {
                    double result = evaluateExpression(expression);
                    display.setText(Double.toString(result));
                } catch (ArithmeticException e) {
                    display.setText("Error: " + e.getMessage());
                }
                break;
            case "C":
                display.setText("");
                break;
            case "<=":
                if (!expression.isEmpty()) {
                    String newExpression = expression.substring(0, expression.length() - 1);
                    display.setText(newExpression);
                }
                break;
            default:
                display.setText(expression + command);
                break;
        }
    }

    private double evaluateExpression(String expression) {
        return new ExpressionParser().parse(expression);
    }

    private static class ExpressionParser {
        private int pos = -1;
        private int ch;

        private void nextChar(String expression) {
            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
        }

        private boolean eat(int charToEat, String expression) {
            while (ch == ' ') nextChar(expression);
            if (ch == charToEat) {
                nextChar(expression);
                return true;
            }
            return false;
        }

        private double parse(String expression) {
            nextChar(expression);
            double x = parseExpression(expression);
            if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }


        private double parseExpression(String expression) {
            double x = parseTerm(expression);
            while (true) {
                if (eat('+', expression)) x += parseTerm(expression);
                else if (eat('-', expression)) x -= parseTerm(expression);
                else return x;
            }
        }


        private double parseTerm(String expression) {
            double x = parseFactor(expression);
            while (true) {
                if (eat('*', expression)) x *= parseFactor(expression);
                else if (eat('/', expression)) x /= parseFactor(expression);
                else if (eat('^', expression)) x = Math.pow(x, parseFactor(expression));
                else return x;
            }
        }


        private double parseFactor(String expression) {
            if (eat('+', expression)) return parseFactor(expression);
            if (eat('-', expression)) return -parseFactor(expression);

            double x;
            int startPos = this.pos;
            if (eat('(', expression)) {

                x = parseExpression(expression);
                eat(')', expression);
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                // Parse numbers (integer or decimal)
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar(expression);
                x = Double.parseDouble(expression.substring(startPos, this.pos));
            } else if (ch >= 'a' && ch <= 'z') {
                // Parse functions (such as sqrt, sin, cos, etc.)
                while (ch >= 'a' && ch <= 'z') nextChar(expression);
                String func = expression.substring(startPos, this.pos);
                x = parseFactor(expression);
                switch (func) {
                    case "sqrt":
                        x = Math.sqrt(x);
                        break;
                    case "cbrt":
                        x = Math.cbrt(x);
                        break;
                    case "log":
                        x = Math.log10(x);
                        break;
                    case "ln":
                        x = Math.log(x);
                        break;
                    case "sin":
                        x = Math.sin(Math.toRadians(x));
                        break;
                    case "cos":
                        x = Math.cos(Math.toRadians(x));
                        break;
                    case "tan":
                        x = Math.tan(Math.toRadians(x));
                        break;
                    case "e":
                        x = Math.exp(x);
                        break;
                    case "!":
                        x = factorial((int) x);
                        break;
                    case "%":
                        x = x / 100.0;
                        break;
                    case "PI":
                        x = Math.PI;
                        break;
                    case "sinh":
                        x = Math.sinh(Math.toRadians(x));
                        break;
                    case "cosh":
                        x= Math.cosh(Math.toRadians(x));
                        break;
                    case "tanh":
                        x= Math.tanh(Math.toRadians(x));
                        break;
                    case "1/x":
                        x= 1/x;
                        break;
                    case "10^x":
                        x = Math.pow(10, x);
                        break;
                    default:
                        throw new RuntimeException("Unknown function: " + func);
                }
            } else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }

            return x;
        }


        private int factorial(int n) {
            if (n == 0) return 1;
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(SciCalculator::new);
    }}