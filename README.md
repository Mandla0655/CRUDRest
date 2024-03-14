1. In order to build the following jvm config need to be set in the settings: File | Settings | Build, Execution, Deployment | Compiler
   shared build JVM options : -Djps.track.ap.dependencies=false
2. Once the app is running the default port is 8080. The swagger-ui will be accessible at the URL http://localhost:8080/swagger-ui/.
3. The swagger ui has the CRUD operations on the contract endpoint.
4. All urls are secure with the exception of the swagger document.
