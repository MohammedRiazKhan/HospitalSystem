package me.mohammedriaz.services.visits;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface VisitService extends Service<Visit, Integer> {

    Set<Visit> getAll();

}
