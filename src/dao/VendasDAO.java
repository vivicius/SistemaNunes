package dao;

import bean.VmanClientes;
import bean.VmanVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class VendasDAO extends AbstractDAO {

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
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanVendas.class);
        criteria.add(Restrictions.eq("vmanIdVendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCliente(String clientes) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanVendas.class);

        criteria.createAlias("vmanClientes", "c");
        criteria.add(Restrictions.like("c.vmanNome", "%" + clientes + "%", MatchMode.ANYWHERE));

        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listVendedor(String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanVendas.class);

        criteria.createAlias("vmanVendedor", "v");
        criteria.add(Restrictions.like("v.vmanNome", "%" + vendedor + "%", MatchMode.ANYWHERE));

        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listClienteVendedor(String clientes, String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanVendas.class);

        criteria.createAlias("vmanClientes", "c");
        criteria.add(Restrictions.like("c.vmanNome", "%" + clientes + "%", MatchMode.ANYWHERE));

        criteria.createAlias("vmanVendedor", "v");
        criteria.add(Restrictions.like("v.vmanNome", "%" + vendedor + "%", MatchMode.ANYWHERE));

        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VmanVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();
    }

}
