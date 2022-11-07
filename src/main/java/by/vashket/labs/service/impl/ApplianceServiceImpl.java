package by.vashket.labs.service.impl;

import java.util.ArrayList;
import java.util.Map;

import by.vashket.labs.dao.ApplianceDAO;
import by.vashket.labs.dao.DAOException;
import by.vashket.labs.dao.DAOFactory;
import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;
import by.vashket.labs.service.ApplianceService;
import by.vashket.labs.service.ServiceException;
import by.vashket.labs.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

    @Override
    public ArrayList<Appliance> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        ArrayList<Appliance> appliances = new ArrayList<>() {};

        try {
            ArrayList<Appliance> applianceInfos = applianceDAO.find(criteria);

            for (Appliance appliance : applianceInfos) {
                if (isMeetsCriteria(appliance, criteria)) {
                    appliances.add(appliance);
                }
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            return appliances;
        }



    }

    private boolean isMeetsCriteria(Appliance appliance, Criteria criteria){
        for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
            if (!appliance.getFieldByName(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

}
