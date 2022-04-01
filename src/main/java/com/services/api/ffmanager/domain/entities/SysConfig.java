// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="sys_config")
public class SysConfig implements Serializable {

    /** Primary key. */
    protected static final String PK = "variable";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @Column(unique=true, nullable=false, length=128)
    private String variable;
    @Column(length=128)
    private String value;
    @Column(name="set_time")
    private LocalDateTime setTime;
    @Column(name="set_by", length=128)
    private String setBy;

    /** Default constructor. */
    public SysConfig() {
        super();
    }

    /**
     * Access method for variable.
     *
     * @return the current value of variable
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Setter method for variable.
     *
     * @param aVariable the new value for variable
     */
    public void setVariable(String aVariable) {
        variable = aVariable;
    }

    /**
     * Access method for value.
     *
     * @return the current value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter method for value.
     *
     * @param aValue the new value for value
     */
    public void setValue(String aValue) {
        value = aValue;
    }

    /**
     * Access method for setTime.
     *
     * @return the current value of setTime
     */
    public LocalDateTime getSetTime() {
        return setTime;
    }

    /**
     * Setter method for setTime.
     *
     * @param aSetTime the new value for setTime
     */
    public void setSetTime(LocalDateTime aSetTime) {
        setTime = aSetTime;
    }

    /**
     * Access method for setBy.
     *
     * @return the current value of setBy
     */
    public String getSetBy() {
        return setBy;
    }

    /**
     * Setter method for setBy.
     *
     * @param aSetBy the new value for setBy
     */
    public void setSetBy(String aSetBy) {
        setBy = aSetBy;
    }

    /**
     * Compares the key for this instance with another SysConfig.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class SysConfig and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof SysConfig)) {
            return false;
        }
        SysConfig that = (SysConfig) other;
        Object myVariable = this.getVariable();
        Object yourVariable = that.getVariable();
        if (myVariable==null ? yourVariable!=null : !myVariable.equals(yourVariable)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another SysConfig.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SysConfig)) return false;
        return this.equalKeys(other) && ((SysConfig)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        if (getVariable() == null) {
            i = 0;
        } else {
            i = getVariable().hashCode();
        }
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[SysConfig |");
        sb.append(" variable=").append(getVariable());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("variable", getVariable());
        return ret;
    }

}
