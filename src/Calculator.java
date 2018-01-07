import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Does the actual calculations
public class Calculator {
	
	/** @param data for the all pokemon, which includes their types
	 * adds a Pokemon's offensive type matchups to the data, classified into strong, normal, and weak matchups
	 */
	public static void addAttackData(Pokemon[] pokemonData) {
		Map<Type, Type[]> strongTypes = TypeMap.attackStrengths();
		Map<Type, Type[]> weakTypes = TypeMap.attackWeaknesses();
		Type[] typeList = TypeMap.typeList();
		int i;
		for (Pokemon pokemon : pokemonData) {
			if (pokemon.getType2() == Type.NONE) {
				Type[] strengths = strongTypes.get(pokemon.getType1());
				Type[] weaknesses = weakTypes.get(pokemon.getType1());
				Type[] normals = new Type[typeList.length];
				i = 0;
				for (Type type : typeList) {
					if (!Arrays.asList(weaknesses).contains(type) && !Arrays.asList(strengths).contains(type)) {
						normals[i] = type;
						i++;
					}
				}
				Type[] normalsTrim = Arrays.copyOf(normals, i);
				pokemon.addAttackStats(strengths, normalsTrim, weaknesses);
			}
			else {
				Type[] type1_strengths = strongTypes.get(pokemon.getType1());
				Type[] type2_strengths = strongTypes.get(pokemon.getType2());
				Type[] type1_weaknesses = weakTypes.get(pokemon.getType1());
				Type[] type2_weaknesses = weakTypes.get(pokemon.getType2());
				
				Type[] strengths = Arrays.copyOf(type1_strengths, type1_strengths.length + type2_strengths.length);
				i = type1_strengths.length;
				for (Type type : type2_strengths) {
					if (!Arrays.asList(strengths).contains(type)) {
						strengths[i] = type;
						i++;
					}
				}
				Type[] strengthsTrim = Arrays.copyOf(strengths, i);
				
				Type[] weaknesses = new Type[type1_weaknesses.length];
				i = 0;
				for (Type type : type1_weaknesses) {
					if (Arrays.asList(type2_weaknesses).contains(type)) {
						weaknesses[i] = type;
						i++;
					}
				}
				
				Type[] weaknessesTrim = Arrays.copyOf(weaknesses, i);
				
				Type[] normal = new Type[typeList.length];
				i = 0;
				for (Type type : typeList) {
					if (!Arrays.asList(strengths).contains(type) && !Arrays.asList(weaknesses).contains(type)) {
						normal[i] = type;
						i++;
					}
				}
				Type[] normalTrim = Arrays.copyOf(normal, i);
				
				pokemon.addAttackStats(strengthsTrim, normalTrim, weaknessesTrim);
			}
		}
	}
	
	/** @param the data for all pokemon
	 * combines offensive and defensive weaknesses of each pokemon into either good, bad, or average matchups
	 * adds the matchups to the dataset
	 */
	public static void addMatchups(Pokemon[] pokemonData) {
		
		for (Pokemon pokemon : pokemonData) {
			Type[] aStr = pokemon.getAttackStrengths();
			Type[] aNorm = pokemon.getAttackNormal();
			Type[] aWeak = pokemon.getAttackWeaknesses();
			List<Type> dStr = pokemon.getDefenseStrengths();
			List<Type> dNorm = pokemon.getDefenseNormal();
			List<Type> dWeak = pokemon.getDefenseWeaknesses();
			
			List<Type> goodMatchups = new ArrayList<Type>();
			List<Type> avgMatchups = new ArrayList<Type>();
			List<Type> badMatchups = new ArrayList<Type>();
			
			for (Type type : aStr) {
				if (!dWeak.isEmpty() && dWeak.contains(type))
					avgMatchups.add(type);
				else
					goodMatchups.add(type);
			}
			
			for (Type type : aNorm) {
				if (!dStr.isEmpty() && dStr.contains(type))
					goodMatchups.add(type);
				else if (!dNorm.isEmpty() && dNorm.contains(type) )
					avgMatchups.add(type);
				else
					badMatchups.add(type);
			}
			
			for (Type type : aWeak) {
				if (!dStr.isEmpty() && dStr.contains(type))
					avgMatchups.add(type);
				else
					badMatchups.add(type);
			}
			
			pokemon.addMatchups(goodMatchups, avgMatchups, badMatchups);
			
		}
	}
	
	/**
	 * Creates a convenient hashmap so I don't have to search the entire pokemonData array to match names
	 * @param pokemonData
	 * @return HashMap that maps a pokemon name to its respective index in pokemonData
	 */
	public static Map<String, Integer> nameToIndexHashMap(Pokemon[] pokemonData) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < pokemonData.length; i++) {
			map.put(pokemonData[i].getName(), i);
		}
		return map;
	}
	
	/**
	 * Takes a team's good and bad matchups, and assigns a score to each type. Higher scores indicate good matchups.
	 * @param pokemonNames
	 * @param pokemonData
	 * @param map : a hashmap where pokemon names are mapped to their index in pokemonData, returned by the nameToIndexHashMap function seen above
	 * @return a hashmap that maps a type to its score for a team
	 */
	public static Map<Type, Integer> teamMatchups(List<String> pokemonNames, Pokemon[] pokemonData, Map<String, Integer> map) {
		Map<Type, Integer> typeMatchups = new HashMap<Type, Integer>();
		for (Type t : Type.values())
			typeMatchups.put(t, 0);
		List<Type> goodMatchups = new ArrayList<Type>();
		List<Type> badMatchups = new ArrayList<Type>();
		for (String name : pokemonNames) {
			int index = map.get(name);
			goodMatchups.addAll(pokemonData[index].getGoodMatchups());
			badMatchups.addAll(pokemonData[index].getBadMatchups());
		}
		
		for (int i = 0; i < goodMatchups.size(); i++) {
			Type t = goodMatchups.get(i);
			int score = typeMatchups.get(t);
			typeMatchups.replace(t, score + 1);
		}
		
		for (int i = 0; i < badMatchups.size(); i++) {
			Type t = badMatchups.get(i);
			int score = typeMatchups.get(t);
			typeMatchups.replace(t, score - 1);
		}
		
		return typeMatchups;
	}
	
	/**
	 * 
	 * @param matchupData : the types and scores returned by teamMatchups above
	 * @param teamSize : size of the Pokemon team, between 1-6
	 * @param weaknessLevel : determines whether the function should return average matchups, minor weaknesses, or major weaknesses
	 * @return Types in string form that fall into average, minor, or major weaknesses. This is what gets printed to the user.
	 */
	public static String getMatchups(Map<Type, Integer> matchupData, int teamSize, Weakness weaknessLevel) {
		List<String> matchups = new ArrayList<String>();
		int weaknessThreshold = -1 * ((teamSize / 2) + (teamSize % 2));
		if (weaknessLevel == Weakness.AVERAGE) {
			for (int i = 0; i < Type.values().length - 1; i++) {
				Type t = Type.values()[i];
				if (matchupData.get(t) == 0) {
					matchups.add(t.toString());
				}
			}
		}
		else if (weaknessLevel == Weakness.MINOR) {
			for (int i = 0; i < Type.values().length - 1; i++) {
				Type t = Type.values()[i];
				if (matchupData.get(t) > weaknessThreshold && matchupData.get(t) < 0) {
					matchups.add(t.toString());
				}
			}
		}
		else {
			for (int i = 0; i < Type.values().length - 1; i++) {
				Type t = Type.values()[i];
				if (matchupData.get(t) <= weaknessThreshold) {
					matchups.add(t.toString());
				}
			}
		}
		String results = "";
		for (int i = 0; i < matchups.size(); i++) {
			results = results.concat(matchups.get(i).concat("\n"));
		}
		return results;
	}
}
