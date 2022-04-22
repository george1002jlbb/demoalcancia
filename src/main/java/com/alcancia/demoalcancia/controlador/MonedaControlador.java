package com.alcancia.demoalcancia.controlador;

import com.alcancia.demoalcancia.dto.MonedaDto;
import com.alcancia.demoalcancia.modelo.Moneda;
import com.alcancia.demoalcancia.repositorio.MonedaRepositorio;
import com.alcancia.demoalcancia.servicios.MonedaServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alcancia")
public class MonedaControlador {

    @Autowired
    private MonedaServicioImp monedaServicioImp;

    @PostMapping
    public ResponseEntity guardar(@RequestBody MonedaDto mdto){

        Moneda moneda = new Moneda();
        moneda.setId(mdto.getId());
        moneda.setValor(mdto.getValor());

        monedaServicioImp.guardar(moneda);

        return new ResponseEntity(moneda, HttpStatus.OK);
    }

    @GetMapping( path = "/{id-moneda}")
    public ResponseEntity consutlarId(@PathVariable("id-moneda") Long id){
        return new ResponseEntity(monedaServicioImp.consultar(id), HttpStatus.OK);
    }

    @GetMapping( path = "/list")
    public ResponseEntity consutlar(){
        return new ResponseEntity(monedaServicioImp.listar(), HttpStatus.CREATED);
    }

    @GetMapping( path = "/cantmon")
    public ResponseEntity cantidadMonedad(){
        return new ResponseEntity(monedaServicioImp.cantidadMonedad(), HttpStatus.CREATED);
    }

    @GetMapping( path = "/cantdin")
    public ResponseEntity cantidadDinero(){
        return new ResponseEntity(monedaServicioImp.cantidadDinero(), HttpStatus.CREATED);
    }

    @GetMapping( path = "/cantmonxden/{den-moneda}")
    public ResponseEntity cantidadMonedaxDenominacion(@PathVariable("den-moneda")int denominacion){
        return new ResponseEntity(monedaServicioImp.cantidadMonedaxDenominacion(denominacion), HttpStatus.CREATED);
    }

    @GetMapping( path = "/cantdinxden/{den-moneda}")
    public ResponseEntity cantidadDineroxDenominacion(@PathVariable("den-moneda")int denominacion){
        return new ResponseEntity(monedaServicioImp.cantidadDineroxDenominacion(denominacion), HttpStatus.CREATED);
    }

}
