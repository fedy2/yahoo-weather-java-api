/**
 * 
 */
package com.github.fedy2.weather.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * List wrapper.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
public class Wrapper<T> {

  private List<T> items;

  public Wrapper() {
    items = new ArrayList<T>();
  }

  public Wrapper(List<T> items) {
    this.items = items;
  }

  @XmlAnyElement(lax=true)
  public List<T> getItems() {
    return items;
  }
}
