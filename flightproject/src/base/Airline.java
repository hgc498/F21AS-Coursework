package base;



public class Airline {
	
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Airline(){
	}
	
	public boolean init(String line) {
		if (line == null || line.trim().equals("")) {
			return false;
		}
		String[] split = line.split(";");
		if (split.length < 2) {
			return false;
		}
		String code = split[0].trim();
		String name = split[1].trim();
		this.code = code;
		this.name = name;
		return true;
	}
	
	
	@Override
	public String toString() {
		return code + ";" + name;
	}
	

}
