package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
public static String formatDateStr = "dd:MM:YYYY";
public static String formatTimeStr = "HH:mm";
public static String formatStr = "dd:MM:YYYY HH:mm";
	private String code;
	private String planCode;
	private String departure;
	private String destination;
	private Date begin;
	private List<String> towers = new ArrayList<>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public List<String> getTowers() {
		return towers;
	}
	public void setTowers(List<String> towers) {
		this.towers = towers;
	}
	
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(begin);
	}
	public String getTimeStr() {
		SimpleDateFormat format = new SimpleDateFormat(formatTimeStr);
		return format.format(begin);
	}
	
	public Flight() {
		
	}
	
	public boolean init(String line) {
		if (line == null || line.trim().equals("")) {
			return false;
		}
		String[] split = line.split(";");
		if (split.length < 7) {
			return false;
		}
		this.code = split[0].trim(); 
		this.planCode = split[1].trim(); 
		this.departure = split[2].trim(); 
		this.destination = split[3].trim();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			this.begin = format.parse(split[4].trim()+" "+split[5].trim());
		} catch (ParseException e) {
			return false;
		}
		
		for (int i = 6; i < split.length; i++) {
			String str = split[i];
			if (str == null || str.trim().equals("") ) {
				continue;
				
			}
			str = str.trim();
			towers.add(str);
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat(formatDateStr);
		SimpleDateFormat format1 = new SimpleDateFormat(formatTimeStr);
		StringBuffer sb = new StringBuffer();
		sb.append(code).append(";")
			.append(planCode).append(";")
			.append(departure).append(";")
			.append(destination).append(";")
			.append(format.format(begin)).append(";")
			.append(format1.format(begin)).append(";");
		for (String string : towers) {
			sb.append(string).append(";");
		}
		return sb.toString();
	}
	

}
