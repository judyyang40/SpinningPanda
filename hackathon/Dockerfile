FROM openjdk
EXPOSE 8080
ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar
ADD ./dist/restlet-json.jar /srv/restlet-json.jar
ADD ./dist/json.jar /srv/json.jar
ADD ./dist/restlet-jackson.jar /srv/rest-jackson.jar
ADD ./dist/jackson-core-2.8.3.jar /srv/jackson-core-2.8.3.jar
ADD ./dist/jackson-annotations-2.8.3.jar /srv/jackson-annotations-2.8.3.jar
CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/json.jar:/srv/app.jar:/srv/rest-jackson.jar:/srv/jackson-core-2.8.3.jar:/srv/jackson-annotations-2.8.3.jar api.GumballServer