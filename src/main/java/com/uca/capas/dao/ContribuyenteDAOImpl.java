package com.uca.capas.dao;

import com.uca.capas.domain.Contribuyente;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ContribuyenteDAOImpl implements  ContribuyenteDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.contribuyente");
        Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
        List<Contribuyente> contribuyentes = query.getResultList();
        return contribuyentes;
    }

    @Override
    @Transactional
    public void insert(Contribuyente contribuyente) throws DataAccessException, ParseException {
        try{
            if(contribuyente.getCodigoContribuyente() == null){
                entityManager.persist(contribuyente);
            }else{
                entityManager.merge(contribuyente);
                entityManager.flush();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
