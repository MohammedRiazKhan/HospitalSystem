package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.visit.impl.VisitRepositoryImpl;

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

        Visit visit1 = visitRepository.read(visit.getVisitId());

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

        Visit updated = visitRepository.read(visitUpdate.getVisitId());

        Assert.assertEquals(visitUpdate, updated);

    }

    @Test
    public void delete() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitRepository.create(visit);

        Assert.assertNotNull(visitRepository.getAll());

        visitRepository.delete(visit.getVisitId());

        Visit notThere = visitRepository.read(visit.getVisitId());

        Assert.assertNull(notThere);

    }
}