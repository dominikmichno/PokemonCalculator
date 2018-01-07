import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

/* Handles the application window
 * Useful guides I used as a starting point: https://www.youtube.com/watch?v=r8Qiz9Bn1Ag
 */
public class CalcWindow {

	private JFrame frame;
	private Pokemon[] pokemonData;
	private String[] pokemonNames;
	
	

	/*
	 * Launch the application.
	 */
	public static void main(Pokemon[] data, String[] names) {
		// Gives the window the look and style of the system, as opposed to the default (and ugly) java style
		 try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }

		// Creates a new thread to run the window on
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcWindow window = new CalcWindow(data, names);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public CalcWindow(Pokemon[] data, String[] names) {
		this.pokemonData = data;
		this.pokemonNames = names;
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 827, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pkmnPanel1 = new JPanel();
		pkmnPanel1.setBounds(10, 96, 187, 41);
		frame.getContentPane().add(pkmnPanel1);
		
		JLabel lblPokemon1 = new JLabel("Pok\u00E9mon 1");
		pkmnPanel1.add(lblPokemon1);
		lblPokemon1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox comboBox1 = new JComboBox(this.pokemonNames);
		pkmnPanel1.add(comboBox1);
		
		JPanel pkmnPanel2 = new JPanel();
		pkmnPanel2.setBounds(10, 148, 187, 41);
		frame.getContentPane().add(pkmnPanel2);
		
		JLabel lblPokemon2 = new JLabel("Pok\u00E9mon 2");
		lblPokemon2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pkmnPanel2.add(lblPokemon2);
		
		JComboBox comboBox2 = new JComboBox(this.pokemonNames);
		pkmnPanel2.add(comboBox2);
		
		JPanel pkmnPanel3 = new JPanel();
		pkmnPanel3.setBounds(10, 200, 187, 41);
		frame.getContentPane().add(pkmnPanel3);
		
		JLabel lblPokemon3 = new JLabel("Pok\u00E9mon 3");
		lblPokemon3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pkmnPanel3.add(lblPokemon3);
		
		JComboBox comboBox3 = new JComboBox(this.pokemonNames);
		pkmnPanel3.add(comboBox3);
		
		JPanel pkmnPanel4 = new JPanel();
		pkmnPanel4.setBounds(10, 252, 187, 41);
		frame.getContentPane().add(pkmnPanel4);
		
		JLabel lblPokemon4 = new JLabel("Pok\u00E9mon 4");
		lblPokemon4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pkmnPanel4.add(lblPokemon4);
		
		JComboBox comboBox4 = new JComboBox(this.pokemonNames);
		pkmnPanel4.add(comboBox4);
		
		JPanel pkmnPanel5 = new JPanel();
		pkmnPanel5.setBounds(10, 304, 187, 41);
		frame.getContentPane().add(pkmnPanel5);
		
		JLabel lblPokemon5 = new JLabel("Pok\u00E9mon 5");
		lblPokemon5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pkmnPanel5.add(lblPokemon5);
		
		JComboBox comboBox5 = new JComboBox(this.pokemonNames);
		pkmnPanel5.add(comboBox5);
		
		JPanel pkmnPanel6 = new JPanel();
		pkmnPanel6.setBounds(10, 356, 187, 41);
		frame.getContentPane().add(pkmnPanel6);
		
		JLabel lblPokemon6 = new JLabel("Pok\u00E9mon 6");
		lblPokemon6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pkmnPanel6.add(lblPokemon6);
		
		JComboBox comboBox6 = new JComboBox(this.pokemonNames);
		pkmnPanel6.add(comboBox6);
		
		JLabel lblTitle = new JLabel("Pok\u00E9mon Team Weakness Calculator");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(0, 11, 811, 41);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblMinor = new JLabel("Minor Weaknesses");
		lblMinor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinor.setBounds(508, 80, 115, 23);
		frame.getContentPane().add(lblMinor);
		
		JLabel lblMajor = new JLabel("Major Weaknesses");
		lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMajor.setBounds(653, 80, 115, 23);
		frame.getContentPane().add(lblMajor);
		
		JLabel lblAvg = new JLabel("Average Matchups");
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAvg.setBounds(362, 80, 115, 23);
		frame.getContentPane().add(lblAvg);
		
		JTextPane txtMinor = new JTextPane();
		txtMinor.setEditable(false);
		txtMinor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMinor.setBounds(508, 114, 115, 283);
		frame.getContentPane().add(txtMinor);
		
		JTextPane txtMajor = new JTextPane();
		txtMajor.setEditable(false);
		txtMajor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMajor.setBounds(653, 115, 115, 282);
		frame.getContentPane().add(txtMajor);
		
		JTextPane txtAvg = new JTextPane();
		txtAvg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAvg.setEditable(false);
		txtAvg.setBounds(362, 114, 115, 283);
		frame.getContentPane().add(txtAvg);
		
		/* Grabs the input from the window, passes it to the calculator, then prints it
		 * If no input is given, it shows an error message instead
		 */
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validEntry = false;
				String[] selectedPokemon = new String[6];
				List<String> validPokemon = new ArrayList<String>();
				selectedPokemon[0] = (String)comboBox1.getSelectedItem();
				selectedPokemon[1] = (String)comboBox2.getSelectedItem();
				selectedPokemon[2] = (String)comboBox3.getSelectedItem();
				selectedPokemon[3] = (String)comboBox4.getSelectedItem();
				selectedPokemon[4] = (String)comboBox5.getSelectedItem();
				selectedPokemon[5] = (String)comboBox6.getSelectedItem();
				
				for (String pokemon : selectedPokemon) {
					if (!pokemon.equals(" ")) {
						validPokemon.add(pokemon);
						validEntry = true;
					}
				}
				
				if (!validEntry) {
					JOptionPane.showMessageDialog(frame,
	                        "Choose at least one Pokémon");
				}
				
				else {
					int teamSize = validPokemon.size();
					Map<Type, Integer> matchupData = Calculator.teamMatchups(validPokemon, pokemonData, Calculator.nameToIndexHashMap(pokemonData));
					String avgTextOutput = Calculator.getMatchups(matchupData, teamSize, Weakness.AVERAGE);
					String minorTextOutput = Calculator.getMatchups(matchupData, teamSize, Weakness.MINOR);
					String majorTextOutput = Calculator.getMatchups(matchupData, teamSize, Weakness.MAJOR);
					
					txtAvg.setText(avgTextOutput);
					txtMinor.setText(minorTextOutput);
					txtMajor.setText(majorTextOutput);
					
					
				}
			}
		});
		btnCalc.setBounds(233, 218, 89, 23);
		frame.getContentPane().add(btnCalc);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox1.setSelectedIndex(0);
				comboBox2.setSelectedIndex(0);
				comboBox3.setSelectedIndex(0);
				comboBox4.setSelectedIndex(0);
				comboBox5.setSelectedIndex(0);
				comboBox6.setSelectedIndex(0);
				txtAvg.setText(null);
				txtMinor.setText(null);
				txtMajor.setText(null);
			}
		});
		btnReset.setBounds(233, 252, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}
