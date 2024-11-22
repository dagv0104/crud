package com.clase.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clase.crud.modelo.producto;

@Service
public class productosService {
    
    private List<producto> productos = new ArrayList<>();
    private Long nextId = 1L;

    public List<producto> getProductos() {
        return productos;
    }

    public Optional<producto> getProductoById(Long id) {
        return productos.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst(); 

    }

    public producto createProducto(producto producto) {
        producto.setId(nextId++);
        productos.add(producto);
        return producto;
    }

    public Optional<producto> updateProducto(Long id, producto productoDetails) {
        return getProductoById(id).map(producto -> {
            producto.setName(productoDetails.getName());
            producto.setPrice(productoDetails.getPrice());
            return producto;
        });
        
    }

    public boolean deleteProducto(Long id) {
        //return user.removeIf(user -> user.getId().equals(id));
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }
}
