import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by strange1 on 13/11/14.
 */
public class ViewContoller extends JFrame{
    static JTextField result;
    public static boolean opFlag  = false;

    public static JButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but0;
    static JButton prozentButton;
    static JButton plusButton, minusButton, mulButton, divButton;
    static JButton resultButton;
    static JButton clearButton;
    static JButton plusminusButton;
    static JButton sqrtButton;
    static JButton powButton;
    static JButton randomButton;
    static JButton kommaButton;
    static double  var = 0.0;
    static int opNummer =0;
    public static boolean kommaFlag = false;
    CalcController calc = new CalcController();
    public static int komma = 0;


    public void creatGui() {
        JFrame f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(f.getContentPane());
        f.requestFocus();
        f.pack();
        f.setVisible(true);

    }


    public void addComponentsToPane(Container pane) {

        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        pane.setFocusable(true); // set focusable to true
       // pane.requestFocusInWindow(); // request focus

        pane.addKeyListener(new KeyHandler());
      //  pane.addFocusListener(new focusHandler());

        c.fill = GridBagConstraints.HORIZONTAL;

        result = new JTextField("0.0");
        result.setEditable(false);
        result.setHorizontalAlignment(JTextField.RIGHT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;

        pane.add(result, c);

        clearButton = new JButton("C");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        pane.add(clearButton, c);

        plusminusButton = new JButton("+/-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(plusminusButton, c);

        prozentButton = new JButton("%");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(prozentButton, c);

        divButton = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(divButton, c);

        but7 = new JButton("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(but7, c);

        but8 = new JButton("8");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        pane.add(but8, c);

        but9 = new JButton("9");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 2;
        pane.add(but9, c);

        mulButton = new JButton("*");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridy = 2;
        pane.add(mulButton, c);
        but4 = new JButton("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        pane.add(but4, c);

        but5 = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(but5, c);

        but6 = new JButton("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        pane.add(but6, c);

        minusButton = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 3;
        pane.add(minusButton, c);

        but1 = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(but1, c);

        but2 = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 4;
        pane.add(but2, c);

        but3 = new JButton("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 4;
        pane.add(but3, c);

        plusButton = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridy = 4;
        pane.add(plusButton, c);

        but0 = new JButton("0");


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 5;
        pane.add(but0, c);

        kommaButton= new JButton(",");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 5;
        pane.add(kommaButton, c);

        resultButton = new JButton("=");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridy = 5;
        pane.add(resultButton, c);

        addList();
    }
    public void addList(){
        actionClick action = new actionClick();

        but1.addActionListener(action);
        but2.addActionListener(action);
        but3.addActionListener(action);
        but4.addActionListener(action);
        but5.addActionListener(action);
        but6.addActionListener(action);
        but7.addActionListener(action);
        but8.addActionListener(action);
        but9.addActionListener(action);




        but0.addActionListener(action);
        but1.addFocusListener(new focusHandler());



        clearButton.addActionListener(action);
        plusminusButton.addActionListener(action);
        prozentButton.addActionListener(action);
        kommaButton.addActionListener(action);
        plusButton.addActionListener(action);
        minusButton.addActionListener(action);
        mulButton.addActionListener(action);
        divButton.addActionListener(action);
        resultButton.addActionListener(action);

        but1.setActionCommand("1");
        but2.setActionCommand("2");
        but3.setActionCommand("3");
        but4.setActionCommand("4");
        but5.setActionCommand("5");
        but6.setActionCommand("6");
        but7.setActionCommand("7");
        but8.setActionCommand("8");
        but9.setActionCommand("9");
        but0.setActionCommand("0");

        clearButton.setActionCommand("11");
        plusminusButton.setActionCommand("12");
        prozentButton.setActionCommand("13");
        kommaButton.setActionCommand("14");
        plusButton.setActionCommand("15");
        minusButton.setActionCommand("16");
        mulButton.setActionCommand("17");
        divButton.setActionCommand("18");
        resultButton.setActionCommand("19");

    }
    public class focusHandler implements FocusListener{
        public void focusGained(FocusEvent e) {
         //   eventLabel.setText("Button 2 — focusGained()");
        }
        public void focusLost(FocusEvent e) {
            getContentPane().requestFocus();
        }
    }
    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 1;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 1;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_2:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 2;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 2;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_3:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 3;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 3;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_4:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 4;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 4;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_5:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 5;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 5;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_6:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 6;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 6;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_7:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 7;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 7;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_8:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 8;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 8;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_9:
                    if (opFlag) {
                        calc.b = calc.b * 10 + 9;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10 + 9;
                        var = calc.a;
                    }
                    break;
                case KeyEvent.VK_0:
                    if (opFlag) {
                        calc.b = calc.b * 10;
                        var = calc.b;
                    } else {
                        calc.a = calc.a * 10;
                        var = calc.a;
                    }
                    break;
                default:
                    break;




            }
            result.setText(String.valueOf(var));

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub


        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }
    public class actionClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (opFlag) {
                var = calc.b;
            } else {
                var = calc.a;
            }

            int action = Integer.parseInt(e.getActionCommand());
            if (action < 10) {
                if (kommaFlag) {
                    komma++;
                    var = var + (action / (Math.pow(10, komma)));
                } else {
                    var = var * 10 + action;
                }
                if (opFlag) {
                    calc.b = var;
                } else {
                    calc.a = var;
                }
            }else {
                switch (action) {
                    case 11:

                        opFlag = false;
                        calc.clear();
                        var = 0.0;
                        kommaFlag = false;
                        komma = 0;
                        break;
                    case 12:
                        var = calc.plusminus(var);
                        calc.a = var;
                        break;
                    case 13:
                        var = calc.prozent(var);
                        calc.a = var;
                        break;
                    case 14:
                        kommaFlag = true;
                        break;
                    case 15:
                        opFlag = true;
                        opNummer = 1;
                        var = 0;
                        calc.b = 0;
                        break;
                    case 16:
                        opFlag = true;
                        opNummer = 2;
                        var = 0;
                        calc.b = 0;
                        break;
                    case 17:
                        opFlag = true;
                        opNummer = 3;
                        var = 0;
                        calc.b = 0;
                        break;
                    case 18:
                        opFlag = true;
                        opNummer = 4;
                        var = 0;
                        calc.b = 0;
                        break;
                    case 19:
                        switch (opNummer) {
                            case 1:
                                var = calc.plus(calc.a, calc.b);
                                break;
                            case 2:
                                var = calc.minus(calc.a, calc.b);
                                break;
                            case 3:
                                var = calc.mul(calc.a, calc.b);
                                break;
                            case 4:
                                var = calc.division(calc.a, calc.b);
                                break;
                            default:
                                break;
                        }
                        result.setText(String.valueOf(var));
                        calc.a = var;
                        komma = 0;
                        break;
                    default:
                        break;
                }
            }
                result.setText(String.valueOf(var));

        }


    }
}