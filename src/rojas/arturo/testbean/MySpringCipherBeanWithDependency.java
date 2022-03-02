package rojas.arturo.testbean;

import org.springframework.beans.factory.annotation.Autowired;
import rojas.arturo.writer.Encripta;

public class MySpringCipherBeanWithDependency {

    private Encripta encripta;

    @Autowired
    public void setEncriptador(Encripta encriptador) {
        this.encripta = encriptador;
    }

    public void run() {
        System.out.println(encripta.encripta("hola soy arturo"));
        System.out.println(encripta.desencripta("ovsh zvf hyabyv"));
    }


}
