package by.vashket.labs.service;

import java.util.List;

import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria) throws ServiceException;

}