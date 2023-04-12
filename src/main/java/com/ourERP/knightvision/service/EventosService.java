/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.service;

import clases.usuario.Eventos;
import java.util.List;

/**
 *
 * @author alber
 */
public interface EventosService {
    public List<Eventos> listEventos();

    public void salvar(Eventos evento);

    public void borrar(Eventos evento);

    public Eventos localizarCuenta(Eventos evento);

}
