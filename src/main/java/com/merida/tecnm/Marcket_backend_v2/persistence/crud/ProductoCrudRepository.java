package com.merida.tecnm.Marcket_backend_v2.persistence.crud;

import com.merida.tecnm.Marcket_backend_v2.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

//Métodos abstractos que después se implementarán
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*SQL Query Method
    SELECT *
    FROM productos
    WHERE id_categoria = 10?
    ORDER BY nombre ASC
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Cantidad stock
    Optional<List<Producto>>findByCantidadStockLessThenAndEstado(int Cantidadstock, boolean estado);


}
