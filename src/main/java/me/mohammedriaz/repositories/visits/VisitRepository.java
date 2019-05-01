package me.mohammedriaz.repositories.visits;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface VisitRepository extends Repository<Visit, Integer> {


    Set<Visit> getAll();


}
