package dao;

public class SpecificFactory {
    private static Dao dao;

    void createConnection(String tapeConnection) {
        switch (tapeConnection) {
            case "jdbc" : dao = new DaoJdbcImpl();
            break;

            case "hibernate" : dao = new DaoHibernateImpl();
            break;
        }
    }

    public Dao getDao() {
        return dao;
    }
}
