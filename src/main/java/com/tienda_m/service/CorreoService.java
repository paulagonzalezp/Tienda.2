package com.tienda_m.service;

public interface CorreoService {
    //La firma del metodo para enviar correos html

    public void enviarCorreoHtml(
            String para,
            String asutno,
            String contenidoHtml
     throws MessagingException;

}
