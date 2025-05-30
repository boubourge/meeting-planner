Bonjour, voici mon projet exercice pour SNCF Connect.

J'ai imaginé toute l'API mais je me suis concentré sur la finalisation d'un endpoint, à savoir : Récupération des salles disponibles et compatibles.

Un swagger liste les endpoints manquants.
J'ai également commencé une campagne de tests unitaires.

Des scripts sont disponibles pour initialiser la BDD, ainsi que la collection Postman pour les tests manuels.

Voici les difficultés rencontrées :
-> Génération des swaggers
-> Incompatibilité probable des versions Lombok / Mapstruct
-> Une dépendance javax qui rendait mes entités non reconnues
-> Des soucis au niveau de la casse de ma requête SQL

Dans l'état le boot se fait et j'accède au service via Postman pour récupérer la liste des salles disponibles.
Les checks java fonctionnent bien mais la requête me retourne quand même les salles réservées.
Je pense à un problème de format de date dans la requête générée par Hibernate car en testant la requête manuellement cela fonctionne.

J'aurais aimé pouvoir présenter le service de réservation d'une salle mais par manque de temps j'ai choisi de m'arrêter là pour me concentrer sur les TUs.

Pour conclure, c'était un projet très intéressant mais j'ai peut-être voulu trop en faire pour les 2 jours à ma disposition, qui comprenaient les installations de mon PC de dev, la conception et les devs.

Lien vers le swagger : https://github.com/boubourge/meeting-planner/blob/main/src/main/resources/swaggers/meetingplannerapi.yaml