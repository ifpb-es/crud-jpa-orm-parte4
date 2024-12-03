package br.edu.ifpb.es.daw.dao.bidirecional.impl;

import br.edu.ifpb.es.daw.dao.bidirecional.CdDAO;
import br.edu.ifpb.es.daw.dao.impl.AbstractDAOImpl;
import br.edu.ifpb.es.daw.entities.bidirecional.CD;
import jakarta.persistence.EntityManagerFactory;

public class CdDAOImpl extends AbstractDAOImpl<CD, Long> implements CdDAO {

    public CdDAOImpl(EntityManagerFactory emf) {
        super(CD.class, emf);
    }

    @Override
    protected String getEntityName() {
        return "CD_BI";
    }

}
