package by.vashket.labs.main;

import static by.vashket.labs.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;
import by.vashket.labs.entity.criteria.SearchCriteria;
import by.vashket.labs.service.ApplianceService;
import by.vashket.labs.service.ServiceException;
import by.vashket.labs.service.ServiceFactory;

public class Main {

    public static void main(String[] args) throws ServiceException {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTeapot = new Criteria(Teapot.class.getSimpleName());//"Oven"

        appliances = service.find(criteriaTeapot);

        PrintApplianceInfo.print(appliances); //чайники

        //////////////////////////////////////////////////////////////////



        //PrintApplianceInfo.print(appliances);

    }

}
