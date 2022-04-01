// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="items_menu")
public class ItemsMenu implements Serializable {

    /** Primary key. */
    protected static final String PK = "idItemMenu";

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
    @Column(name="id_item_menu", unique=true, nullable=false, precision=10)
    private int idItemMenu;
    @Column(nullable=false, length=45)
    private String nombre;
    @Column(length=200)
    private String link;
    @Column(name="es_hoja", length=1)
    private boolean esHoja;
    @Column(name="es_raiz", length=1)
    private boolean esRaiz;
    @OneToMany(mappedBy="itemsMenu")
    private Set<ItemsMenu> itemsMenuHijos;
    @ManyToOne
    @JoinColumn(name="id_item_padre")
    private ItemsMenu itemsMenu;
    @OneToMany(mappedBy="itemsMenu")
    private Set<ItemsDePerfiles> itemsDePerfiles;

    /** Default constructor. */
    public ItemsMenu() {
        super();
    }

    /**
     * Access method for idItemMenu.
     *
     * @return the current value of idItemMenu
     */
    public int getIdItemMenu() {
        return idItemMenu;
    }

    /**
     * Setter method for idItemMenu.
     *
     * @param aIdItemMenu the new value for idItemMenu
     */
    public void setIdItemMenu(int aIdItemMenu) {
        idItemMenu = aIdItemMenu;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for link.
     *
     * @return the current value of link
     */
    public String getLink() {
        return link;
    }

    /**
     * Setter method for link.
     *
     * @param aLink the new value for link
     */
    public void setLink(String aLink) {
        link = aLink;
    }

    /**
     * Access method for esHoja.
     *
     * @return true if and only if esHoja is currently true
     */
    public boolean isEsHoja() {
        return esHoja;
    }

    /**
     * Setter method for esHoja.
     *
     * @param aEsHoja the new value for esHoja
     */
    public void setEsHoja(boolean aEsHoja) {
        esHoja = aEsHoja;
    }

    /**
     * Access method for esRaiz.
     *
     * @return true if and only if esRaiz is currently true
     */
    public boolean isEsRaiz() {
        return esRaiz;
    }

    /**
     * Setter method for esRaiz.
     *
     * @param aEsRaiz the new value for esRaiz
     */
    public void setEsRaiz(boolean aEsRaiz) {
        esRaiz = aEsRaiz;
    }

    /**
     * Access method for itemsMenuM.
     *
     * @return the current value of itemsMenuM
     */
    public Set<ItemsMenu> getItemsMenuHijos() {
        return itemsMenuHijos;
    }

    /**
     * Setter method for itemsMenuM.
     *
     * @param aItemsMenuM the new value for itemsMenuM
     */
    public void setItemsMenuHijos(Set<ItemsMenu> aItemsMenuM) {
    	itemsMenuHijos = aItemsMenuM;
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
     * Access method for itemsDePerfiles.
     *
     * @return the current value of itemsDePerfiles
     */
    public Set<ItemsDePerfiles> getItemsDePerfiles() {
        return itemsDePerfiles;
    }

    /**
     * Setter method for itemsDePerfiles.
     *
     * @param aItemsDePerfiles the new value for itemsDePerfiles
     */
    public void setItemsDePerfiles(Set<ItemsDePerfiles> aItemsDePerfiles) {
        itemsDePerfiles = aItemsDePerfiles;
    }

    /**
     * Compares the key for this instance with another ItemsMenu.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ItemsMenu and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ItemsMenu)) {
            return false;
        }
        ItemsMenu that = (ItemsMenu) other;
        if (this.getIdItemMenu() != that.getIdItemMenu()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ItemsMenu.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ItemsMenu)) return false;
        return this.equalKeys(other) && ((ItemsMenu)other).equalKeys(this);
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
        i = getIdItemMenu();
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
        StringBuffer sb = new StringBuffer("[ItemsMenu |");
        sb.append(" idItemMenu=").append(getIdItemMenu());
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
        ret.put("idItemMenu", Integer.valueOf(getIdItemMenu()));
        return ret;
    }

}
