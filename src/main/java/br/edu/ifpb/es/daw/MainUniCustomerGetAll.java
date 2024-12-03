package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.unidirecional.impl.CustomerDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.CustomerDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Customer;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUniCustomerGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			CustomerDAO dao = new CustomerDAOImpl(emf);

			List<Customer> customers = dao.getAll();

			for (Customer customer : customers) {
				System.out.println(customer);
			}

		}
	}

}
