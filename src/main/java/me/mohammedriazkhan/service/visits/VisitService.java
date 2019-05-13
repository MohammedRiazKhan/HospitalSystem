package me.mohammedriazkhan.service.visits;

import me.mohammedriazkhan.domain.visits.Visit;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface VisitService extends Service<Visit, Integer> {

    Set<Visit> getAll();

}
