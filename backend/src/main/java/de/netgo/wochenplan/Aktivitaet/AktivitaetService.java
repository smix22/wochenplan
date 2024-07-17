package de.netgo.wochenplan.Aktivitaet;

import de.netgo.wochenplan.jooq.tables.daos.AktivitaetDao;
import de.netgo.wochenplan.jooq.tables.pojos.Aktivitaet;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AktivitaetService {

  private final AktivitaetDao aktivitaetDao;

  public AktivitaetService(final AktivitaetDao aktivitaetDao) {
    this.aktivitaetDao = aktivitaetDao;
  }

  @Transactional(readOnly = true)
  List<Aktivitaet> findAllAktivitaeten() {
    return aktivitaetDao.findAll();
  }

  @Transactional(readOnly = true)
  List<Aktivitaet> findAllAktivitaetenByWochenplanId(final UUID wochenplanId) {
    return aktivitaetDao.fetchByWochenplanId(wochenplanId);
  }

  @Transactional
  public void createAktivitaet(final AktivitaetDto aktivitaet) {
    aktivitaetDao.insert(
        new Aktivitaet().setId(UUID.randomUUID()).setWochenplanId(aktivitaet.getWochenplanId())
            .setName(aktivitaet.getName()).setWochentag(aktivitaet.getWochentag()));
  }

  @Transactional
  public void deleteAktivitaet(final UUID aktivitaetId) {
    aktivitaetDao.deleteById(aktivitaetId);
  }
}
