package EX3;

import java.io.*;
import java.net.*;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1250);
            System.out.println("Serveur UDP démarré sur le port 1250...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Récupérer la date et l'heure courantes
                String currentDateAndTime = new Date().toString();

                // Convertir la date et l'heure en tableau d'octets
                byte[] sendData = currentDateAndTime.getBytes();

                // Créer le datagramme à envoyer au client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Envoyer le datagramme au client
                serverSocket.send(sendPacket);

                System.out.println("Date et heure envoyées à " + clientAddress + ":" + clientPort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
