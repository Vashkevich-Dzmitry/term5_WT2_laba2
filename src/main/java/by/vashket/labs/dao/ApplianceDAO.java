package by.vashket.labs.dao;

import java.util.ArrayList;

import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;

public interface ApplianceDAO {

    ArrayList<Appliance> find(Criteria criteria) throws DAOException;

}
