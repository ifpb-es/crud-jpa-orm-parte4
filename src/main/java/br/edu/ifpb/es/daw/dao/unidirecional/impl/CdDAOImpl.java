package br.edu.ifpb.es.daw.dao.unidirecional.impl;

import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.dao.unidirecional.CdDAO;
import br.edu.ifpb.es.daw.entities.unidirecional.CD;
import jakarta.persistence.EntityManagerFactory;

public class CdDAOImpl extends AbstractDAOImpl<CD, Long> implements CdDAO {

    public CdDAOImpl(EntityManagerFactory emf) {
        super(CD.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "CD_UNI";
    }

}
