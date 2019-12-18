package com.alura.webservices.fornecedor.service;

import com.alura.webservices.fornecedor.exception.ResourceNotFoundException;
import com.alura.webservices.fornecedor.model.InfoFornecedor;
import com.alura.webservices.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public  ResponseEntity<?> getInfoEstado(String estado){
       return new ResponseEntity<>(infoRepository.findByEstado(estado),HttpStatus.OK);
    }

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(infoRepository.findAll(),HttpStatus.OK);
    }

    private void verifyIfExistsId(Long id) throws ResourceNotFoundException{
        if(!infoRepository.findById(id).isPresent())
            throw new ResourceNotFoundException();
    }


}
