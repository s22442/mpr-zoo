package com.example.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {

  @GetMapping("/example")
  public ResponseEntity<Zoo> getZooExample() {
    return ResponseEntity.ok(
        new Zoo(
            1,
            "Wesołe Zoo",
            "Zoo Example, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
            false,
            List.of(
                new Animal(
                    1,
                    "Puszek",
                    "dog but better",
                    AnimalDiet.MEAT,
                    AnimalType.AIR,
                    true,
                    AnimalHealth.DEAD))));
  }

  @GetMapping("/empty")
  public ResponseEntity<Zoo> getZoo() {
    return ResponseEntity.ok(
        new Zoo(
            1,
            "Wesołe Zoo",
            "Zoo, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
            false,
            null));
  }
}
