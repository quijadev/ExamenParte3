package rojas.arturo.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rojas.arturo.testbean.MySpringCipherBeanWithDependency;

import java.io.IOException;


public class MainApp {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");

        BeanFactory factory = context;

        MySpringCipherBeanWithDependency test = (MySpringCipherBeanWithDependency) factory
                .getBean("MySpringCipherBeanWithDependency");
        test.run();

    }
}
