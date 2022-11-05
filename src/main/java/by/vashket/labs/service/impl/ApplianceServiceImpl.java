package by.vashket.labs.service.impl;

import java.util.List;

import by.vashket.labs.dao.ApplianceDAO;
import by.vashket.labs.dao.DAOException;
import by.vashket.labs.dao.DAOFactory;
import by.vashket.labs.dao.impl.FileApplianceDAOImpl;
import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;
import by.vashket.labs.service.ApplianceService;
import by.vashket.labs.service.ServiceException;
import by.vashket.labs.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

    @Override
    public List<Appliance> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliances;

        try {
            appliances = applianceDAO.find(criteria);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        // you may add your own code here

        return appliances;
    }

}

//you may add your own new classes
