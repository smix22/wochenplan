package de.netgo.wochenplan.Wochenplan;

import de.netgo.wochenplan.Benutzer.BenutzerService;
import de.netgo.wochenplan.jooq.tables.daos.WochenplanDao;
import de.netgo.wochenplan.jooq.tables.pojos.Wochenplan;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WochenplanService {

  private final WochenplanDao wochenplanDao;

  public WochenplanService(final WochenplanDao wochenplanDao) {
    this.wochenplanDao = wochenplanDao;

  }

  @Transactional(readOnly = true)
  List<Wochenplan> findAllWochenplaene() {
    return wochenplanDao.findAll();
  }

  @Transactional(readOnly = true)
  List<Wochenplan> findAllWochenplaeneByBenutzerId(final UUID benutzerId) {
    return wochenplanDao.fetchByBenutzerId(benutzerId);
  }

  @Transactional
  public void createWochenplan(final WochenplanDto wochenplan) {
    wochenplanDao.insert(
        new Wochenplan().setId(UUID.randomUUID()).setBenutzerId(wochenplan.getBenutzerId())
            .setName(wochenplan.getName()));
  }
}
