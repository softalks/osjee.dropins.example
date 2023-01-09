[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://www.paypal.com/donate/?business=7JXD6EDFHXF5C&no_recurring=0&item_name=To+allow+the+development%2C+maintenance+and+evolution+of+a+kind+of+software+that+would+not+exist+outside+the+donationware+model&currency_code=USD)
> Before using this project you must download the [dsu](https://github.com/softalks/dsu), [osjee](https://github.com/softalks/osjee) and [osjee.dropins](https://github.com/softalks/osjee.dropins) project's code and run `mvn install` for each of them. They will be properly packaged in a near future to avoid this requirement
# [OSJEe](https://github.com/softalks/osjee) Dropins Example
This project specifies the behavior provided by the [osjee.dropins](https://github.com/softalks/osjee.dropins) project

Run `mvn post-clean verify` to 
* [install](https://github.com/OpenLiberty/ci.maven/blob/main/docs/create.md#create) an [Open Liberty](https://openliberty.io/) server with the [Java Servlets](https://openliberty.io/docs/latest/reference/feature/servlet-4.0.html) (4.0) and [OSGi Debug Console](https://openliberty.io/docs/latest/reference/feature/osgiConsole-1.0.html) features
* [build](https://github.com/softalks/osjee.dropins.example/blob/main/contexts/dynamic/pom.xml) the `/dynamic` web context (WAR) and deploy it to the server dropins directory
* build the [bundle](https://en.wikipedia.org/wiki/OSGi#Bundles) (JAR) providing the`/dynamic/hello` servlet and deploy it to the directory [selected](https://felix.apache.org/documentation/subprojects/apache-felix-file-install.html#_setup) for bundle dropins
* build and deploy the `/static` web context with its `/static/hello` servlet (for comparison purposes only)
* [start](https://github.com/OpenLiberty/ci.maven/blob/main/docs/start.md#start) the server with a dropins aware OSGi framework attached to the `/dynamic` context

After changing (Hello by Hi?) the source code of any of the servlets you must run `mvn clean package`
* from `./bundle` to update the [dynamic servlet](https://github.com/softalks/osjee.example/blob/main/bundle/src/main/java/bundle/Hello.java) JAR
* from `./contexts/static` to update the [static servlet](https://github.com/softalks/osjee.example/blob/main/contexts/static/src/main/java/war/Hello.java) WAR

To check how changes affect running clients run `./loop.sh dynamic` or `./loop.sh static` ([bash](https://es.wikipedia.org/wiki/Bash) required) before updating the corresponding component. You should never get errors from the former on updates to the dynamic servlet while the latter could, frequently, show [HTTP 404](https://en.wikipedia.org/wiki/HTTP_404) errors on updates to the static one
