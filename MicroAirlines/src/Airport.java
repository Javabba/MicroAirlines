
public class Airport {
	private String name;
	private String code;
	
	
	public Airport(String name, String code) {
		this.name=name;		
		this.code=code;
	}
	
	
	public String getName() {
		return name;
	}


	public void print() {
		System.out.println("Airport is called "+name+"("+code+")");
		
		
		
		
	}
	

}
