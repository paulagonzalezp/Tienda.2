package com.tienda_m.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
public interface FirebaseStorageService {
     public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-m-6a0c7.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-m-6a0c7-firebase-adminsdk-myqvf-d24e6c0e4c.jason";
}

    
