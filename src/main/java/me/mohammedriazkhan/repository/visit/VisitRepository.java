package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface VisitRepository extends Repository<Visit, Integer> {


    Set<Visit> getAll();


}
