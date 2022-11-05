package by.vashket.labs.dao;

import java.util.List;

import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria) throws DAOException;

}
