package by.vashket.labs.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import by.vashket.labs.dao.ApplianceDAO;
import by.vashket.labs.dao.DAOException;
import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.criteria.Criteria;

public class FileApplianceDAOImpl implements ApplianceDAO{

    @Override
    public List<Appliance> find(Criteria criteria) throws DAOException {
        FileReader reader;

        try {
            reader = new FileReader("");

        }catch(FileNotFoundException e) {
            throw new DAOException(e);
        }

        return null;
    }

    // you may add your own code here

}