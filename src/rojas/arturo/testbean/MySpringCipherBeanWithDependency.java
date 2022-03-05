package rojas.arturo.testbean;

import org.springframework.beans.factory.annotation.Autowired;
import rojas.arturo.cipher.Encripta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MySpringCipherBeanWithDependency {

    private Encripta encripta;

    @Autowired
    public void setEncriptador(Encripta encriptador) {
        this.encripta = encriptador;
    }

    //ambos encriptadores aceptan espacios
    public void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Digite el texto a encriptar");
        System.out.println(encripta.encripta(in.readLine()));

        System.out.println("Presione 1 para desencriptar texto, o cualquier otra tecla para salir.");

        if (in.readLine().equals("1")){
            System.out.println("Digite el texto a desencriptar");
            System.out.println(encripta.desencripta(in.readLine()));
        }
    }

}
