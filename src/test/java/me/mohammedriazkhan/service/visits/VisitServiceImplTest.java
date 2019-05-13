package me.mohammedriazkhan.service.visits;

import me.mohammedriazkhan.domain.visits.Visit;
import me.mohammedriazkhan.factory.visits.VisitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.VisitServiceImpl;

public class VisitServiceImplTest {

    VisitServiceImpl visitService;

    @Before
    public void setUp() throws Exception {

        visitService = new VisitServiceImpl();

    }

    @Test
    public void create() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        Assert.assertNotNull(visitService.getAll());

    }

    @Test
    public void read() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        Assert.assertNotNull(visitService.getAll());

        Visit visit1 = visitService.read(visit.getVisitId());

        Assert.assertEquals(visit, visit1);

    }

    @Test
    public void update() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        Assert.assertNotNull(visitService.getAll());

        Visit visitUpdate = VisitFactory.getVisit(1, "sdf", null, null, null, null, null);
        visitUpdate.setVisitId(visit.getVisitId());
        visitService.update(visitUpdate);

        Visit updated = visitService.read(visitUpdate.getVisitId());

        Assert.assertEquals(visitUpdate, updated);

    }

    @Test
    public void delete() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        Assert.assertNotNull(visitService.getAll());

        visitService.delete(visit.getVisitId());

        Visit notThere = visitService.read(visit.getVisitId());

        Assert.assertNull(notThere);

    }
}