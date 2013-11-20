package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the activeconfig_internal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="activeconfig_internal"
 */

public abstract class BaseActiveconfigInternal  implements Serializable {

   private static final long serialVersionUID = 1L;
   public static String REF = "ActiveconfigInternal";
	public static String PROP_CONFIG = "Config";
	public static String PROP_CONFIG_INTERNAL = "ConfigInternal";


	// constructors
	public BaseActiveconfigInternal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActiveconfigInternal (java.lang.Integer config) {
		this.setConfig(config);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseActiveconfigInternal (
		java.lang.Integer config,
		de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal configInternal) {

		this.setConfig(config);
		this.setConfigInternal(configInternal);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer config;

	// many to one
	private de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal configInternal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="config"
     */
	public java.lang.Integer getConfig () {
		return config;
	}

	/**
	 * Set the unique identifier of this class
	 * @param config the new ID
	 */
	public void setConfig (java.lang.Integer config) {
		this.config = config;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: config
	 */
	public de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal getConfigInternal () {
		return configInternal;
	}

	/**
	 * Set the value related to the column: config
	 * @param configInternal the config value
	 */
	public void setConfigInternal (de.htwg_konstanz.ebus.framework.wholesaler.vo.ConfigInternal configInternal) {
		this.configInternal = configInternal;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof de.htwg_konstanz.ebus.framework.wholesaler.vo.ActiveconfigInternal)) return false;
		else {
			de.htwg_konstanz.ebus.framework.wholesaler.vo.ActiveconfigInternal activeconfigInternal = (de.htwg_konstanz.ebus.framework.wholesaler.vo.ActiveconfigInternal) obj;
			if (null == this.getConfig() || null == activeconfigInternal.getConfig()) return false;
			else return (this.getConfig().equals(activeconfigInternal.getConfig()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getConfig()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getConfig().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}