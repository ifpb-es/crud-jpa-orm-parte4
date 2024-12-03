package br.edu.ifpb.es.daw.dao.bidirecional.impl;

import br.edu.ifpb.es.daw.dao.bidirecional.ArtistDAO;
import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.Artist;
import jakarta.persistence.EntityManagerFactory;

public class ArtistDAOImpl extends AbstractDAOImpl<Artist, Long> implements ArtistDAO {

    public ArtistDAOImpl(EntityManagerFactory emf) {
        super(Artist.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "Artist_BI";
    }

}
