package rojas.arturo.cipher;

public class EncriptadorVignere implements Encripta {

    /* Todo mensaje se pasa a uppercase. No permite caracteres especiales. Acepta espacios, pero mensajes que se encriptan con espacio TIENEN que ser desencriptados con espacio. */


    private final String clave = "HAKI";

    @Override
    public String encripta(String s) {
        StringBuilder mensajeCifrado = new StringBuilder();
        String mensaje = s.toUpperCase();

        //aqui se le resta el valor ascii de 'a' a la letra, igual que en el del cesar. se usa la variable j para iterar por las letras de la clave.
        for (int i=0, j=0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);

            if (letra != ' ') {mensajeCifrado.append((char) (((letra - 65) + (clave.charAt(j) - 65)) % 26 + 65));} //se castea a char el resultado por que si no me da los numeros
            else{mensajeCifrado.append(letra);}
            j = ++j % clave.length(); //nos mantenemos dentro de la clave
        }

        return mensajeCifrado.toString();
    }

    @Override
    public String desencripta(String s) {
        StringBuilder mensajeDescifrado = new StringBuilder();
        String mensaje = s.toUpperCase();

        for (int i=0, j=0; i<mensaje.length(); i++) { //misma lógica de loop
            char letra = mensaje.charAt(i);

            //igual que en cesar usamos un complemento del mod, pero sumando en vez de restando
            if (letra != ' ') {mensajeDescifrado.append((char) ((letra - clave.charAt(j) + 26) % 26 + 65));}
            else {mensajeDescifrado.append(letra);}
            j = ++j % clave.length();
        }

        return mensajeDescifrado.toString();
    }
}
