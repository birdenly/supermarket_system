package com.web2project.supermarket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2project.supermarket.entities.PedidoEntity;
@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
     List<PedidoEntity> findAllByAtivoTrue();

}
