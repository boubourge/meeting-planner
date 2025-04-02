J'ai imaginé toute l'API mais je me suis concentré sur les endpoint disponibles pour une démo, à savoir : Récupération des salles disponibles et compatibles.

Un swagger liste les endpoints manquants.
J'ai également commencé une campagne de tests unitaires.

Des scripts sont disponibles pour initialiser la BDD.

Difficultés rencontrées :
-> Génération des swaggers
-> Incompatibilité probable des versions Lombok / Mapstruct
-> Une dépendance javax qui rendait mes entités non reconnues

Dans l'état le boot sort en erreur au niveau de la requête SQL, qui vient probablement d'un problème au niveau de mes entités, de ma requête ou de ma configuration datasource.
J'aurais aimé pouvoir vous présenter un appel postman lors de notre rencontre mais par manque de temps j'ai choisi de m'arrêter là pour me concentrer sur les TUs.

Pour conclure, c'était un projet très intéressant mais j'ai peut-être voulu trop en faire pour les 2 jours à ma disposition, qui comprenaient les installations de mon PC de dev, la conception et les devs.