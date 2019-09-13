package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.visit.impl.VisitRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitRepositoryTest {

    @Autowired
    private VisitRepositoryImpl visitRepository;

    @Test
    public void create() {

        Visit visit = VisitFactory.getVisit( "Today", null, null, null, null, null);

        visitRepository.create(visit);

        assertNotNull(visitRepository.getAll());

    }

    @Test
    public void read() {

        Visit visit = VisitFactory.getVisit("Today", null, null, null, null, null);

        visitRepository.create(visit);

        assertNotNull(visitRepository.getAll());

        Visit visit1 = visitRepository.read(visit.getVisitId());

        assertEquals(visit, visit1);

    }

    @Test
    public void update() {

        Visit visit = VisitFactory.getVisit( "Today", null, null, null, null, null);

        visitRepository.create(visit);

        assertNotNull(visitRepository.getAll());

        Visit visitUpdate = VisitFactory.getVisit("sdf", null, null, null, null, null);
        visitUpdate.setVisitId(visit.getVisitId());
        visitRepository.update(visitUpdate);

        Visit updated = visitRepository.read(visitUpdate.getVisitId());

        assertEquals(visitUpdate, updated);

    }

    @Test
    public void delete() {

        Visit visit = VisitFactory.getVisit("Today", null, null, null, null, null);

        visitRepository.create(visit);

        assertNotNull(visitRepository.getAll());

        visitRepository.delete(visit.getVisitId());

        Visit notThere = visitRepository.read(visit.getVisitId());

        assertNull(notThere);

    }
}