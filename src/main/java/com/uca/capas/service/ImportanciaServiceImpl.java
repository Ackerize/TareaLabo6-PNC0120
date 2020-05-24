package com.uca.capas.service;


import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{

    @Autowired
    ImportanciaDAO importanciaDAO;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
        return importanciaDAO.findAll();
    }
}
