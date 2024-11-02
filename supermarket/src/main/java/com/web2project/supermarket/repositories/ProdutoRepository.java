package com.web2project.supermarket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2project.supermarket.entities.ProdutoEntity;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
        List<ProdutoEntity> findAllByAtivoTrue();
}
