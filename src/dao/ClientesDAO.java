/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VmanClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u06716483144
 */
public class ClientesDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanClientes.class);
        criteria.add(Restrictions.like("vmanNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanClientes.class);
        criteria.add(Restrictions.like("vmanCpf", cpf + "%"));

        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanClientes.class);
        criteria.add(Restrictions.like("vmanNome", "%" + nome + "%"));
        criteria.add(Restrictions.like("vmanCpf", cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
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
        Criteria criteria = session.createCriteria(VmanClientes.class);
        criteria.add(Restrictions.eq("idclientes", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanClientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

}
