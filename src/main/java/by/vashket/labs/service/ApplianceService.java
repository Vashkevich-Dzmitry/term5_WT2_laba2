package by.vashket.labs.service;

import java.util.ArrayList;

import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;

public interface ApplianceService {

    ArrayList<Appliance> find(Criteria criteria) throws ServiceException;

    Appliance findLowestCostAppliance() throws ServiceException;

}