import com.example.Dept;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class main_update {
    private static final SessionFactory ourSessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

            Transaction transaction = session.beginTransaction();
            Dept dept=new Dept();
            dept.setDbSource("clouddb03");
            dept.setDeptno(200);
            dept.setDname("aaa");
            session.update(dept);

            transaction.commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}