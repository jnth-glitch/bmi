/*
	NAME: JAYANTH K
	GITHUB: jnth-glitch
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

class bmi extends javax.swing.JFrame implements ActionListener
{
	/*DEFINING GUI COMPONENTS*/
	
	static JFrame f;
	static JLabel heightl,weightl,result1,result2;
	static JButton calc;
	static JComboBox height_list,weight_list; 
	static JTextField height,weight;
	float res;
	bmi(){}
	
	/* COMPUTE FUNCTION TO CALCULATE BMI*/
	float compute(){
		String h_type=(String)height_list.getSelectedItem();
		String w_type=(String)weight_list.getSelectedItem();
		float h=Float.parseFloat(height.getText());
		float w=Float.parseFloat(weight.getText());
		if (h_type.equals("cm"))
			h/=100;
		else if (h_type.equals("ft"))
			h/=3.28;
		if (w_type.equals("lbs"))
			w/=2.25;
		res=w/(h*h);
		return res;
	}
	/*MAIN FUNCTION*/
	public static void main(String[] args){
		bmi b=new bmi();
		f=new JFrame("BMI CALCULATOR");
		heightl=new JLabel("Enter Height");
		weightl=new JLabel("Enter Weight");
		String[] h={"m","cm","ft"};
		String[] w={"kg","lbs"};
		height_list=new JComboBox(h);
		weight_list=new JComboBox(w);
		height= new JTextField(20);
		weight= new JTextField(20);
		result1= new JLabel();
		result2=new JLabel();
		calc= new JButton("CALCULATE");
		calc.addActionListener(b);
		
		/*ADDING GUI COMPONENTS TO JFRAME*/
		
		f.add(heightl);
		f.add(height);
		f.add(height_list);
		f.add(weightl);
		f.add(weight);
		f.add(weight_list);
		f.add(calc);
		f.add(result1);
		f.add(result2);	
		
		/*SPECIFYING THE POSITIONS OF THE GUI COMPONENTS */
		
		heightl.setBounds(30,0,70,70);
		height.setBounds(120,27,120,20);
		height_list.setBounds(250,27,50,20);
		weightl.setBounds(30,30,100,100);
		weight.setBounds(120,72,120,20);
		weight_list.setBounds(250,72,50,20);
		calc.setBounds(120,120,120,20);
		result1.setBounds(120,130,100,100);
		result2.setBounds(120,150,100,100);
		
		/*CONFIGURING THE JFRAME*/
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	/*ACTIONPREFORMED FUNCTION TRIGGERED WHEN CALCULATE BUTTON PRESSED*/
	
	public void actionPerformed(ActionEvent e){
		DecimalFormat f=new DecimalFormat("##.00");
		res=compute();
		if (res<18.5)
			{ result1.setText("Your BMI: "+f.format(res));
			  result2.setText("Underweight");
			}
		else if(res>18.5 && res< 24.9) 			
			{ result1.setText("Your BMI: "+f.format(res));
			  result2.setText("\nNormal weight :)"); 
			}
		else if (res >24.9 && res<29.9)
			{ result1.setText("Your BMI: "+f.format(res));
			  result2.setText("\nOver weight");
			}
		else
			{ result1.setText("Your BMI: "+f.format(res));
			  result2.setText("\nObese :(");
			}
	}
}