# About

This demoes a simple web-application containing a Message Driven Bean deployed with Wildfly. It uses the embedded Artemis message broker inside of Wildfly.


# To post a message to the queue:

	http://localhost:8080/wildfly-embedded-artemis-demo/author.html


# Configuring Wildfly

## Running Wildfly
	WILDFLY_HOME/bin/standalone.sh 

## Adding users

- Go to WILDFLY_HOME/bin/add-user
- Create a *Management User*
- Create an *Application User* with name **user**, password **user123**. It should have a role **guest**




	