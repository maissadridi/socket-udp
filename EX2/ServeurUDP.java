package EX2;

import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);

            // Réception de l'objet voiture envoyé par le client
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Conversion du tableau d'octets en objet voiture
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            voiture receivedCar = (voiture) ois.readObject();

            // Affichage de la quantité de carburant reçue
            System.out.println("Quantité de carburant reçue du client : " + receivedCar.getCarburant() + " litres.");

            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
