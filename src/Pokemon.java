import java.util.List;

// Pokemon class for storing data
public class Pokemon {
	private String name;
	private Type type1;
	private Type type2;
	private Type[] atkStrengths;
	private Type[] atkWeaknesses;
	private Type[] atkNormal;
	private List<Type> defStrengths;
	private List<Type> defWeaknesses;
	private List<Type> defNormal;
	private List<Type> goodMatchups;
	private List<Type> avgMatchups;
	private List<Type> badMatchups;
	
	public Pokemon(String name, Type type1, Type type2, List<Type> defStrengths, List<Type> defWeaknesses, List<Type> defNormal) {
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.defStrengths = defStrengths;
		this.defWeaknesses = defWeaknesses;
		this.defNormal = defNormal;
	}
	
	public void addAttackStats(Type[] strengths, Type[] normal, Type[] weaknesses) {
		this.atkStrengths = strengths;
		this.atkNormal = normal;
		this.atkWeaknesses = weaknesses;
	}
	
	public void addMatchups(List<Type> good, List<Type> avg, List<Type> bad) {
		this.goodMatchups = good;
		this.avgMatchups = avg;
		this.badMatchups = bad;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type getType1() {
		return this.type1;
	}
	
	public Type getType2() {
		return this.type2;
	}
	
	public Type[] getAttackStrengths() {
		return this.atkStrengths;
	}
	
	public Type[] getAttackWeaknesses() {
		return this.atkWeaknesses;
	}
	
	public Type[] getAttackNormal() {
		return this.atkNormal;
	}
	
	public List<Type> getDefenseStrengths() {
		return this.defStrengths;
	}
	
	public List<Type> getDefenseWeaknesses() {
		return this.defWeaknesses;
	}
	
	public List<Type> getDefenseNormal() {
		return this.defNormal;
	}
	
	public List<Type> getGoodMatchups() {
		return this.goodMatchups;
	}
	
	public List<Type> getAvgMatchups() {
		return this.avgMatchups;
	}
	
	public List<Type> getBadMatchups() {
		return this.badMatchups;
	}
}
