package by.vashket.labs.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Comparator;

import by.vashket.labs.dao.ApplianceDAO;
import by.vashket.labs.dao.DAOException;
import by.vashket.labs.dao.DAOFactory;
import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;
import by.vashket.labs.entity.criteria.SearchCriteria;
import by.vashket.labs.service.ApplianceService;
import by.vashket.labs.service.ServiceException;
import by.vashket.labs.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public ArrayList<Appliance> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        ArrayList<Appliance> appliances = new ArrayList<>() {
        };

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

    private boolean isMeetsCriteria(Appliance appliance, Criteria criteria) {
        for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
            if (!appliance.getFieldByName(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public Appliance findLowestCostAppliance() {
        ArrayList<Appliance> appliances = new ArrayList<Appliance>();
        try {
            appliances.addAll(find(new Criteria(SearchCriteria.Laptop.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Oven.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Refrigerator.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Speakers.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.TabletPC.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName())));
            appliances.addAll(find(new Criteria(SearchCriteria.Teapot.class.getSimpleName())));

            Collections.sort(appliances);//
        } catch (ServiceException e) {
        } finally {
            return appliances.get(0);
        }
    }
}
