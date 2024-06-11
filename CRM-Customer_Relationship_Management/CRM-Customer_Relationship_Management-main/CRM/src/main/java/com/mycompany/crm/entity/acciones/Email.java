/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crm.entity.acciones;

import com.mycompany.crm.entity.Comercial;
import com.mycompany.crm.exceptions.ComandaException;

import java.util.Date;

public class Email extends Accion {

    private String email;
    private boolean esPromocion;

    public Email(Date fecha, Comercial comercial, String descripcion, String email, boolean esPromocion) throws ComandaException {
        super(fecha, comercial, descripcion);
        if(email.length() > 100){
            throw new ComandaException(ComandaException.ERROR_LONGITUD_100);
        }
        this.email = email;
        this.esPromocion = esPromocion;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEsPromocion() {
        return esPromocion;
    }

    @Override
    public String toString() {
        String promo = "NO";
        if(this.esPromocion){
            promo = "SI";
        }
        return super.toString() + "\t\tEmail: " + email + "\t\tPromocion: " + promo;
    }
}
