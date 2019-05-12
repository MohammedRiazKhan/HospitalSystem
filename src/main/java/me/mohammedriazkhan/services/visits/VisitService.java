package me.mohammedriazkhan.services.visits;

import me.mohammedriazkhan.domain.visits.Visit;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface VisitService extends Service<Visit, Integer> {

    Set<Visit> getAll();

}
