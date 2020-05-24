package com.uca.capas.service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ContribuyenteServiceImpl implements  ContribuyenteService{

    @Autowired
    ContribuyenteDAO contribuyenteDAO;

    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        return contribuyenteDAO.findAll();
    }

    @Override
    public void save(Contribuyente contribuyente) throws DataAccessException, ParseException {
        contribuyenteDAO.insert(contribuyente);
    }
}
