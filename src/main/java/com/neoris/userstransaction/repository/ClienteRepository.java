package com.neoris.userstransaction.repository;

import com.neoris.userstransaction.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {


}
