package br.cefetmg.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetmg.petshop.model.Pet;
import br.cefetmg.petshop.service.PetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    public final PetService petService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PET_CONSULTAR')")
    public ResponseEntity<Pet> getPet(@PathVariable Long id){
        Pet pet = petService.getPet(id);
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('PET_CONSULTAR')")
    public ResponseEntity<List<Pet>> getPetList(){
        return ResponseEntity.ok().body(petService.getPetList());
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('PET_INSERIR')")
    public ResponseEntity<Pet> insertPet(@RequestBody Pet pet){
        Pet petAux = petService.insertPet(pet);
        return ResponseEntity.ok().body(petAux);
    }

    @PutMapping("")
    @PreAuthorize("hasAuthority('PET_ALTERAR')")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
        Pet petAux = petService.updatePet(pet);
        return ResponseEntity.ok().body(petAux);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PET_DELETAR')")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id){
        Pet petAux = petService.deletePet(id);
        return ResponseEntity.ok().body(petAux);
    }
}
