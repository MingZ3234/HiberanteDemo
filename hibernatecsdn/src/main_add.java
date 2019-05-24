import com.example.Dept;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;


public class main_add {
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
            dept.setDbSource("clodudb02");
            dept.setDeptno(200);
            dept.setDname("zzz");
            session.save(dept);

            transaction.commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}