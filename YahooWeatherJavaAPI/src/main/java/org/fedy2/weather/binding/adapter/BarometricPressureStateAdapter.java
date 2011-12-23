/**
 * 
 */
package org.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.fedy2.weather.data.unit.BarometricPressureState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * State of the barometric pressure adapter: steady (0), rising (1), or falling (2). 
 * (integer: 0, 1, 2)
 * @author fedy2
 */
public class BarometricPressureStateAdapter extends	XmlAdapter<Integer, BarometricPressureState> {

	protected static final int FALLING = 2;
	protected static final int RISING = 1;
	protected static final int STEADY = 0;
	protected Logger logger = LoggerFactory.getLogger(BarometricPressureStateAdapter.class);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BarometricPressureState unmarshal(Integer v) throws Exception {
		switch (v) {
			case STEADY: return BarometricPressureState.STEADY;
			case RISING: return BarometricPressureState.RISING;
			case FALLING: return BarometricPressureState.FALLING;
		}
		logger.warn("Unknown barometric pressure state \""+v+"\"");
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer marshal(BarometricPressureState v) throws Exception {
		switch (v) {
			case STEADY: return STEADY;
			case RISING: return RISING;
			case FALLING: return FALLING;
			default: return -1;
		}
	}
}
