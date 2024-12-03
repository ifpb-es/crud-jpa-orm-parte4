package br.edu.ifpb.es.daw.dao.bidirecional.impl;

import br.edu.ifpb.es.daw.dao.bidirecional.OrderDAO;
import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.Order;
import jakarta.persistence.EntityManagerFactory;

public class OrderDAOImpl extends AbstractDAOImpl<Order, Long> implements OrderDAO {

    public OrderDAOImpl(EntityManagerFactory emf) {
        super(Order.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "Order_BI";
    }

}
