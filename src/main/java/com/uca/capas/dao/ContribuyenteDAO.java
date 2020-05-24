package com.uca.capas.dao;

import com.uca.capas.domain.Contribuyente;
import org.springframework.dao.DataAccessException;

import java.text.ParseException;
import java.util.List;


public interface ContribuyenteDAO {
    public List<Contribuyente> findAll() throws DataAccessException;
    public void insert(Contribuyente contribuyente) throws DataAccessException, ParseException;

}
