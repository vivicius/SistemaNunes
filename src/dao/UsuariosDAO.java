/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VmanUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u06716483144
 */
public class UsuariosDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanUsuarios.class);
        criteria.add(Restrictions.eq("vmanIdusuarios", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public VmanUsuarios buscarPorApelido(String apelido) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(VmanUsuarios.class);
        criteria.add(Restrictions.eq("vmanApelido", apelido));

        VmanUsuarios usuario = (VmanUsuarios) criteria.uniqueResult();

        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

}
