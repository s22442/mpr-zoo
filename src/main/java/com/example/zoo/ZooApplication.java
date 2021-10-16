package com.example.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZooApplication.class, args);
    System.out.println("Started Zoo Application!");

    // Zoo -> id, name, location, isClosed, list Animal
    // Animal -> id, specimen, diet (meat, vege, mixed), type (water, land, air), isHungry, health
  }
}
