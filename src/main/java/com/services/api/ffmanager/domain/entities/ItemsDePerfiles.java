// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="items_de_perfiles")
public class ItemsDePerfiles implements Serializable {

    /** Primary key. */
    protected static final String PK = "idItemPerfil";

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
    @Column(name="id_item_perfil", unique=true, nullable=false, precision=10)
    private int idItemPerfil;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_item_menu", nullable=false)
    private ItemsMenu itemsMenu;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_perfil", nullable=false)
    private Perfiles perfiles;

    /** Default constructor. */
    public ItemsDePerfiles() {
        super();
    }

    /**
     * Access method for idItemPerfil.
     *
     * @return the current value of idItemPerfil
     */
    public int getIdItemPerfil() {
        return idItemPerfil;
    }

    /**
     * Setter method for idItemPerfil.
     *
     * @param aIdItemPerfil the new value for idItemPerfil
     */
    public void setIdItemPerfil(int aIdItemPerfil) {
        idItemPerfil = aIdItemPerfil;
    }

    /**
     * Access method for itemsMenu.
     *
     * @return the current value of itemsMenu
     */
    public ItemsMenu getItemsMenu() {
        return itemsMenu;
    }

    /**
     * Setter method for itemsMenu.
     *
     * @param aItemsMenu the new value for itemsMenu
     */
    public void setItemsMenu(ItemsMenu aItemsMenu) {
        itemsMenu = aItemsMenu;
    }

    /**
     * Access method for perfiles.
     *
     * @return the current value of perfiles
     */
    public Perfiles getPerfiles() {
        return perfiles;
    }

    /**
     * Setter method for perfiles.
     *
     * @param aPerfiles the new value for perfiles
     */
    public void setPerfiles(Perfiles aPerfiles) {
        perfiles = aPerfiles;
    }

    /**
     * Compares the key for this instance with another ItemsDePerfiles.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ItemsDePerfiles and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ItemsDePerfiles)) {
            return false;
        }
        ItemsDePerfiles that = (ItemsDePerfiles) other;
        if (this.getIdItemPerfil() != that.getIdItemPerfil()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ItemsDePerfiles.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ItemsDePerfiles)) return false;
        return this.equalKeys(other) && ((ItemsDePerfiles)other).equalKeys(this);
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
        i = getIdItemPerfil();
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
        StringBuffer sb = new StringBuffer("[ItemsDePerfiles |");
        sb.append(" idItemPerfil=").append(getIdItemPerfil());
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
        ret.put("idItemPerfil", Integer.valueOf(getIdItemPerfil()));
        return ret;
    }

}
