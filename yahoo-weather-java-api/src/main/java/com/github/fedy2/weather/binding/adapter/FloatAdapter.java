/**
 *
 */
package com.github.fedy2.weather.binding.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class FloatAdapter extends XmlAdapter<String, Float> {

    protected Logger logger = LoggerFactory.getLogger(FloatAdapter.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(Float v) throws Exception {
        return String.valueOf(v);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float unmarshal(String v) throws Exception {
    	if (v == null || v.isEmpty()) return null;
    	return Float.parseFloat(v);
    }

}
