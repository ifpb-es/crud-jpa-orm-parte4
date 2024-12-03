package br.edu.ifpb.es.daw.dao.unidirecional.impl;

import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.ArtistDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.Artist;
import jakarta.persistence.EntityManagerFactory;

public class ArtistDAOImpl extends AbstractDAOImpl<Artist, Long> implements ArtistDAO {

    public ArtistDAOImpl(EntityManagerFactory emf) {
        super(Artist.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "Artist_UNI";
    }

}
