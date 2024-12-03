package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.bidirecional.ArtistDAO;
import br.edu.ifpb.es.daw.dao.bidirecional.CdDAO;
import br.edu.ifpb.es.daw.dao.bidirecional.impl.ArtistDAOImpl;
import br.edu.ifpb.es.daw.dao.bidirecional.impl.CdDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.Artist;
import br.edu.ifpb.es.daw.entities.bidirecional.CD;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class MainBiArtistCdUpdate {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			ArtistDAO artistDao = new ArtistDAOImpl(emf);
			CdDAO cdDao = new CdDAOImpl(emf);

			// Criando o artista
			Artist artist = new Artist();

			artist.setFirstName("Primeiro nome");
			artist.setLastName("Último nome " + System.nanoTime());
			List<CD> appearsOnCDs = new ArrayList<CD>();
			artist.setAppearsOnCDs(appearsOnCDs);

			// Criando o cd
			CD cd = new CD();
			cd.setTitle("Título do CD");
			cd.setPrice(25.0f);
			cd.setDescription("Descrição do CD " + System.nanoTime());
			List<Artist> createdByArtists = new ArrayList<Artist>();
			cd.setCreatedByArtists(createdByArtists);

			System.out.println(artist);
			System.out.println(cd);

			// Salvando o artista e o cd
			artistDao.save(artist);
			cdDao.save(cd);

			System.out.println(artist);
			System.out.println(cd);
			
			// Fazendo associação entre o artista e o CD
			artist.getAppearsOnCDs().add(cd);
			cd.getCreatedByArtists().add(artist);
			
			// Atualizando a associação
			artistDao.update(artist);
			System.out.println(artist);
			System.out.println(cd);

			// Depois atualizar
			artist.setFirstName("Primeiro nome modificado");
			cd.setDescription("Outra descrição do CD");

			artistDao.update(artist);
			cdDao.update(cd);

			System.out.println(artist);
			System.out.println(cd);
		}
	}

}
