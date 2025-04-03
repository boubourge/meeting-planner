J'ai imaginé toute l'API mais je me suis concentré sur les endpoint disponibles pour une démo, à savoir : Récupération des salles disponibles et compatibles.

Un swagger liste les endpoints manquants.
J'ai également commencé une campagne de tests unitaires.

Des scripts sont disponibles pour initialiser la BDD.

Difficultés rencontrées :
-> Génération des swaggers
-> Incompatibilité probable des versions Lombok / Mapstruct
-> Une dépendance javax qui rendait mes entités non reconnues
-> Des soucis au niveau de la casse de ma requête SQL

Dans l'état le boot se fait et j'accède au service via Postman mais la jointure de ma requête pose problème.
J'aurais aimé pouvoir présenter un appel postman retournant les salles disponibles mais par manque de temps j'ai choisi de m'arrêter là pour me concentrer sur les TUs.

Pour conclure, c'était un projet très intéressant mais j'ai peut-être voulu trop en faire pour les 2 jours à ma disposition, qui comprenaient les installations de mon PC de dev, la conception et les devs.

Lien vers le swagger : https://github.com/boubourge/meeting-planner/blob/main/src/main/resources/swaggers/meetingplannerapi.yaml