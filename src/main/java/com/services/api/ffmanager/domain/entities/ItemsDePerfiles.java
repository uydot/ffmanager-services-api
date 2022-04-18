// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name="items_de_perfiles")
public class ItemsDePerfiles implements Serializable {

    @Id
    @Column(name="id_item_perfil", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemPerfil;
    @OneToOne(optional=false)
    @JoinColumn(name="fk_id_item_menu", nullable=false)
    private ItemsMenu itemsMenu;
    @OneToOne(optional=false)
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

}
