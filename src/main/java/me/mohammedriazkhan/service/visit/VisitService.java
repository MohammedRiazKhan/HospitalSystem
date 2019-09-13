package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface VisitService extends Service<Visit, String> {

    Set<Visit> getAll();

}
