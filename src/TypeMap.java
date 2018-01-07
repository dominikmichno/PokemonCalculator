import java.util.HashMap;
import java.util.Map;

// Functions that have to do with types
public class TypeMap {
	
	/**
	 * @return List of types without the "NONE" type
	 */
	public static Type[] typeList() {
		Type[] types = {Type.NORMAL, Type.FIGHTING, Type.FLYING, Type.POISON, Type.GROUND,
				Type.ROCK, Type.BUG, Type.GHOST, Type.STEEL, Type.FIRE, Type.WATER, Type.GRASS,
				Type.ELECTRIC, Type.PSYCHIC, Type.ICE, Type.DRAGON, Type.DARK, Type.FAIRY};
		return types;
	}
	
	/**
	 * @return HashMap that maps a type to an array of types that it is supereffective against
	 */
	public static Map<Type, Type[]> attackStrengths() {
		Map<Type, Type[]> map = new HashMap<Type, Type[]>();
		
		Type[] normal = {};
		Type[] fighting = {Type.NORMAL, Type.ROCK, Type.STEEL, Type.ICE, Type.FAIRY};
		Type[] flying = {Type.FIGHTING, Type.BUG, Type.GRASS};
		Type[] poison = {Type.GRASS, Type.FAIRY};
		Type[] ground = {Type.POISON, Type.ROCK, Type.STEEL, Type.FIRE, Type.ELECTRIC};
		Type[] rock = {Type.FLYING, Type.BUG, Type.FIRE, Type.ICE};
		Type[] bug = {Type.GRASS, Type.PSYCHIC, Type.DARK};
		Type[] ghost = {Type.GHOST, Type.PSYCHIC};
		Type[] steel = {Type.ROCK, Type.ICE, Type.FAIRY};
		Type[] fire = {Type.BUG, Type.STEEL, Type.GRASS, Type.ICE};
		Type[] water = {Type.GROUND, Type.ROCK, Type.FIRE};
		Type[] grass = {Type.GROUND, Type.ROCK, Type.WATER};
		Type[] electric = {Type.FLYING, Type.WATER};
		Type[] psychic = {Type.FIGHTING, Type.POISON};
		Type[] ice = {Type.FLYING, Type.GROUND, Type.GRASS, Type.DRAGON};
		Type[] dragon = {Type.DRAGON};
		Type[] dark = {Type.GHOST, Type.PSYCHIC};
		Type[] fairy = {Type.FIGHTING, Type.DRAGON, Type.DARK};
		
		map.put(Type.NORMAL, normal);
		map.put(Type.FIGHTING, fighting);
		map.put(Type.FLYING, flying);
		map.put(Type.POISON, poison);
		map.put(Type.GROUND, ground);
		map.put(Type.ROCK, rock);
		map.put(Type.BUG, bug);
		map.put(Type.GHOST, ghost);
		map.put(Type.STEEL, steel);
		map.put(Type.FIRE, fire);
		map.put(Type.WATER, water);
		map.put(Type.GRASS, grass);
		map.put(Type.ELECTRIC, electric);
		map.put(Type.PSYCHIC, psychic);
		map.put(Type.ICE, ice);
		map.put(Type.DRAGON, dragon);
		map.put(Type.DARK, dark);
		map.put(Type.FAIRY, fairy);
		
		return map;
	}
	
	/**
	 * @return HashMap that maps a type to an array of types it is not very effective or ineffective against
	 */
	public static Map<Type, Type[]> attackWeaknesses() {
		Map<Type, Type[]> map = new HashMap<Type, Type[]>();
		
		Type[] normal = {Type.ROCK, Type.GHOST, Type.STEEL};
		Type[] fighting = {Type.FLYING, Type.POISON, Type.BUG, Type.GHOST, Type.PSYCHIC, Type.FAIRY};
		Type[] flying = {Type.ROCK, Type.STEEL, Type.ELECTRIC};
		Type[] poison = {Type.POISON, Type.GROUND, Type.ROCK, Type.GHOST, Type.STEEL};
		Type[] ground = {Type.FLYING, Type.BUG, Type.GRASS};
		Type[] rock = {Type.FIGHTING, Type.GROUND, Type.STEEL};
		Type[] bug = {Type.FIGHTING, Type.FLYING, Type.POISON, Type.GHOST, Type.STEEL, Type.FIRE, Type.FAIRY};
		Type[] ghost = {Type.NORMAL, Type.DARK};
		Type[] steel = {Type.STEEL, Type.FIRE, Type.WATER, Type.ELECTRIC};
		Type[] fire = {Type.ROCK, Type.FIRE, Type.WATER, Type.DRAGON};
		Type[] water = {Type.WATER, Type.GRASS, Type.DRAGON};
		Type[] grass = {Type.FLYING, Type.POISON, Type.BUG, Type.STEEL, Type.FIRE, Type.GRASS, Type.DRAGON};
		Type[] electric = {Type.GROUND, Type.GRASS, Type.ELECTRIC, Type.DRAGON};
		Type[] psychic = {Type.STEEL, Type.PSYCHIC, Type.DARK};
		Type[] ice = {Type.STEEL, Type.FIRE, Type.WATER, Type.ICE};
		Type[] dragon = {Type.STEEL, Type.FAIRY};
		Type[] dark = {Type.FIGHTING, Type.DARK, Type.FAIRY};
		Type[] fairy = {Type.POISON, Type.STEEL, Type.FIRE};
		
		map.put(Type.NORMAL, normal);
		map.put(Type.FIGHTING, fighting);
		map.put(Type.FLYING, flying);
		map.put(Type.POISON, poison);
		map.put(Type.GROUND, ground);
		map.put(Type.ROCK, rock);
		map.put(Type.BUG, bug);
		map.put(Type.GHOST, ghost);
		map.put(Type.STEEL, steel);
		map.put(Type.FIRE, fire);
		map.put(Type.WATER, water);
		map.put(Type.GRASS, grass);
		map.put(Type.ELECTRIC, electric);
		map.put(Type.PSYCHIC, psychic);
		map.put(Type.ICE, ice);
		map.put(Type.DRAGON, dragon);
		map.put(Type.DARK, dark);
		map.put(Type.FAIRY, fairy);
		
		return map;
	}
}
