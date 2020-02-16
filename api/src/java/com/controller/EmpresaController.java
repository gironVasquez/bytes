package com.controller;

import com.dao.EmpresaDAO;
import com.entidad.Empresa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaDAO dao;
    
    @RequestMapping(value = "/", method = RequestMethod.GET , produces = "application/json")
    public List<Empresa> listar()
    {
        return dao.listar();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST , produces = "application/json")
    public boolean guardar(
            @RequestParam("nombre") String nombre,
            @RequestParam("nit") int nit,
            @RequestParam("fecha") Date fecha,
            @RequestParam("direccion") String direccion)
    {
        Empresa e = new Empresa(nombre,nit,fecha,direccion);
        return dao.guardar(e);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT , produces = "application/json")
    public boolean  editar(
            @RequestParam("nit") int id,
            @RequestParam("nombre") String nombre,
            @RequestParam("nit") int nit,
            @RequestParam("fecha") Date fecha,
            @RequestParam("direccion") String direccion)
    {
        Empresa e = new Empresa(id,nombre,nit,fecha,direccion);
        return dao.editar(e);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE , produces = "application/json")
    public boolean eliminar(HttpServletRequest request)
    {
        Integer id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        Empresa e = new Empresa(id);
        return dao.editar(e);
    }
    
}
