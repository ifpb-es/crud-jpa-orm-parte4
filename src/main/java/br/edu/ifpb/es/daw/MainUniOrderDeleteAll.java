package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.unidirecional.impl.OrderDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.OrderDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Order;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUniOrderDeleteAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			OrderDAO dao = new OrderDAOImpl(emf);

			List<Order> orders = dao.getAll();
			for (Order order : orders) {
				dao.delete(order.getId());
			}
		}
	}

}
