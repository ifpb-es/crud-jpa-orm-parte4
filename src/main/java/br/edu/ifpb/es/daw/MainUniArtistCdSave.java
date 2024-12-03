package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.unidirecional.impl.ArtistDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.impl.CdDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.ArtistDAO;
import br.edu.ifpb.es.daw.dao.unidirecional.CdDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Artist;
import br.edu.ifpb.es.daw.entities.unidirecional.CD;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class MainUniArtistCdSave {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			ArtistDAO daoArtist = new ArtistDAOImpl(emf);
			CdDAO cdDAO = new CdDAOImpl(emf);

			// Criando o artista
			Artist artist = new Artist();

			artist.setFirstName("Primeiro nome");
			artist.setLastName("Último nome " + System.nanoTime());
			artist.setAppearsOnCDs(new ArrayList<CD>());

			// Criando o cd
			CD cd = new CD();
			cd.setTitle("Título do CD");
			cd.setPrice(25.0f);
			cd.setDescription("Descrição do CD " + System.nanoTime());

			System.out.println(artist);
			System.out.println(cd);

			// Salvando o artista e o cd
			daoArtist.save(artist);
			cdDAO.save(cd);

			System.out.println(artist);
			System.out.println(cd);
			
			// Fazendo associação entre o artista e o CD
			artist.getAppearsOnCDs().add(cd);
			
			// Atualizando a associação
			daoArtist.update(artist);
			System.out.println(artist);
			System.out.println(cd);
		}
	}

}
