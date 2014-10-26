import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Start extends JPanel implements PropertyChangeListener, ActionListener {

	/**
	 * Všechna práva vyhrazena! Email: mar00m@seznam.cz
	 * 
	 * Version History: - V1.1 - Opraven 'bug', pøi kterém došlo k pøeplnìní výsledné Hmotnosti - V1.2 - Zmìnìn název aplikace - V1.3 - Pøidány nové
	 * cenové funkce pro pøepoèet ceny za kg - V1.4 - Pøidány pøepínací tlaèítka pro zmìnu poèítané hodnoty - V1.5 - Pøidány funkce k výpoètùm - nyní
	 * jsou možné vícesmìrné kalkulace - V1.6 - Pøidány vícesmìrné pøepoèty ceny (celková cena, cena za kg a cena z arc) - V1.7 - Upravena cena za
	 * arch na cenu za tisíc archù - V1.7 - Pøidán testovací výbìr jednotky - V1.8 - Doplnìny základní jednotky pro první (p) fázi - V1.9 - Pøidán
	 * zbytek jednotek a staré doupraveny - V2.0 - Dodìláno euro > Save a Load + Automatické naètení, pøi zapnutí programu - V2.1 - Pøidány hlášky k
	 * errorùm
	 */

	private static final long serialVersionUID = 1L;

	public static JTable table;

	public static JTextField in1;
	public static JTextField in2;
	public static JTextField in3;
	public static JTextField in4;
	public static JTextField in5;
	public static JTextField in6;
	public static JTextField in7;
	public static JTextField in8;
	public static JTextField in9;

	public static JRadioButton m1;
	public static JRadioButton m2;
	public static JRadioButton m3;
	public static JRadioButton m4;
	public static JRadioButton m5;
	public static ButtonGroup group;

	public static JRadioButton m6;
	public static JRadioButton m7;
	public static JRadioButton m8;
	public static ButtonGroup value;

	public static JComboBox<?> j1;
	public static JComboBox<?> j2;
	// public static JComboBox<?> j3;
	public static JComboBox<?> j4;
	public static JComboBox<?> j5;
	public static JComboBox<?> j6;
	public static JComboBox<?> j7;
	public static JComboBox<?> j8;

	public static JButton b1;
	public static JButton b2;

	// Counting mode selector
	public static Integer p_mode = 5;
	public static Integer v_mode = 1;

	// Rounding modifiers 10^NUM
	public static Double v_round = 1000.0;
	public static Double p_round = 1000.0;

	public Start() {// TODO

		this.setFocusable(false);

		this.add(setupP1(), BorderLayout.CENTER);
	}

	public void fieldDoc(JTextField f) {
		f.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				update();
			}

			public void removeUpdate(DocumentEvent e) {
				update();
			}

			public void insertUpdate(DocumentEvent e) {
				update();
			}
		});
	}

	public JPanel setupP1() { // TODO
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		in1 = new JTextField();
		in1.setText(null);
		fieldDoc(in1);
		in1.setColumns(6);
		JLabel lb1 = new JLabel("Délka:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 0;
		lb1.setFont(getFont().deriveFont(18.0f));
		pane.add(lb1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 0;
		in1.setFont(getFont().deriveFont(16.0f));
		pane.add(in1, c);
		j1 = new JComboBox<Object>(new String[] { "cm", "dm", "m" });
		j1.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 0;
		j1.setFont(getFont().deriveFont(18.0f));
		pane.add(j1, c);

		in2 = new JTextField();
		in2.setText(null);
		fieldDoc(in2);
		in2.setColumns(6);
		JLabel lb2 = new JLabel("Šíøka:");
		c.fill = GridBagConstraints.HORIZONTAL;
		lb2.setFont(getFont().deriveFont(18.0f));
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 1;
		in2.setFont(getFont().deriveFont(16.0f));
		pane.add(lb2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(in2, c);
		j2 = new JComboBox<Object>(new String[] { "cm", "dm", "m" });
		j2.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 1;
		j2.setFont(getFont().deriveFont(18.0f));
		pane.add(j2, c);

		in3 = new JTextField();
		in3.setText(null);
		fieldDoc(in3);
		in3.setColumns(6);
		JLabel lb3 = new JLabel("Gramáž:");
		lb3.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(lb3, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 2;
		in3.setFont(getFont().deriveFont(16.0f));
		pane.add(in3, c);
		JLabel s1lb3 = new JLabel("g/m2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 2;
		s1lb3.setFont(getFont().deriveFont(18.0f));
		pane.add(s1lb3, c);

		in4 = new JTextField();
		in4.setText(null);
		fieldDoc(in4);
		in4.setColumns(10);
		JLabel lb4 = new JLabel("Kusy:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 3;
		lb4.setFont(getFont().deriveFont(18.0f));
		pane.add(lb4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 3;
		in4.setFont(getFont().deriveFont(16.0f));
		pane.add(in4, c);
		j4 = new JComboBox<Object>(new String[] { "Arc", "kArc" });
		j4.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 3;
		j4.setFont(getFont().deriveFont(18.0f));
		pane.add(j4, c);

		in5 = new JTextField();
		in5.setColumns(10);
		in5.setText(null);
		fieldDoc(in5);
		JLabel lb5 = new JLabel("Hmotnost: ");
		lb5.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(lb5, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 4;
		in5.setFont(getFont().deriveFont(16.0f));
		pane.add(in5, c);
		j5 = new JComboBox<Object>(new String[] { "kg", "t" });
		j5.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 4;
		j5.setFont(getFont().deriveFont(18.0f));
		pane.add(j5, c);

		in6 = new JTextField();
		in6.setColumns(10);
		in6.setText(null);
		fieldDoc(in6);
		JLabel lb6 = new JLabel("Cena: ");
		lb6.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(lb6, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 5;
		in6.setFont(getFont().deriveFont(16.0f));
		pane.add(in6, c);
		j6 = new JComboBox<Object>(new String[] { "CZK/kg", "CZK/t", "EUR/kg", "EUR/t" });
		j6.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 5;
		j6.setFont(getFont().deriveFont(18.0f));
		pane.add(j6, c);

		in7 = new JTextField();
		in7.setColumns(10);
		in7.setEditable(false);
		in7.setText(null);
		fieldDoc(in7);
		JLabel lb7 = new JLabel("Cena:");
		lb7.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 6;
		pane.add(lb7, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 6;
		in7.setFont(getFont().deriveFont(16.0f));
		pane.add(in7, c);
		j7 = new JComboBox<Object>(new String[] { "CZK/Arc", "CZK/kArc", "EUR/Arc", "EUR/kArc" });
		j7.setSelectedIndex(1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 6;
		j7.setFont(getFont().deriveFont(18.0f));
		pane.add(j7, c);

		in8 = new JTextField();
		in8.setEditable(false);
		in8.setColumns(10);
		fieldDoc(in8);
		JLabel lb8 = new JLabel("Cena:");
		lb8.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 7;
		pane.add(lb8, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 7;
		in8.setFont(getFont().deriveFont(16.0f));
		pane.add(in8, c);
		j8 = new JComboBox<Object>(new String[] { "CZK", "EUR" });
		j8.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 7;
		j8.setFont(getFont().deriveFont(18.0f));
		pane.add(j8, c);

		in9 = new JTextField();
		in9.setColumns(10);
		fieldDoc(in9);
		JLabel lb9 = new JLabel("Kurz: ");
		lb9.setFont(getFont().deriveFont(18.0f));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 0;
		c.gridy = 8;
		pane.add(lb9, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 1;
		c.gridy = 8;
		in9.setFont(getFont().deriveFont(16.0f));
		pane.add(in9, c);

		JPanel subp = new JPanel();
		subp.setLayout(new BorderLayout(0, 0));

		b1 = new JButton("Load");
		b1.setFont(getFont().deriveFont(11.0f));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String euroread = new String(Files.readAllBytes(Paths.get("eurofile.txt")));
					in9.setText(euroread);
				} catch (Exception j) {
					System.err.println("[System] " + j.getLocalizedMessage());
					JOptionPane.showMessageDialog(null,
							"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + j.getMessage()
									+ "\nHashCode: " + j.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		subp.add(b1, BorderLayout.EAST);

		b2 = new JButton("Save");
		b2.setFont(getFont().deriveFont(11.0f));// UNDONE
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter w = new BufferedWriter(new FileWriter("eurofile.txt"));
					w.write(in9.getText());
					w.close();
				} catch (Exception k) {
					System.err.println("[System] " + k.getLocalizedMessage());
					JOptionPane.showMessageDialog(null,
							"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + k.getMessage()
									+ "\nHashCode: " + k.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		subp.add(b2, BorderLayout.WEST);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 2;
		c.gridy = 8;
		pane.add(subp, c);

		m1 = new JRadioButton();
		m1.setActionCommand("1");
		m2 = new JRadioButton();
		m2.setActionCommand("2");
		m3 = new JRadioButton();
		m3.setActionCommand("3");
		m4 = new JRadioButton();
		m4.setActionCommand("4");
		m5 = new JRadioButton();
		m5.setActionCommand("5");
		m5.setSelected(true);

		m6 = new JRadioButton();
		m6.setActionCommand("6");
		m6.setSelected(true);
		m7 = new JRadioButton();
		m7.setActionCommand("7");
		m8 = new JRadioButton();
		m8.setActionCommand("8");

		group = new ButtonGroup();
		group.add(m1);
		group.add(m2);
		group.add(m3);
		group.add(m4);
		group.add(m5);

		value = new ButtonGroup();
		value.add(m6);
		value.add(m7);
		value.add(m8);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 0;
		pane.add(m1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 1;
		pane.add(m2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 2;
		pane.add(m3, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 3;
		pane.add(m4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 4;
		pane.add(m5, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 5;
		pane.add(m6, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 6;
		pane.add(m7, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 15;
		c.gridx = 3;
		c.gridy = 7;
		pane.add(m8, c);

		m1.addActionListener((ActionListener) this);
		m2.addActionListener((ActionListener) this);
		m3.addActionListener((ActionListener) this);
		m4.addActionListener((ActionListener) this);
		m5.addActionListener((ActionListener) this);
		m6.addActionListener((ActionListener) this);
		m7.addActionListener((ActionListener) this);
		m8.addActionListener((ActionListener) this);

		j1.addActionListener(this);
		j1.setActionCommand("11");
		j2.addActionListener(this);
		j2.setActionCommand("12");
		// j3.addActionListener(this);
		// j3.setActionCommand("13");
		j4.addActionListener(this);
		j4.setActionCommand("14");
		j5.addActionListener(this);
		j5.setActionCommand("15");
		j6.addActionListener(this);
		j6.setActionCommand("16");
		j7.addActionListener(this);
		j7.setActionCommand("17");
		j8.addActionListener(this);
		j8.setActionCommand("18");

		in5.setEditable(false);

		// Automatic LOAD
		try {
			String euroread = new String(Files.readAllBytes(Paths.get("eurofile.txt")));
			in9.setText(euroread);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + e.getMessage()
							+ "\nHashCode: " + e.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
		}

		update();

		return pane;
	}

	public static void main(String[] args) {// TODO
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setupGui();
			}
		});
	}

	public static void setupGui() {// TODO
		// Create and setup frame
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + ex.getMessage()
							+ "\nHashCode: " + ex.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
		}
		JFrame Frame = new JFrame("Papírová kalkulaèka | CC-NY-NC-ND by Hafis_CZ");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setResizable(false);
		// Create and setup content page SIZE(800*500)
		Start Content = new Start();
		Content.setOpaque(true);
		Frame.setContentPane(Content);
		// Display the Window
		Frame.pack();
		// Frame.setSize(800, 500);
		Frame.setVisible(true);
		System.out.println("[System] " + Frame.getSize());
	}

	public void update()// TODO
	{
		Double buffer;

		if (v_mode.equals(1)) {
			try {
				buffer = (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex()));
				buffer *= Double.parseDouble(in6.getText().replace(",", "."));
				if (j6.getSelectedIndex() == 2 || j6.getSelectedIndex() == 3) buffer *= Double.parseDouble(in9.getText().replace(",", "."));
				if (j6.getSelectedIndex() == 1 || j6.getSelectedIndex() == 3) buffer /= 1000;
				if (j8.getSelectedIndex() == 1) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				buffer = Math.round(buffer * v_round) / v_round;
				in8.setText(buffer.toString().replace(".", ","));

				buffer = (Double.parseDouble(in8.getText().replace(",", ".")) * (Math.pow(Double.parseDouble(in9.getText().replace(",", ".")),
						j8.getSelectedIndex())))
						/ (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()) / 1000);
				if (j7.getSelectedIndex() == 2 || j7.getSelectedIndex() == 3) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				if (j7.getSelectedIndex() == 0 || j7.getSelectedIndex() == 2) buffer /= 1000;
				buffer = Math.round(buffer * v_round) / v_round;
				in7.setText(buffer.toString().replace(".", ","));
			} catch (Exception e) {
			}
		}

		else if (v_mode.equals(2)) {
			try {
				buffer = (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()));
				buffer *= (Double.parseDouble(in7.getText().replace(",", ".")));
				if (j7.getSelectedIndex() == 2 || j7.getSelectedIndex() == 3) buffer *= Double.parseDouble(in9.getText().replace(",", "."));
				if (j7.getSelectedIndex() == 1 || j7.getSelectedIndex() == 3) buffer /= 1000;
				if (j8.getSelectedIndex() == 1) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				buffer = Math.round(buffer * v_round) / v_round;
				in8.setText(buffer.toString().replace(".", ","));

				buffer = (Double.parseDouble(in8.getText().replace(",", ".")) * (Math.pow(Double.parseDouble(in9.getText().replace(",", ".")),
						j8.getSelectedIndex())))
						/ (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex()));
				if (j6.getSelectedIndex() == 2 || j6.getSelectedIndex() == 3) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				if (j6.getSelectedIndex() == 1 || j6.getSelectedIndex() == 3) buffer /= 1000;
				buffer = Math.round(buffer * v_round) / v_round;
				in6.setText(buffer.toString().replace(".", ","));
			} catch (Exception e) {
			}
		}

		else if (v_mode.equals(3)) {
			try {
				buffer = (Double.parseDouble(in8.getText().replace(",", ".")) * (Math.pow(Double.parseDouble(in9.getText().replace(",", ".")),
						j8.getSelectedIndex())))
						/ (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()) / 1000);
				if (j7.getSelectedIndex() == 2 || j7.getSelectedIndex() == 3) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				if (j7.getSelectedIndex() == 0 || j7.getSelectedIndex() == 2) buffer /= 1000;
				buffer = Math.round(buffer * v_round) / v_round;
				in7.setText(buffer.toString().replace(".", ","));

				buffer = (Double.parseDouble(in8.getText().replace(",", ".")) * (Math.pow(Double.parseDouble(in9.getText().replace(",", ".")),
						j8.getSelectedIndex())))
						/ (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex()));
				if (j6.getSelectedIndex() == 2 || j6.getSelectedIndex() == 3) buffer /= Double.parseDouble(in9.getText().replace(",", "."));
				if (j6.getSelectedIndex() == 1 || j6.getSelectedIndex() == 3) buffer /= 1000;
				buffer = Math.round(buffer * v_round) / v_round;
				in6.setText(buffer.toString().replace(".", ","));
			} catch (Exception e) {
			}
		}

		if (p_mode.equals(1)) {
			try {
				if (in2.getText() != null && in3.getText() != null && in4.getText() != null) {
					buffer = (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex())) * 10000000;
					buffer /= (Double.parseDouble(in2.getText().replace(",", ".")) * Math.pow(10, j2.getSelectedIndex()))
							* Double.parseDouble(in3.getText().replace(",", "."));
					buffer /= (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()));
					buffer /= Math.pow(10, j1.getSelectedIndex());
					buffer = Math.round(buffer * p_round) / p_round;
					in1.setText(buffer.toString().replace(".", ","));
				}
			} catch (Exception e) {
			}
		}

		else if (p_mode.equals(2)) {// IDK ERROR
			try {
				if (in1.getText() != null && in3.getText() != null && in4.getText() != null) {
					buffer = (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex())) * 10000000;
					buffer /= (Double.parseDouble(in1.getText().replace(",", ".")) * Math.pow(10, j1.getSelectedIndex()))
							* Double.parseDouble(in3.getText().replace(",", "."))
							* (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()));
					buffer /= Math.pow(10, j2.getSelectedIndex());
					buffer = Math.round(buffer * p_round) / p_round;
					in2.setText(buffer.toString().replace(".", ","));
				}
			} catch (Exception e) {
			}
		}

		else if (p_mode.equals(3)) {// IDK ERROR
			try {
				if (in2.getText() != null && in1.getText() != null && in4.getText() != null) {
					buffer = (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex())) * 10000000;
					buffer /= (Double.parseDouble(in2.getText().replace(",", ".")) * Math.pow(10, j2.getSelectedIndex()))
							* (Double.parseDouble(in1.getText().replace(",", ".")) * Math.pow(10, j1.getSelectedIndex()))
							* (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex()));
					buffer = Math.round(buffer * p_round) / p_round;
					in3.setText(buffer.toString().replace(".", ","));
				}
			} catch (Exception e) {
			}
		}

		else if (p_mode.equals(4)) {
			try {
				if (in1.getText() != null && in2.getText() != null && in3.getText() != null) {
					buffer = (Double.parseDouble(in5.getText().replace(",", ".")) * Math.pow(1000, j5.getSelectedIndex())) * 10000;
					buffer /= (Double.parseDouble(in1.getText().replace(",", ".")) * Math.pow(10, j1.getSelectedIndex()))
							* (Double.parseDouble(in2.getText().replace(",", ".")) * Math.pow(10, j2.getSelectedIndex()))
							* Double.parseDouble(in3.getText().replace(",", "."));
					buffer *= 1000 / Math.pow(1000, j4.getSelectedIndex());
					buffer = Math.round(buffer * p_round) / p_round;
					in4.setText(buffer.toString().replace(".", ","));
				}
			} catch (Exception e) {
			}
		}

		else if (p_mode.equals(5)) {
			try {
				buffer = (Double.parseDouble(in1.getText().replace(",", ".")) * Math.pow(10, j1.getSelectedIndex()))
						* (Double.parseDouble(in2.getText().replace(",", ".")) * Math.pow(10, j2.getSelectedIndex()))
						* Double.parseDouble(in3.getText().replace(",", "."));
				buffer /= 10000;
				buffer *= (Double.parseDouble(in4.getText().replace(",", ".")) * Math.pow(1000, j4.getSelectedIndex())) / 1000;
				buffer /= Math.pow(1000, j5.getSelectedIndex());
				buffer = Math.round(buffer * p_round) / p_round;
				in5.setText(buffer.toString().replace(".", ","));
			} catch (Exception e) {
			}
		}
	}

	public void erase() {
		try {
			in1.setText(null);
			in1.setEditable(true);
			in2.setText(null);
			in2.setEditable(true);
			in3.setText(null);
			in3.setEditable(true);
			in4.setText(null);
			in4.setEditable(true);
			in5.setText(null);
			in5.setEditable(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + e.getMessage()
							+ "\nHashCode: " + e.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void v_erase() {
		try {
			in6.setText(null);
			in6.setEditable(true);
			in7.setText(null);
			in7.setEditable(true);
			in8.setText(null);
			in8.setEditable(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"There was an unknown problem here, please wait for a correction or contact the developer.\nError ID: " + e.getMessage()
							+ "\nHashCode: " + e.hashCode(), "Sorry !", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent e) {
		Integer mode = Integer.parseInt(e.getActionCommand());
		if (mode <= 5) {
			erase();
			if (mode.equals(1)) {
				p_mode = 1;
				in1.setEditable(false);
			}
			if (mode.equals(2)) {
				p_mode = 2;
				in2.setEditable(false);
			}
			if (mode.equals(3)) {
				p_mode = 3;
				in3.setEditable(false);
			}
			if (mode.equals(4)) {
				p_mode = 4;
				in4.setEditable(false);
			}
			if (mode.equals(5)) {
				p_mode = 5;
				in5.setEditable(false);
			}
		} else if (mode > 5 && mode <= 8) {
			v_erase();
			v_erase();
			if (mode.equals(6)) {
				v_mode = 1;
				in7.setEditable(false);
				in8.setEditable(false);
			}
			if (mode.equals(7)) {
				v_mode = 2;
				in6.setEditable(false);
				in8.setEditable(false);
			}
			if (mode.equals(8)) {
				v_mode = 3;
				in6.setEditable(false);
				in7.setEditable(false);
			}
		}
		update();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}
}