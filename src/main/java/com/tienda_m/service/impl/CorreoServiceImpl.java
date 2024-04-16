package com.tienda_m.service.impl;

import com.tienda_m.service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender mailSender; // Corregido el nombre de la variable

    @Override
    public void enviarCorreoHtml(
            String para,
            String asunto,
            String contenidoHtml)
            throws MessagingException {
        MimeMessage mensaje = mailSender.createMimeMessage(); // Corregido el nombre de la variable y añadido el punto y coma
        MimeMessageHelper apoyo = new MimeMessageHelper(mensaje, true); // Corregido el nombre de la variable y añadido el punto y coma
        apoyo.setTo(para);
        apoyo.setSubject(asunto);
        apoyo.setText(contenidoHtml, true); // Corregido el punto y coma
        mailSender.send(correo); // Se añadió esta línea para enviar el mensaje de correo
    }
}
