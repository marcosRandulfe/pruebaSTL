package com.marcosrandulfe.pruebasolitium.controlers;

import com.marcosrandulfe.pruebasolitium.entities.Edificio;
import com.marcosrandulfe.pruebasolitium.managers.EdificioManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/edificio")
public class EdificioController {

    @Autowired
    private EdificioManager edificioManager;

    @GetMapping
    public List<Edificio> getAllEdificios() {
        return edificioManager.obtenerListadoEdificios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable Long id) {
        Optional<Edificio> edificio = Optional.ofNullable(edificioManager.obtenerEdificio(id.intValue()));
        return edificio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Edificio createEdificio(@RequestBody Edificio edificio) {
        return edificioManager.crearEdificio(edificio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edificio> updateEdificio(@PathVariable Long id, @RequestBody Edificio edificioDetails) {
        edificioDetails.setId(id.intValue());
        return Optional.ofNullable(edificioManager.actualizarEdificio(edificioDetails))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEdificio(@PathVariable Long id) {
        edificioManager.borrarEdificio(id.intValue());
        return ResponseEntity.noContent().build();
    }
}
