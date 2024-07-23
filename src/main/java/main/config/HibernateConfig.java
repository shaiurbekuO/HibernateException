package main.config;

import jakarta.persistence.EntityManagerFactory;
import main.entity.Course;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory entityManagerFactory() {
        try {
            Properties hibernateProperties = new Properties();
            hibernateProperties.put(Environment.DRIVER, "org.postgresql.Driver");
            hibernateProperties.put(Environment.URL, "jdbc:postgresql://localhost:5432/java14");
            hibernateProperties.put(Environment.USER, "postgres");
            hibernateProperties.put(Environment.PASS, "1234");
            hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
            hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            hibernateProperties.put(Environment.SHOW_SQL, "false");

            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProperties);
            configuration.addAnnotatedClass(Course.class);

            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
