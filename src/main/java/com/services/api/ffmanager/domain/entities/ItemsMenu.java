// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="items_menu")
public class ItemsMenu implements Serializable {
	
    @Id
    @Column(name="id_item_menu", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
