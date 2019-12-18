package com.alura.webservices.fornecedor.repository;

import com.alura.webservices.fornecedor.model.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoFornecedor,Long> {

    InfoFornecedor findByEstado(String estado);
}
