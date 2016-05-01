/**
 * 
 */
package com.github.fedy2.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.github.fedy2.weather.data.unit.DegreeUnit;

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
	private String woeidCondition;
	private Map<String, String> limits;

	public QueryBuilder() {
		limits = new HashMap<String, String>();
	}

	public QueryBuilder woeid(String woeid) {
		woeidCondition = WOEID_PARAMETER_NAME + "=" + "\"" + woeid +"\"";
		return this;
	}

	public QueryBuilder location(String location) {
		woeidCondition = WOEID_PARAMETER_NAME + " in (select woeid from geo.places where text=\""+location+"\")";
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
	
	public String build() {
		StringBuilder query = new StringBuilder("SELECT * FROM weather.forecast WHERE ");
		query.append(woeidCondition).append(" ");
		if (unitCondition!=null) query.append("AND ").append(unitCondition).append(" ");
		
		for (Entry<String, String> limit:limits.entrySet()) query.append("| ").append(limit.getKey()).append("(count=").append(limit.getValue()).append(") ");
				
		return query.toString();
	}
}
