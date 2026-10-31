package k.create;

public class Factory {
	public static Product getInstance(String name) {
		if (name.equals("E"))
			return new E();
		else if(name.equals("F"))
			return new F();
		else 
			return null;
		
	}

}
