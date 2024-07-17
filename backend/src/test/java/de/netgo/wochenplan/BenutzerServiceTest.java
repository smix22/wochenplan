package de.netgo.wochenplan;

import de.netgo.wochenplan.Benutzer.BenutzerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BenutzerServiceTest {

  @Autowired
  private BenutzerService benutzerService;


  @Test
  void test_findAll() {
    benutzerService.findAllBenutzer();
  }
}