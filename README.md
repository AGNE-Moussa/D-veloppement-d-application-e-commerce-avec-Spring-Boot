# Application de Gestion des Commandes et des Produits

Cette application est une solution de gestion des commandes et des produits développée avec Spring Boot et Spring Cloud. Elle est composée de plusieurs microservices, notamment un service de commandes, un service de produits, une passerelle API, un serveur d'enregistrement Eureka, et un exemple d'utilisation de RabbitMQ.

## Prérequis

- Java 17 ou supérieur
- Maven

## Composition de l'Application

- **commandes-service** : Microservice gérant les commandes
- **produits-service** : Microservice gérant les produits
- **gateway** : Passerelle API pour router les requêtes vers les microservices
- **serveur-registre** : Serveur d'enregistrement Eureka pour la découverte de services
- **rabittmq** : Exemple d'utilisation de RabbitMQ pour la communication asynchrone

## Exécution

Démarrez chaque application dans l'ordre suivant :

1. `serveur-registre`
2. `commandes-service`
3. `produits-service`
4. `gateway`
5. `rabittmq` (optionnel)

## Architecture

Cette application suit une architecture de microservices avec une découverte de services via Eureka. Les microservices sont accessibles via une passerelle API (gateway) qui gère l'authentification et le routage des requêtes. La communication asynchrone entre les services est illustrée avec l'exemple de RabbitMQ.
