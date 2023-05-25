package _11_binary_converter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class binaryConverter implements ActionListener{
	JFrame frame = new JFrame("Binary Converter");
	JPanel panel = new JPanel();
	JLabel output = new JLabel();
	JTextField answer = new JTextField(20);
	JButton button = new JButton();
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(output);
		panel.add(answer);
		panel.add(button);
		button.addActionListener(this);
		button.setText("convert");
		frame.setSize(400,120);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String answerText = answer.getText();
		String conversionAnswer = convert(answerText);
		output.setText(conversionAnswer);
	}
	String convert(String input) {
	    if(input.length() != 8){
	        JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
	        return "-";
	    }
	    String binary = "[0-1]+";//must contain numbers in the given range
	    if (!input.matches(binary)) {
	        JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
	        return "-";   
	    }
	    try {
	        int asciiValue = Integer.parseInt(input, 2);
	        char theLetter = (char) asciiValue;
	        return "" + theLetter;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
	        return "-";
	    }
	}

}
