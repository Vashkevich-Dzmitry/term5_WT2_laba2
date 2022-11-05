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

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 3);

        appliances = service.find(criteriaOven);

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        appliances = service.find(criteriaOven);

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);


        appliances = service.find(criteriaOven);// find(Object...obj)


        PrintApplianceInfo.print(appliances);

    }

}
