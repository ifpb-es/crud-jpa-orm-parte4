package br.edu.ifpb.es.daw.dao.bidirecional.impl;

import br.edu.ifpb.es.daw.dao.bidirecional.CustomerDAO;
import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.Customer;
import jakarta.persistence.EntityManagerFactory;

public class CustomerDAOImpl extends AbstractDAOImpl<Customer, Long> implements CustomerDAO {

    public CustomerDAOImpl(EntityManagerFactory emf) {
        super(Customer.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "Customer_BI";
    }

}
