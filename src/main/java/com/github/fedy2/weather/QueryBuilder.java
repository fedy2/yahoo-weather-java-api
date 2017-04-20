/**
 * 
 */
package com.github.fedy2.weather;

import com.github.fedy2.weather.data.unit.DegreeUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * An helper for query building.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class QueryBuilder {

	private static final String WOEID_PARAMETER_NAME = "woeid";
	private static final String DEGREES_PARAMETER_CELSIUS = "u=\"c\"";
	private static final String DEGREES_PARAMETER_FAHRENHEIT = "u=\"f\"";
	private static final String FIRST_PARAMETER_NAME = "truncate";
	private static final String LAST_PARAMETER_NAME = "tail";

	private String unitCondition;
	private String condition;
	private String select;
	private Map<String, String> limits;

	public static enum Type {
		FORECAST,
		PLACE
	}

	public QueryBuilder(Type type) {
		limits = new HashMap<String, String>();
		if (type == Type.FORECAST) {
			select = "SELECT * FROM weather.forecast ";
		} else {
			select = "SELECT name, woeid, country, admin1, admin2, admin3 FROM geo.places ";
		}
	}

	public QueryBuilder woeid(String woeid) {
		condition = WOEID_PARAMETER_NAME + "=" + "\"" + woeid +"\"";
		return this;
	}

	public QueryBuilder location(String location) {
		condition = WOEID_PARAMETER_NAME + " in (select woeid from geo.places where text=\""+location+"\")";
		return this;
	}

	public QueryBuilder unit(DegreeUnit unit) {
		switch (unit) {
			case CELSIUS: unitCondition = DEGREES_PARAMETER_CELSIUS; break;
			case FAHRENHEIT: unitCondition = DEGREES_PARAMETER_FAHRENHEIT; break;
		}
		return this;
	}
	
	public QueryBuilder first(int limit) {
		limits.put(FIRST_PARAMETER_NAME, String.valueOf(limit));
		return this;
	}
	
	public QueryBuilder last(int limit) {
		limits.put(LAST_PARAMETER_NAME, String.valueOf(limit));
		return this;
	}

	public QueryBuilder searchString(String search) {
		condition = "text = \"" + search + "\"";
		return this;
	}

	public String build() {
		StringBuilder query = new StringBuilder(select);
		query.append("WHERE").append(" ");
		query.append(condition).append(" ");
		if (unitCondition!=null) query.append("AND ").append(unitCondition).append(" ");
		
		for (Entry<String, String> limit:limits.entrySet()) query.append("| ").append(limit.getKey()).append("(count=").append(limit.getValue()).append(") ");
				
		return query.toString();
	}
}
