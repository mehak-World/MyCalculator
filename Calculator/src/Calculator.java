import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JPanel panel;
	JButton[] numberButtons = new JButton[10];
	JButton[] funcButtons = new JButton[8];
	JTextField field;
	 
	JButton addButton, subButton,  mulButton, divButton, decButton, delButton, clrButton, equButton;
	
	double	num1 = 0;
	double result = 0;
	char operator;
	double num2 = 0;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		
		field = new JTextField(20);
		field.setEditable(false);
		field.setFont(new Font("MV Boli", Font.BOLD, 30));
		field.setBounds(30, 10, 300, 40);
		
		 addButton = new JButton("+");
		 subButton = new JButton("-");
		 mulButton = new JButton("*");
		 divButton = new JButton("/");
		 decButton = new JButton(".");
		 delButton = new JButton("Del");
		 clrButton = new JButton("Clr");
		 equButton= new JButton("=");
		
		delButton.setBounds(30, 400, 150, 50 );
		clrButton.setBounds(180, 400, 150,50);
		
		funcButtons[0] = addButton;
		funcButtons[1] = subButton;
		funcButtons[2] = mulButton;
		funcButtons[3] = divButton;
		funcButtons[4] = decButton;
		funcButtons[5] = equButton;
		funcButtons[6] = delButton;
		funcButtons[7] = clrButton;
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBounds(30, 80, 300, 280);
		
		
		for(int i=0; i<8; i++) {
			funcButtons[i].setFocusable(false);
			funcButtons[i].setFont(new Font("MV Boli", Font.BOLD, 30));
			funcButtons[i].addActionListener(this);
		}
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(new Font("MV Boli", Font.BOLD, 30));
			numberButtons[i].addActionListener(this);
		}
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[0]);
		panel.add(divButton);
		panel.add(decButton);
		panel.add(equButton);
		
		
		frame.add(field);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		field.setEditable(true);
		
		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				field.setText(field.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == addButton) {
			String str = field.getText();
			num1 = Double.parseDouble(str);
			operator = '+';
			field.setText("");
			
		}
		
		if(e.getSource() == subButton) {
			String str = field.getText();
			num1 = Double.parseDouble(str);
			operator = '-';
			field.setText("");
		}
		
		if(e.getSource() == mulButton) {
			String str = field.getText();
			num1 = Double.parseDouble(str);
			operator = '*';
			field.setText("");
		}
		
		if(e.getSource() == divButton) {
			String str = field.getText();
			num1 = Double.parseDouble(str);
			operator = '/';
			field.setText("");
		}
		
		if(e.getSource() == equButton) {
			
			switch(operator) {
			case '+':
				String str2 = field.getText();
				num2 = Double.parseDouble(str2);
				
				result = num1 + num2;
				field.setText(String.valueOf(result));
				break;
			
			case '-':
				String str3 = field.getText();
				num2 = Double.parseDouble(str3);
				
				result = num1 - num2;
				field.setText(String.valueOf(result));
				break;
				
			case '*':
				String str4 = field.getText();
				num2 = Double.parseDouble(str4);
				
				result = num1 * num2;
				field.setText(String.valueOf(result));
				break;
				
			case '/':
				String str5 = field.getText();
				num2 = Double.parseDouble(str5);
				
				result = num1 / num2;
				field.setText(String.valueOf(result));
				break;
				
			}
		}
		
		if(e.getSource() == decButton) {
			field.setText(field.getText().concat("."));
			
		}
		
		if(e.getSource() == clrButton) {
			field.setText(" ");
		}
		
		
		if(e.getSource() == delButton) {
			String str = field.getText();
			field.setText(" ");
			
			for(int i=0; i<str.length() - 1; i++) {
				field.setText(field.getText()+ str.charAt(i));
			}
		}
		
	
	}
}
