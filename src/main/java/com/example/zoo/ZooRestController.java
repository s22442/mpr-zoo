package com.example.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {
  private final ZooService zooService;

  public ZooRestController() {
    this.zooService = new ZooService();
  }

  @GetMapping("/example")
  public ResponseEntity<Zoo> getZooExample() {
    return ResponseEntity.ok(zooService.getExampleZoo());
  }

  @GetMapping("/empty")
  public ResponseEntity<Zoo> getZoo() {
    return ResponseEntity.ok(zooService.getEmptyZoo());
  }

  @GetMapping("/puszeczek")
  public ResponseEntity<Zoo> getPuszeczek() {
    return ResponseEntity.ok(zooService.getZooOfName("Puszeczek"));
  }
}
