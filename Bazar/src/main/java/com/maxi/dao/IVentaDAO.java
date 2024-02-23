package com.maxi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.model.Venta;

@Repository
public interface IVentaDAO extends JpaRepository<Venta, Long>{

}
