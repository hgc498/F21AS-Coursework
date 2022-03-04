package base;

public class FlightPlan {
	private String model;
	private String manufacturer;
	private Double speed;
	private Double consumption;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getConsumption() {
		return consumption;
	}
	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}
	
	public FlightPlan() {
		
	}
	
	public boolean init(String line) {
		if (line == null || line.trim().equals("")) {
			return false;
		}
		String[] split = line.split(";");
		if (split.length < 4) {
			return false;
		}
		this.model = split[0].trim();
		this.manufacturer = split[1].trim();
		this.speed = Double.parseDouble(split[2].trim());
		this.consumption = Double.parseDouble(split[3].trim());
		return true;
	}
	@Override
	public String toString() {
		return model+";"+manufacturer+";"+speed+";"+consumption;
	}
}
