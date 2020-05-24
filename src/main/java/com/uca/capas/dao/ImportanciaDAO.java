package com.uca.capas.dao;

import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ImportanciaDAO {
    public List<Importancia> findAll() throws DataAccessException;
}
