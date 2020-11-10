# Status dos Serviços NF-e
Este é um projeto como exemplo para utilização de Spring Boot e Angular 10.

Esta parte back-end interpreta os Status disponibilizados oficialmente no [Portal da Nota Fiscal Eletrônica](http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx)
utilizando [JSoup](https://jsoup.org/) como manipulador HTML, e em seguida armazena-os no Banco de Dados utilizando JPA.

Este projeto exige o SGBD MySQL, e para executá-lo, é necessário informar por linha de comando as seguintes variáveis de ambiente:
--mysqlusername 
--mysqlpassword 
--mysqlurl

Por exemplo: --mysqlusername=root --mysqlpassword=rootteste --mysqlurl=localhost:3306/StatusNFE?createDatabaseIfNotExist=true&serverTimezone=UTC

Os webservices são disponibilizados na porta 8080, verifique a disponibilidade da mesma antes de iniciar.

Clique [aqui](https://github.com/Giovanifsa/NFEStatusFrontend) para visualizar o projeto Angular que fornece a visualização dos dados.
