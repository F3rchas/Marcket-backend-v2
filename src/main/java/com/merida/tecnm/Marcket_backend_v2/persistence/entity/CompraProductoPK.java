package com.merida.tecnm.Marcket_backend_v2.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;


public class CompraProductoPK implements Serializable {


    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProduct;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
