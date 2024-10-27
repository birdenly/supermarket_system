package com.web2project.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2project.supermarket.entities.ClienteEntity;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
