package com.games.abyssal.Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;

public class ClassEditor {

	private JFrame frame;
	private JTextField textPA0;
	private JTextField textPA5;
	private JTextField textPA10;
	private JTextField textPA15;
	private JTextField textPA20;
	
	public static final String FUNCTION_LINEAR = "Linear";
	public static final String FUNCTION_SQUARE = "Square";
	public static final String FUNCTION_ROOT = "Root";
	public static final String FUNCTION_CONSTANT = "Constant";
	
	private AttributeInfo PA;
	private JComboBox<String> comboBoxPA;
	private JSpinner spinnerPAa;
	private JSpinner spinnerPAb;
	private JSpinner spinnerPAc;
	
	private class AttributeInfo 
	{
		public AttributeInfo(String name)
		{
			this.name = name;
			function = FUNCTION_CONSTANT;
			a = 1f;
			b = 1f;
			c = 1f;
		}
		
		public String name;
		public String function;
		public Float a;
		public Float b;
		public Float c;
		
		@Override
		public String toString()
		{
			return String.format("%s;$.2f;$.2f;$.2f", function, a, b, c); 
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassEditor window = new ClassEditor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClassEditor() {
		initialize();
		PA = new AttributeInfo("pAttack");
		refreshInterface();
	}
	
	

	private void refreshInterface() {
		getSpinnerPAa().setValue(PA.a);
		getSpinnerPAb().setValue(PA.b);
		getSpinnerPAc().setValue(PA.c);
		getComboBoxPA().setSelectedItem(PA.function);
		int[] examples = getExamples(PA.a, PA.b, PA.c, PA.function);
		getTextPA0().setText(Integer.toString(examples[0]));
		getTextPA5().setText(Integer.toString(examples[1]));
		getTextPA10().setText(Integer.toString(examples[2]));
		getTextPA15().setText(Integer.toString(examples[3]));
		getTextPA20().setText(Integer.toString(examples[4]));
	}
	
	private int[] getExamples(Float a, Float b, Float c, String function) {
		int examples[] = new int[5];
		for (int i = 0; i < 5; i++) {
			switch (function) {
			case FUNCTION_CONSTANT:
				examples[i] = constant(a);
				break;
			case FUNCTION_ROOT:
				examples[i] = root(a,b,5*i);
				break;
			case FUNCTION_SQUARE:
				examples[i] = square(a,b,c,5*i);
				break;
			case FUNCTION_LINEAR:
				examples[i] = linear(a,b,5*i);
				break;
			}
		}
		return examples;
	}

	private int linear(Float a, Float b, int x) {
		return (int) (a*x + b);
	}

	private int square(Float a, Float b, Float c, int x) {
		return (int) (Math.pow(a, b)*x + c);
	}

	private int root(Float a, Float b, int x) {
		return (int) (Math.pow(a, 0.5)*x + b);
	}

	private int constant(float a) {
		return (int)a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmFile = new JMenuItem("Export");
		mnFile.add(mntmFile);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		frame.getContentPane().setLayout(null);
		
		comboBoxPA = new JComboBox<String>();
		comboBoxPA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					PA.function = getComboBoxPA().getSelectedItem().toString();
					refreshInterface();
				}
			}
		});

		comboBoxPA.setModel(new DefaultComboBoxModel<String>(new String[] {"Constant", "Linear", "Square", "Root"}));
		comboBoxPA.setBounds(115, 38, 95, 20);
		frame.getContentPane().add(comboBoxPA);
		
		JLabel lblPhysicalAttack = new JLabel("Physical Attack");
		lblPhysicalAttack.setBounds(10, 41, 95, 14);
		frame.getContentPane().add(lblPhysicalAttack);
		
		spinnerPAa = new JSpinner();
		spinnerPAa.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				PA.a = Float.parseFloat(spinnerPAa.getValue().toString());
				refreshInterface();
			}
		});
		spinnerPAa.setModel(new SpinnerNumberModel(new Float(1f), null, null, new Float(0.1f)));
		spinnerPAa.setBounds(240, 36, 48, 20);
		frame.getContentPane().add(spinnerPAa);
		
		JLabel lblA = new JLabel("a");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(271, 11, 17, 14);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("b");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(329, 11, 17, 14);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("c");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(387, 11, 17, 14);
		frame.getContentPane().add(lblC);
		
		spinnerPAb = new JSpinner();
		spinnerPAb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				PA.b = Float.parseFloat(spinnerPAb.getValue().toString());
				refreshInterface();
			}
		});
		spinnerPAb.setModel(new SpinnerNumberModel(new Float(1f), null, null, new Float(0.1f)));
		spinnerPAb.setBounds(298, 36, 48, 20);
		frame.getContentPane().add(spinnerPAb);
		
		spinnerPAc = new JSpinner();
		spinnerPAc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				PA.c = Float.parseFloat(spinnerPAc.getValue().toString());
				refreshInterface();
			}
		});
		spinnerPAc.setModel(new SpinnerNumberModel(new Float(1f), null, null, new Float(0.1f)));
		spinnerPAc.setBounds(356, 36, 48, 20);
		frame.getContentPane().add(spinnerPAc);
		
		JLabel lblLvl = new JLabel("lvl 0");
		lblLvl.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl.setBounds(434, 11, 36, 14);
		frame.getContentPane().add(lblLvl);
		
		JLabel lblLvl_1 = new JLabel("lvl 5");
		lblLvl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl_1.setBounds(480, 11, 36, 14);
		frame.getContentPane().add(lblLvl_1);
		
		JLabel lblLvl_2 = new JLabel("lvl 10");
		lblLvl_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl_2.setBounds(526, 11, 36, 14);
		frame.getContentPane().add(lblLvl_2);
		
		textPA0 = new JTextField();
		textPA0.setEditable(false);
		textPA0.setText("9999");
		textPA0.setBounds(434, 36, 36, 20);
		frame.getContentPane().add(textPA0);
		textPA0.setColumns(10);
		
		textPA5 = new JTextField();
		textPA5.setEditable(false);
		textPA5.setText("9999");
		textPA5.setColumns(10);
		textPA5.setBounds(480, 36, 36, 20);
		frame.getContentPane().add(textPA5);
		
		textPA10 = new JTextField();
		textPA10.setEditable(false);
		textPA10.setText("9999");
		textPA10.setColumns(10);
		textPA10.setBounds(526, 36, 36, 20);
		frame.getContentPane().add(textPA10);
		
		textPA15 = new JTextField();
		textPA15.setEditable(false);
		textPA15.setText("9999");
		textPA15.setColumns(10);
		textPA15.setBounds(572, 36, 36, 20);
		frame.getContentPane().add(textPA15);
		
		textPA20 = new JTextField();
		textPA20.setEditable(false);
		textPA20.setText("9999");
		textPA20.setColumns(10);
		textPA20.setBounds(618, 36, 36, 20);
		frame.getContentPane().add(textPA20);
		
		JLabel lblLvl_4 = new JLabel("lvl 15");
		lblLvl_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl_4.setBounds(572, 11, 36, 14);
		frame.getContentPane().add(lblLvl_4);
		
		JLabel lblLvl_3 = new JLabel("lvl 20");
		lblLvl_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLvl_3.setBounds(618, 11, 36, 14);
		frame.getContentPane().add(lblLvl_3);
	}
	
	public JComboBox<String> getComboBoxPA() {
		return comboBoxPA;
	}
	public JSpinner getSpinnerPAa() {
		return spinnerPAa;
	}
	public JSpinner getSpinnerPAb() {
		return spinnerPAb;
	}
	public JSpinner getSpinnerPAc() {
		return spinnerPAc;
	}
	public JTextField getTextPA0() {
		return textPA0;
	}
	public JTextField getTextPA5() {
		return textPA5;
	}
	public JTextField getTextPA10() {
		return textPA10;
	}
	public JTextField getTextPA15() {
		return textPA15;
	}
	public JTextField getTextPA20() {
		return textPA20;
	}
}
