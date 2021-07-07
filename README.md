 cityApi
 Este é um projeto desenvolvido nas aulas do BootCamp EverisQuality
 Ele foi desenvolvido com SpringBoot, Postegree, Java 
 Ele retorna a lista de países e estados no banco de dados Postegrees usando as URLS:

localhost:8080/state
localhost:8080/countries

https://still-crag-58269.herokuapp.com/state
https://still-crag-58269.herokuapp.com/countries

 E as distância entre duas cidades, quando se passa por paramentro o id(id1 e id2) das cidades:

Em millhas:
localhost:8080/distances/by-points?from=id1&to=id2
https://still-crag-58269.herokuapp.com/distances/by-points?from=id1&to=id2


Em metros
localhost:8080/distances/by-cube?from=4929&to=4930
https://still-crag-58269.herokuapp.com/distances/by-cube?from=4929&to=4930


Para configurar o banco localmente é necessário a imagem no docker
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

 Baixar os dados do banco:

https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL

 E dentro do diretório(postegree) rodar os seguites comandos:

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;

O projeto original é do professor Andre Gomes: 
https://github.com/andrelugomes/digital-innovation-one/blob/master/cities-api

Eu refiz ele com Maven em vez de  Gradlew e adicionei os StateService e CountryService.
