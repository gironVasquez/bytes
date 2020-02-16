/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entidad.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author fernando
 */
@Service
public class EmpresaDAO {
    @PersistenceContext
    EntityManager em;
    
    @Transactional(noRollbackFor = Exception.class)
    public List<Empresa> listar(){
        return em.createQuery("SELECT e FROM Empresa e",Empresa.class).getResultList();
    }
    
    @Transactional(noRollbackFor = Exception.class)
    public boolean guardar(Empresa e)
    {
        try{
            em.persist(e);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    @Transactional(noRollbackFor = Exception.class)
    public boolean editar(Empresa e)
    {
        try{
            em.merge(e);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    @Transactional(noRollbackFor = Exception.class)
    public boolean eliminar(Empresa e)
    {
        try{
            em.remove(e);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
