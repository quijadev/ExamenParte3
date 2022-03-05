package rojas.arturo.cipher;

/* Todo mensaje se pasa a lowercase. No permite caracteres especiales. Acepta espacios, pero mensajes que se encriptan con espacio TIENEN que ser desencriptados con espacio. */

public class EncriptadorCesar implements Encripta {
    @Override
    public String encripta(String s) {
        String mensaje = s.toLowerCase();
        int offset = 7;
        StringBuilder mensajeCifrado = new StringBuilder();

        for (char letra:mensaje.toCharArray()) {
            if (letra != ' ') {
                int posOriginal = letra - 'a'; //se obtiene posicion de la letra al restarle el codigo ASCII de a a la letra
                int posNueva = (posOriginal + offset) % 26; //se obtiene la posicion cifrada de la letra. el mod asegura que se loopee el abecedario al menos 1 vez. no contempla ñ
                char letraCifrada = (char) ('a' + posNueva); //se obtiene la letra cifrada casteada a char sumandole nuevamente el codigo ASCII de a
                mensajeCifrado.append(letraCifrada); //lo añade al string
            }else{
                mensajeCifrado.append(letra); //si la letra es un espacio nada mas la mete
            }
        }
        return mensajeCifrado.toString();
    }

    @Override
    public String desencripta(String s) {
        String mensaje = s.toLowerCase();
        int offset = 26 - (7%26);
        //un offset complementario al original.

        StringBuilder mensajeDescifrado = new StringBuilder();
        //codigo duplicado. no es lo mas eficiente, pero como no puedo pasar parámetros adicionales a los métodos para definir los offsets igual sirve.

        for (char letra:mensaje.toCharArray()) {
            if (letra != ' ') {
                int posOriginal = letra - 'a';
                int posNueva = (posOriginal + offset) % 26;
                char letraCifrada = (char) ('a' + posNueva);
                mensajeDescifrado.append(letraCifrada);
            }else{
                mensajeDescifrado.append(letra);
            }
        }
        return mensajeDescifrado.toString();
    }
}
