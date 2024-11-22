package com.clase.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase.crud.modelo.producto;
import com.clase.crud.service.productosService;

@RestController
@RequestMapping("/api/productos")
public class productosController {
    private final productosService ProductosService;
    
    @Autowired
    public productosController(productosService ProductosService) {
        this.ProductosService = ProductosService;
    }

    @GetMapping
    public List<producto> getAllUsers() {
        return ProductosService.getProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<producto> getProductoById(@PathVariable Long id) {
        Optional<producto> producto = ProductosService.getProductoById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public producto creatUser(@RequestBody producto producto) {
        return ProductosService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<producto> updateProducto(@PathVariable Long id, @RequestBody producto productoDetails) {
        Optional<producto> producto = ProductosService.updateProducto(id, productoDetails);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if(ProductosService.deleteProducto(id)) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
