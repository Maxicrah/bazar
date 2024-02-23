package com.maxi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.model.Producto;

@Repository
public interface IProductoDAO extends JpaRepository<Producto, Long>{

}
