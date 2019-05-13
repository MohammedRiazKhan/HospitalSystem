package me.mohammedriazkhan.repository.visits;

import me.mohammedriazkhan.domain.visits.Visit;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface VisitRepository extends Repository<Visit, Integer> {


    Set<Visit> getAll();


}
