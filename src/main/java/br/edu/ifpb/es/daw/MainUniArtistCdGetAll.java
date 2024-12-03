package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.unidirecional.impl.ArtistDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.impl.CdDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.ArtistDAO;
import br.edu.ifpb.es.daw.dao.unidirecional.CdDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Artist;
import br.edu.ifpb.es.daw.entities.unidirecional.CD;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUniArtistCdGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			ArtistDAO artistDao = new ArtistDAOImpl(emf);
			CdDAO cdDAO = new CdDAOImpl(emf);

			List<Artist> artists = artistDao.getAll();
			System.out.println("Artists:");
			for (Artist artist : artists) {
				System.out.println(artist);
			}

			List<CD> cds = cdDAO.getAll();
			System.out.println("CDs:");
			for (CD cd : cds) {
				System.out.println(cd);
			}
		}
	}

}
