package EX2;

import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("SS2004");

            // Création de l'objet voiture et fixation de la quantité de carburant
            voiture myCar = new voiture("SUV", "Toyota");
            myCar.setCarburant(50); // Exemple : fixer la quantité de carburant à 50 litres

            // Conversion de l'objet voiture en tableau d'octets
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(myCar);
            byte[] sendData = baos.toByteArray();

            // Envoi de l'objet voiture au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            clientSocket.send(sendPacket);
            System.out.println("Objet voiture envoyé au serveur.");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
