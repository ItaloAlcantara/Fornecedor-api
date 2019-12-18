package com.alura.webservices.fornecedor.controller;

import com.alura.webservices.fornecedor.exception.ResourceNotFoundException;
import com.alura.webservices.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{estado}")
    public ResponseEntity<?> getInfoEstado(@PathVariable String estado) throws ResourceNotFoundException {
        return infoService.getInfoEstado(estado);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){ return infoService.findAll();}

}
