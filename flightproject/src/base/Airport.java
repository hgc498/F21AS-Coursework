package base;

import util.DMSUtils;

public class Airport {
	
	private String name;
	private String code;
	private Double latitude;
	private Double longitude;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Airport() {
		
	}
	
	public boolean init(String line) {
		if (line == null || line.trim().equals("")) {
			return false;
		}
		
		String[] split = line.split(";");
		if (split.length < 4) {
			return false;
		}
		String code = split[0].trim();
		String name = split[1].trim();
		String lat = split[2].trim();
		String lon = split[3].trim();
		lat = lat.replaceAll(" ", "").replace("N", "").replace("S", "");
		lon = lon.replaceAll(" ", "").replace("E", "").replace("W", "");
		this.code = code;
		this.name = name;
		this.latitude = DMSUtils.changeToDu(lat);
		this.longitude = DMSUtils.changeToDu(lon);
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(code).append(";");
		sb.append(name).append(";");
		sb.append(DMSUtils.changeToDFM(latitude)).append(";");
		sb.append(DMSUtils.changeToDFM(longitude)).append(";");
		return sb.toString();
	}

}
