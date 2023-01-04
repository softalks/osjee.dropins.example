[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://www.paypal.com/donate/?business=7JXD6EDFHXF5C&no_recurring=0&item_name=To+allow+the+development%2C+maintenance+and+evolution+of+a+kind+of+software+that+can+only+exist+in+this+way&currency_code=USD)
> Before using this project you must download, build and install the [dsu](https://github.com/softalks/dsu), [osjee](https://github.com/softalks/osjee) and [osjee.dropins](https://github.com/softalks/osjee.dropins) projects. They will be properly packaged in a near future to avoid this requirement
# [OSJEE](https://github.com/softalks/osjee) Dropins Example
Run `mvn post-clean verify` from the the base directory to 
* [install](https://github.com/OpenLiberty/ci.maven/blob/main/docs/create.md#create) an [Open Liberty](https://openliberty.io/) server with the [Java Servlets](https://openliberty.io/docs/latest/reference/feature/servlet-4.0.html) (4.0) and [OSGi Debug Console](https://openliberty.io/docs/latest/reference/feature/osgiConsole-1.0.html) features
* [build](https://github.com/softalks/dsu.example/blob/main/contexts/dynamic/pom.xml) the WAR file providing the `/dynamic` web context and deploy it to the server dropins directory
* [build](https://github.com/softalks/dsu.example/blob/main/bundle/pom.xml) the OSGi bundle providing the`/dynamic/hello` servlet and deploy it to the [bundle dropins directory](https://felix.apache.org/documentation/subprojects/apache-felix-file-install.html)
* [build](https://github.com/softalks/dsu.example/blob/main/contexts/static/pom.xml) and deploy the `/static` web context and `/static/hello` servlet (for comparison purposes only)
* [start](https://github.com/OpenLiberty/ci.maven/blob/main/docs/start.md#start) the server with a dropins aware OSGi framework attached to the `/dynamic` context

Run `mvn clean package`
* from `./bundle` each time you change the [dynamic servlet](https://github.com/softalks/osjee.example/blob/main/bundle/src/main/java/bundle/Hello.java)
* from `./contexts/static` each time you change the [static servlet](https://github.com/softalks/osjee.example/blob/main/contexts/static/src/main/java/war/Hello.java)

To check how your changes affect running clients you can run `./loop.sh dynamic` or `./loop.sh static`. You should never get errors from the former when you update the dynamic servlet while the latter should show 404 errors (sometimes) when you update the static servlet
