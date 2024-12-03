package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.unidirecional.impl.CustomerDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.CustomerDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Customer;
import br.edu.ifpb.es.daw.entities.unidirecional.Address;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUniCustomerUpdate {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			CustomerDAO dao = new CustomerDAOImpl(emf);

			// Primeiro salvar
			Customer customer = new Customer();

			customer.setFirstName("João");
			customer.setLastName("Silva");
			customer.setPhoneNumber("(83) 1234 5678");
			customer.setEmail("joao.silva80@email.com");
			Address address = new Address();
			address.setStreet1("street1");
			address.setStreet2("street2");
			address.setZipcode("123456");
			address.setCity("city");
			address.setCountry("country");
			address.setState("state");
			customer.setAddress(address);

			dao.save(customer);

			System.out.println(customer);

			// Depois atualizar
			customer.setFirstName("Primeiro nome modificado");
			customer.getAddress().setStreet1("outro endereço 1");

			dao.update(customer);

			System.out.println(customer);
		}
	}

}
