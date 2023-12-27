package com.senai.projetosenai.resource;

import com.senai.projetosenai.storage.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/arquivo")
public class ArquivosResource {

    @Autowired
    private Disco disco;

    @PostMapping
    public void upload(@RequestParam MultipartFile arquivo) {
        disco.salvarArquivo(arquivo);
    }
}
