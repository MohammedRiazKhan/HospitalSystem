package me.mohammedriazkhan.repositories.visits;

import me.mohammedriazkhan.domain.visits.Visit;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface VisitRepository extends Repository<Visit, Integer> {


    Set<Visit> getAll();


}
