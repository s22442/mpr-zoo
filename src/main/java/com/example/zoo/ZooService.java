package com.example.zoo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {
  public Zoo getExampleZoo() {
    return new Zoo(
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
                AnimalHealth.DEAD)));
  }

  public Zoo getEmptyZoo() {
    return new Zoo(
        1,
        "Wesołe Zoo",
        "Zoo, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
        false,
        null);
  }

  public Zoo getZooOfName(String name) {
    return new Zoo(
        1,
        name,
        "Zoo, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
        false,
        null);
  }
}
