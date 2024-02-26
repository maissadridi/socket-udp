# socket-udp
Le but de ce TP est de montrer la mise en œuvre du protocole de transport UDP (mode non connecté) au moyen des sockets en Java.

### Emission
1. Création d’un socket UDP. Pour cela, utilisez un constructeur de la classe
Java.net.DatagramSocket.
2. Fabrication d’un paquet avec les données à envoyer ;
3. Envoyer le paquet à travers le socket.
4. Recommencer l ́étape de fabrication si nécessaire.
### Réception
1. Création d’un socket UDP sur un port spécifique (le port de réception des données).
Pour cela, utilisez un constructeur de la classe Java.net.DatagramSocket;
2. Préparation d’un paquet coquille pour la réception des données ;
3. Attendre la réception d’un paquet ;
4. Récupérer les informations contenues dans le paquet si nécessaire (adresse et port
de l ́émetteur, données).
5. Utilisez les données en fonction de vos besoins.