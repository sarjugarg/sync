package org.sync.service;

import java.util.List;

import org.sync.model.PageVisit;

public interface PageVisitService {
public String saveRecentPageVisit(PageVisit pv);
public List<PageVisit> getRecentCards(Integer userId);
}
