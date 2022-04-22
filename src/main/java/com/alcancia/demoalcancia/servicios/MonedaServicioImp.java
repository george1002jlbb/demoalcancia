package com.alcancia.demoalcancia.servicios;

import com.alcancia.demoalcancia.excepciones.ManejoException;
import com.alcancia.demoalcancia.modelo.Moneda;
import com.alcancia.demoalcancia.repositorio.MonedaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MonedaServicioImp implements IMoneda {

    public static final int MONEDA_DE_50 = 50;
    public static final int MONEDA_DE_100 = 100;
    public static final int MONEDA_DE_200 = 200;
    public static final int MONEDA_DE_500 = 500;
    public static final int MONEDA_DE_1000 = 1000;

    @Autowired
    private MonedaRepositorio monedaRepositorio;

    @Override
    public Moneda guardar(Moneda moneda) {
        if(moneda.getValor() == MONEDA_DE_50
                || moneda.getValor() == MONEDA_DE_100
                || moneda.getValor() == MONEDA_DE_200
                || moneda.getValor() == MONEDA_DE_500
                || moneda.getValor() == MONEDA_DE_1000 ){
            return monedaRepositorio.save(moneda);
        }else{
            throw new ManejoException("Tipo de moneda no permitido en la alcancia");
        }

    }

    @Override
    public Optional<Moneda> consultar(Long id) {
        return monedaRepositorio.findById(id);
    }

    @Override
    public ArrayList<Moneda> listar() {
        return (ArrayList<Moneda>)monedaRepositorio.findAll();
    }

    @Override
    public Integer cantidadMonedad() {
        ArrayList<Moneda> lstMoneda = (ArrayList<Moneda>) monedaRepositorio.findAll();
        return lstMoneda.size();
    }

    @Override
    public Double cantidadDinero() {
        ArrayList<Moneda> lstMoneda = (ArrayList<Moneda>) monedaRepositorio.findAll();
        double cantDinero = 0;
        for (Moneda m: lstMoneda) {
            cantDinero += m.getValor();
        }
        return cantDinero;
    }

    @Override
    public Integer cantidadMonedaxDenominacion(int denominacion) {
        ArrayList<Moneda> lstMoneda = (ArrayList<Moneda>) monedaRepositorio.findAll();
        ArrayList<Moneda> lstCantidadMonDen = new ArrayList<Moneda>();
        for (Moneda m: lstMoneda) {
            if(m.getValor() == denominacion){
                lstCantidadMonDen.add(m);
            }
        }
        return lstCantidadMonDen.size();
    }

    @Override
    public Double cantidadDineroxDenominacion(int denominacion) {
        ArrayList<Moneda> lstMoneda = (ArrayList<Moneda>) monedaRepositorio.findAll();
        double cantidadDinDen = 0;
        for (Moneda m: lstMoneda) {
            if(m.getValor() == denominacion){
                cantidadDinDen += m.getValor();
            }
        }
        return cantidadDinDen;
    }
}
