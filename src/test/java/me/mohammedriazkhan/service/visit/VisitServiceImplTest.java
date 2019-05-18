package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.visit.VisitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.visit.impl.VisitServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitServiceImplTest {

    @Autowired
    VisitServiceImpl visitService;


    @Test
    public void create() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        assertNotNull(visitService.getAll());

    }

    @Test
    public void read() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        assertNotNull(visitService.getAll());

        Visit visit1 = visitService.read(visit.getVisitId());

        assertEquals(visit, visit1);

    }

    @Test
    public void update() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        assertNotNull(visitService.getAll());

        Visit visitUpdate = VisitFactory.getVisit(1, "sdf", null, null, null, null, null);
        visitUpdate.setVisitId(visit.getVisitId());
        visitService.update(visitUpdate);

        Visit updated = visitService.read(visitUpdate.getVisitId());

        assertEquals(visitUpdate, updated);

    }

    @Test
    public void delete() {

        Visit visit = VisitFactory.getVisit(1, "Today", null, null, null, null, null);

        visitService.create(visit);

        assertNotNull(visitService.getAll());

        visitService.delete(visit.getVisitId());

        Visit notThere = visitService.read(visit.getVisitId());

        assertNull(notThere);

    }
}