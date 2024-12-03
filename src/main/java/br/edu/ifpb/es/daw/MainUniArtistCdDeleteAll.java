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

public class MainUniArtistCdDeleteAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			ArtistDAO artistDao = new ArtistDAOImpl(emf);
			CdDAO cdDAO = new CdDAOImpl(emf);

			List<Artist> artists = artistDao.getAll();
			for (Artist artist : artists) {
				artistDao.delete(artist.getId());
			}
			List<CD> cds = cdDAO.getAll();
			for (CD cd : cds) {
				cdDAO.delete(cd.getId());
			}
		}
	}

}
