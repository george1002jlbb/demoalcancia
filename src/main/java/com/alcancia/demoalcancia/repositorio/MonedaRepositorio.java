package com.alcancia.demoalcancia.repositorio;

import com.alcancia.demoalcancia.modelo.Moneda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepositorio extends CrudRepository<Moneda,Long> {
}
