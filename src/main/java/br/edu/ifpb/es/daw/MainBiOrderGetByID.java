package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.bidirecional.OrderDAO;
import br.edu.ifpb.es.daw.dao.bidirecional.impl.OrderDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.Order;
import br.edu.ifpb.es.daw.entities.bidirecional.OrderLine;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainBiOrderGetByID {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			OrderDAO dao = new OrderDAOImpl(emf);

			// Primeiro salvar
			Order order = new Order();

			order.setCreationDate(LocalDateTime.now());
			order.setNumber(UUID.randomUUID());
			List<OrderLine> orderLines = new ArrayList<OrderLine>();

			OrderLine orderLine1 = new OrderLine();
			orderLine1.setItem("item 1");
			orderLine1.setQuantity(2);
			orderLine1.setUnitPrice(10.0);
			orderLine1.setOrder(order);
			orderLines.add(orderLine1);

			OrderLine orderLine2 = new OrderLine();
			orderLine2.setItem("item 2");
			orderLine2.setQuantity(3);
			orderLine2.setUnitPrice(20.0);
			orderLine2.setOrder(order);
			orderLines.add(orderLine2);

			order.setOrderLines(orderLines);
			
			dao.save(order);

			// Depois recuperar pelo identificador
			Order resultado = dao.getByID(order.getId());

			System.out.println(order.equals(resultado));
		}
	}

}
