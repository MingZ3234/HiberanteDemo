import com.example.Dept;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class main_search {
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
            //没有条件的hql，也就是查询全部记录。
            String hql = "from Dept where deptno = 2";
            Query hqlQuery = session.createQuery(hql);
            List<Dept> list = hqlQuery.list();
            for(Dept dept : list){
                System.out.println(dept.toString());
            }
        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}