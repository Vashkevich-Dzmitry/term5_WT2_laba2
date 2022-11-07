package by.vashket.labs.service.validation;

import by.vashket.labs.entity.criteria.Criteria;
import by.vashket.labs.entity.criteria.SearchCriteria;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        try {
            for (String criteriaName : criteria.getCriteria().keySet()) {
                switch (criteria.getGroupSearchName()) {
                    case "laptop":
                        SearchCriteria.Laptop.valueOf(criteriaName);
                        break;
                    case "oven":
                        SearchCriteria.Oven.valueOf(criteriaName);
                        break;
                    case "refrigerator":
                        SearchCriteria.Refrigerator.valueOf(criteriaName);
                        break;
                    case "speakers":
                        SearchCriteria.Speakers.valueOf(criteriaName);
                        break;
                    case "tabletpc":
                        SearchCriteria.TabletPC.valueOf(criteriaName);
                        break;
                    case "vacuumcleaner":
                        SearchCriteria.VacuumCleaner.valueOf(criteriaName);
                        break;
                        case "teapot":
                        SearchCriteria.Teapot.valueOf(criteriaName);
                        break;
                    default:
                        return false;
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }


}