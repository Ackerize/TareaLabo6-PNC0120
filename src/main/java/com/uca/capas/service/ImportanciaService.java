package com.uca.capas.service;

import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ImportanciaService {
    public List<Importancia> findAll() throws DataAccessException;
}
