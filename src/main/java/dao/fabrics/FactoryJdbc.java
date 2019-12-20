package dao.fabrics;

import dao.Dao;
import dao.DaoJdbcImpl;

public class FactoryJdbc extends Factory {

    @Override
    public Dao createDao() {
        return new DaoJdbcImpl();
    }
}
