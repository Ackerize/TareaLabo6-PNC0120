package com.uca.capas.service;

import com.uca.capas.domain.Contribuyente;

import java.text.ParseException;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface ContribuyenteService {
    public List<Contribuyente> findAll() throws DataAccessException;
    public void save(Contribuyente contribuyente) throws DataAccessException, ParseException;
}
