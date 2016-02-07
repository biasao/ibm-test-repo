# ibm-watson-test-repo
This is a prototype java application using IBM Watson services in Bluemix cloud platform. The application is divided into two mais components:
<ol>
  <li>
    rest-api: the rest-api is a Spring boot, web based REST component prototype, which exposes an interface to backend business logic based on Watson API. The current version makes use of <b>Translate</b> and <b>Concept Insight services</b>. More information on the prototype API may be found on <a href="http://ibm-watson-test-app.mybluemix.net/swagger-ui.html"> Swagger UI explorer</a> -- wich can be used also for testing the services. The persistence layer combines Spring data and MongoDB.
  </li>
  <li>
    client UI: javascript UI prototype, built on Angular and Kendo UI, frameworks.
  </li>
</ol>
# prototype application.
The prototype is published in Bluemix cloud platform at http://ibm-watson-test-app.mybluemix.net
The code is being publicly stored <a href="https://github.com/biasao/ibm-watson-test-app"> here at github repository</a>, and staged on <a href="https://hub.jazz.net"> IBM jazz</a> -- Continuous Integration.
