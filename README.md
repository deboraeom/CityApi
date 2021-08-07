 . cityApi
 . Este é um projeto desenvolvido nas aulas do BootCamp EverisQuality<br>
 . Ele foi desenvolvido com SpringBoot, Postegree, Java <br>
 . Ele retorna a lista de países e estados no banco de dados Postegrees usando as URLS:<br>

localhost:8080/state<br>
localhost:8080/countries<br>

https://still-crag-58269.herokuapp.com/state<br>
https://still-crag-58269.herokuapp.com/countries<br>

. E as distância entre duas cidades, quando se passa por paramentro o id(id1 e id2) das cidades:<br>

Em millhas:<br>
localhost:8080/distances/by-points?from=id1&to=id2<br>
https://still-crag-58269.herokuapp.com/distances/by-points?from=id1&to=id2<br>


Em metros<br>
localhost:8080/distances/by-cube?from=4929&to=4930<br>
https://still-crag-58269.herokuapp.com/distances/by-cube?from=4929&to=4930<br>


. Para configurar o banco localmente é necessário a imagem no docker<br>
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres<br>

 . Baixar os dados do banco:<br>

https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL<br>

 . E dentro do diretório(postegree) rodar os seguites comandos:<br>

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash<br>

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql<br>
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql<br>
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql<br>

psql -h localhost -U postgres_user_city cities<br>

CREATE EXTENSION cube; <br>
CREATE EXTENSION earthdistance;<br>

. O projeto original é do professor Andre Gomes: <br>
https://github.com/andrelugomes/digital-innovation-one/blob/master/cities-api<br>

. Eu refiz ele com Maven em vez de  Gradlew e adicionei os StateService e CountryService.<br>
