package project1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("sprintFrameworkBean.xml");
        UserDetails userDetails = (UserDetails) applicationContext2.getBean("userDetails");
        Family famiy = (Family) applicationContext2.getBean("family");
        Child child = (Child) applicationContext2.getBean("child");
        Laptop laptop = (Laptop) applicationContext2.getBean("laptops");


        Configuration conf = new Configuration().configure().addAnnotatedClass(UserDetails.class)
                                                            .addAnnotatedClass(Family.class)
                                                            .addAnnotatedClass(Laptop.class)
                                                            .addAnnotatedClass(Child.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = conf.buildSessionFactory(reg);
        Session session = sessionFactory.openSession();




        Transaction tx = session.beginTransaction();

        session.save(userDetails);
        session.save(famiy);
        //session.save(laptop);
        //child kaydedilmedi
        tx.commit();
        session.close();

        //-----------------------------//
        //var olan session ile database.deki datalari cekebiliriz.
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        UserDetails userObject = new UserDetails();
        //sessiondan gelen verileri cast. etmek gerekir.
//            userObject = (UserDetails) session.get(UserDetails.class,2);
//            System.out.println("\t- search information");
//            @GeneratedValue ekleyince get UserId null oluyor.
//            System.out.println("user ID" + userObject.getUserId());
//            System.out.println("user name: " + userObject.getUserName());

        //fetch lazy operations bean konusu ile calisilmalı..hata vermeden calisiyor
//        session = sessionFactory.openSession();
//        userDetails = (UserDetails) session.get(UserDetails.class,1);
//        session.close();
//        System.out.println(userDetails.getAdress().getCity());
//        System.out.println(userDetails.getWorkAdress().getCity());
//        System.out.println(userDetails.getUserName());




    }
}
