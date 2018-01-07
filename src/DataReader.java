import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/** @author Dominik Michno
 * @version 1.0
 * Last Updated: 01/07/18
 * 
 * This is a calculator that takes in a team of Pokemon and finds their type weaknesses.
 * It does not take into account movesets or abilities, it only uses the Pokemon's type.
 * Major weaknesses indicate a change is needed in your roster.
 * Minor weaknesses indicate that you need specific coverage moves or a change in your roster.
 * Average matchups indicate what your team is balanced against as a whole. Good for choosing extra coverage moves. 
 * I will need to eventually update this for the new pokemon in Ultra Sun/Moon.
 */

// Reads Pokemon data from a csv file and turns it into a usable format before opening the application window
public class DataReader {

	public static void main(String[] args) {
		// csv file source: https://www.kaggle.com/rounakbanik/pokemon
		String csvFile = "data\\pokemon.csv";
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		String[] parsedLine;
		int lineNumber = 0;
		int nameLine = 29;
		int type1Line = 35;
		int type2Line = 36;
		
		// There are 801 pokemon, but pokemonNames needs an extra empty string for the blank comboBox option
		String[] pokemonNames = new String[802];
		Pokemon[] pokemonData = new Pokemon[801];
		String name;
		Type type1;
		Type type2;
		
		pokemonNames[801] = " ";
		
		/* Reads the csv file and fills arrays for pokemon names and data
		 * Source: https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
		 */
		try {
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			String[] columnTitles = line.split(splitter);
			while ((line = br.readLine()) != null) {
				parsedLine = line.split(splitter);
				name = parsedLine[nameLine];
				if (parsedLine[type1Line].equals(""))
					throw new Exception("At least one type is required");
				else
					type1 = Type.valueOf(parsedLine[type1Line].toUpperCase());
				if (parsedLine[type2Line].equals(""))
					type2 = Type.NONE;
				else
					type2 = Type.valueOf(parsedLine[type2Line].toUpperCase());
				List<Type> defStrengths = new ArrayList<Type>();
				List<Type> defWeaknesses = new ArrayList<Type>();
				List<Type> defNormal = new ArrayList<Type>();
				
				// Defensive type matchups are conveniently included in the data, so I grab it here
				for (int i = 0; i < 18; i++) {
					if (parsedLine[i].equals("2") || parsedLine[i].equals("4"))
						defWeaknesses.add(Type.valueOf(columnTitles[i].substring(8).toUpperCase()));
					else if (parsedLine[i].equals("0.25") || parsedLine[i].equals("0.5") || parsedLine[i].equals("0"))
						defStrengths.add(Type.valueOf(columnTitles[i].substring(8).toUpperCase()));
					else
						defNormal.add(Type.valueOf(columnTitles[i].substring(8).toUpperCase()));
				}
				Pokemon pokemon = new Pokemon(name, type1, type2, defStrengths, defWeaknesses, defNormal);
				pokemonData[lineNumber] = pokemon;
				pokemonNames[lineNumber] = name;
				lineNumber++;
			}
			Arrays.sort(pokemonNames);
			Calculator.addAttackData(pokemonData);
			Calculator.addMatchups(pokemonData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Opens the window
		CalcWindow.main(pokemonData, pokemonNames);
		
		
	}
}
