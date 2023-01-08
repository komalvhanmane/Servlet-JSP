package Calci;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator  implements ActionListener{
	JFrame jfr;
	JTextField jtf;
	JPanel jp,jp1;
	String op1,op2,operator;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bdot,beqal,bclear,bsin,bcos,btan;
	
	
	Calculator(){
		System.out.println("hello");
		op1=op2=operator="";
		jfr=new JFrame("Komal's Calculator");
		jtf =new JTextField(20);
		jtf.setEditable(false);
		//text field non editable
		
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		badd = new JButton("+");
		bsub = new JButton("-");
		bmul = new JButton("*");
		bdiv = new JButton("/");
		bdot = new JButton(".");
		beqal = new JButton("=");
		bclear = new JButton("C");
		bsin =new JButton("sin");
		bcos = new JButton("cos");
		btan = new JButton("tan");
		
		Font f=b1.getFont().deriveFont(20f);
		
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.setFont(f);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		b2.setFont(f);
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		b3.setFont(f);
		b4.setBackground(Color.blue);
		b4.setForeground(Color.white);
		b4.setFont(f);
		b5.setBackground(Color.blue);
		b5.setForeground(Color.white);
		b5.setFont(f);
		b6.setBackground(Color.blue);
		b6.setForeground(Color.white);
		b6.setFont(f);
		b7.setBackground(Color.blue);
		b7.setForeground(Color.white);
		b7.setFont(f);
		b8.setBackground(Color.blue);
		b8.setForeground(Color.white);
		b8.setFont(f);
		b9.setBackground(Color.blue);
		b9.setForeground(Color.white);
		b9.setFont(f);
		b0.setBackground(Color.blue);
		b0.setForeground(Color.white);
		b0.setFont(f);
		badd.setBackground(Color.blue);
		badd.setForeground(Color.white);
		badd.setFont(f);
		bsub.setBackground(Color.blue);
		bsub.setForeground(Color.white);
		bsub.setFont(f);
		bmul.setBackground(Color.blue);
		bmul.setForeground(Color.white);
		bmul.setFont(f);
		bdiv.setBackground(Color.blue);
		bdiv.setForeground(Color.white);
		bdiv.setFont(f);
		bdot.setBackground(Color.blue);
		bdot.setForeground(Color.white);
		bdot.setFont(f);
		beqal.setBackground(Color.blue);
		beqal.setForeground(Color.white);
		beqal.setFont(f);
		bclear.setBackground(Color.blue);
		bclear.setForeground(Color.white);
		bclear.setFont(f);
		bsin.setBackground(Color.blue);
		bsin.setForeground(Color.white);
		bsin.setFont(f);
		bcos.setBackground(Color.blue);
		bcos.setForeground(Color.white);
		bcos.setFont(f);
		btan.setBackground(Color.blue);
		btan.setForeground(Color.white);
		btan.setFont(f);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		badd.addActionListener(this);
		bsub.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		beqal.addActionListener(this);
		bclear.addActionListener(this);
		bdot.addActionListener(this);
		bsin.addActionListener(this);
		bcos.addActionListener(this);
		btan.addActionListener(this);
		jp1 =new JPanel();
		
		jp1.add(jtf);
		GridLayout gl=new GridLayout(5,4);
		jp = new JPanel(gl);
		
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(badd);
		jp.add(b4);
		jp.add(b5);
		jp.add(b6);
		jp.add(bsub);
		jp.add(b7);
		jp.add(b8);
		jp.add(b9);
		jp.add(bmul);
		jp.add(b0);
		jp.add(bdot);
		jp.add(bclear);
		jp.add(bdiv);
		jp.add(bsin);
		jp.add(bcos);
		jp.add(btan);
		jp.add(beqal);
		Font f1=jtf.getFont().deriveFont(40f);
		jtf.setFont(f1);
		jfr.add(jp1,BorderLayout.NORTH);
		jfr.add(jp,BorderLayout.CENTER);
		
		jfr.setSize(500,500);
		jfr.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String input=e.getActionCommand();
		if((input.charAt(0) >= '0' && input.charAt(0)<='9') || input.charAt(0)=='.') {
			if(!operator.equals("")) {
				op2 += input;
			}
			else {
				op1 += input;
			}
			jtf.setText(op1+operator+op2);
		}
		else if(input.charAt(0)=='C') {
			operator = op1 = op2 ="";
			jtf.setText(op1+operator+op2);
		}
		else if(input.charAt(0)=='=') {
			if(op1.equals("")||op2.equals("")) {
				jtf.setText("Enter the both numbers for operation");
			}
			else {
				double result = 0;
				if(operator.equals("+")) {
					result = Double.parseDouble(op1)+Double.parseDouble(op2);
				}
				else if(operator.equals("-")) {
					result = Double.parseDouble(op1)-Double.parseDouble(op2);
				}
				else if(operator.equals("*")) {
					result = Double.parseDouble(op1)*Double.parseDouble(op2);
				}
				else if(operator.equals("/")) {
					if(op2.equals("0")) {
						jtf.setText("Undefined");
						op1="";
						op2="";
						operator="";
						return;
					}
					result = Double.parseDouble(op1)/Double.parseDouble(op2);
				}
				jtf.setText(Double.toString(result));
				op1=Double.toString(result);
				operator=op2="";
			}
			
		}
		else if(input.equals("sin")) {
			if(op1.equals("")) {
				jtf.setText("Enter the value first!!");
				return;
			}
			double value=Math.sin(Double.parseDouble(op1));
			jtf.setText("sin("+op1+")="+Double.toString(value));
		}
		else if(input.equals("cos")) {
			if(op1.equals("")) {
				jtf.setText("Enter the value first!!");
				return;
			}
			double value=Math.cos(Double.parseDouble(op1));
			jtf.setText("cos("+op1+")="+Double.toString(value));
		}
		else if(input.equals("tan")) {
			if(op1.equals("")) {
				jtf.setText("Enter the value first!!");
				return;
			}
			double value=Math.tan(Double.parseDouble(op1));
			jtf.setText("tan("+op1+")="+Double.toString(value));
		}
		else {
			if(operator.equals("") || op2.equals("")) {
				operator=input;
			}
			else {
				double result = 0;
				if(operator.equals("+")) {
					result = Double.parseDouble(op1)+Double.parseDouble(op2);
				}
				else if(operator.equals("-")) {
					result = Double.parseDouble(op1)-Double.parseDouble(op2);
				}
				else if(operator.equals("*")) {
					result = Double.parseDouble(op1)*Double.parseDouble(op2);
				}
				else if(operator.equals("/")) {
					if(op2.equals("0")) {
						jtf.setText("Undefined");
						op1="";
						op2="";
						operator="";
						return;
					}
					result = Double.parseDouble(op1)/Double.parseDouble(op2);
				}
				op1=Double.toString(result);
				operator = input;
				op2="";
			}
			jtf.setText(op1+operator+op2);
		}
	}
	
}
