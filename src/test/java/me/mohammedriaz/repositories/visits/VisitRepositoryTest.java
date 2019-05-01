package me.mohammedriaz.repositories.visits;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.factories.visits.VisitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriaz.repositories.Impl.VisitRepositoryImpl;

public class VisitRepositoryTest {

    VisitRepositoryImpl visitRepository;

    @Before
    public void setUp() throws Exception {

        visitRepository = VisitRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitRepository.create(visit);

        Assert.assertNotNull(visitRepository.getAll());

    }

    @Test
    public void read() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitRepository.create(visit);

        Assert.assertNotNull(visitRepository.getAll());

        Visit visit1 = visitRepository.find(visit.getVisitId());

        Assert.assertEquals(visit, visit1);

    }

    @Test
    public void update() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitRepository.create(visit);

        Assert.assertNotNull(visitRepository.getAll());

        Visit visitUpdate = VisitFactory.getVisit(1, "sdf", null, null, null, null, null);
        visitUpdate.setVisitId(visit.getVisitId());
        visitRepository.update(visitUpdate);

        Visit updated = visitRepository.find(visitUpdate.getVisitId());

        Assert.assertEquals(visitUpdate, updated);

    }

    @Test
    public void delete() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitRepository.create(visit);

        Assert.assertNotNull(visitRepository.getAll());

        visitRepository.delete(visit.getVisitId());

        Visit notThere = visitRepository.find(visit.getVisitId());

        Assert.assertNull(notThere);

    }
}