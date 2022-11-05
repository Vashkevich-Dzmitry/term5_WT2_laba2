package by.vashket.labs.dao;

import by.vashket.labs.dao.impl.FileApplianceDAOImpl;
import by.vashket.labs.dao.impl.SQLApplianceDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new FileApplianceDAOImpl();

    private DAOFactory() {}

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}