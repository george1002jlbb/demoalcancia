package com.alcancia.demoalcancia.servicios;

import com.alcancia.demoalcancia.modelo.Moneda;

import java.util.ArrayList;
import java.util.Optional;

public interface IMoneda {

    Moneda guardar(Moneda m);
    Optional<Moneda> consultar(Long id);
    ArrayList<Moneda> listar();
    Integer cantidadMonedad();
    Double cantidadDinero();
    Integer cantidadMonedaxDenominacion(int denominacion);
    Double cantidadDineroxDenominacion(int denominacion);

}
