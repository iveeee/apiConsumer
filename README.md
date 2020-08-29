# apiConsumer

running the app
-import all maven projects
-run com.api.consumer.ApiConsumerApplication class or mvn spring-boot:run in CLI
-default access in your localhost:8080/index

services available
-GET /search {projectName} - connects to https://api.github.com/search/repositories to get repository
-GET /getDetails {owner}{name} - connect to https://api.github.com/repos/{owner}/{repo}/stats/contributors to get committers and commit count
-GET /save {owner}{name} - saves repository details to local database (h2) for later access

tested on the following projects
/HandlebarLabs/currency-converter-starter
/exchangeratesapi/exchangeratesapi
/kanboard/kanboard
