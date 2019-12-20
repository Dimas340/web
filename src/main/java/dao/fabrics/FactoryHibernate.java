package dao.fabrics;

import dao.Dao;
import dao.DaoHibernateImpl;

public class FactoryHibernate extends Factory{

    @Override
    public Dao createDao() {
        return new DaoHibernateImpl();
    }
}
