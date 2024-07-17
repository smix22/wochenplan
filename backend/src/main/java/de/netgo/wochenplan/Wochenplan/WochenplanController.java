package de.netgo.wochenplan.Wochenplan;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import de.netgo.wochenplan.jooq.tables.pojos.Wochenplan;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wochenplaene")
public class WochenplanController {

  private final WochenplanService wochenplanService;

  WochenplanController(final WochenplanService wochenplanService) {
    this.wochenplanService = wochenplanService;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<List<Wochenplan>> getWochenplaene() {
    return ResponseEntity.ok(wochenplanService.findAllWochenplaene());
  }

  // /benutzer/id/wochenplaene
  @GetMapping(value = "/{benutzerId}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<List<Wochenplan>> getWochenplaeneByBenutzerId(
      @PathVariable final UUID benutzerId) {
    return ResponseEntity.ok(wochenplanService.findAllWochenplaeneByBenutzerId(benutzerId));
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createWochenplan(@RequestBody final WochenplanDto wochenplan) {
    wochenplanService.createWochenplan(wochenplan);
    return ResponseEntity.ok().build();
  }
}
