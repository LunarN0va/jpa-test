import nl.han.oose.dea.jpatest.Playlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateJavaTest {

    private SessionFactory sessionFactory;


    @BeforeEach
    private void setup() throws Exception {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources( standardServiceRegistry ).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }



    @Test
    public void save_my_first_object_to_the_db() {
        Playlist playlist = new Playlist("Death Metal", "Ryan Kroon");


        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(playlist);

            session.getTransaction().commit();
        }
    }

    @Test
    @Disabled
    public void how_does_hibernate_work() {
        Playlist playlist = null;

    }
}
