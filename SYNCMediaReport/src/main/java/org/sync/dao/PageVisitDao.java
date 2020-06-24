package org.sync.dao;

import java.util.List;

import org.sync.model.PageVisit;

public interface PageVisitDao {
public int saveRecentPageVisit(PageVisit pv); 
public List<PageVisit> getRecentCards(Integer userId);
}
