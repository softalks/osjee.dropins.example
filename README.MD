[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://www.paypal.com/donate/?business=7JXD6EDFHXF5C&no_recurring=0&item_name=To+allow+the+development%2C+maintenance+and+evolution+of+a+kind+of+software+that+can+only+exist+in+this+way&currency_code=USD)
> Before using this project you must download, build and install the [dsu](https://github.com/softalks/dsu), [osjee](https://github.com/softalks/osjee) and [osjee.dropins](https://github.com/softalks/osjee.dropins) projects. They will be properly packaged in a near future to avoid this requirement
# [DSU](https://github.com/softalks/dsu)/[OSJEE](https://github.com/softalks/osjee) Example
Running `mvn post-clean verify` from the the base directory of this project allows you to 
* [install](https://github.com/OpenLiberty/ci.maven/blob/main/docs/create.md#create) an [Open Liberty](https://openliberty.io/) server with the [Java Servlets](https://openliberty.io/docs/latest/reference/feature/servlet-4.0.html) (4.0) and [OSGi Debug Console](https://openliberty.io/docs/latest/reference/feature/osgiConsole-1.0.html) features
* build the WAR files providing the `/dynamic` and `/static` web contexts and deploy them to the server dropins directory
* [build](https://github.com/softalks/dsu.example/blob/main/bundle/pom.xml) an OSGi bundle containing a [Hello, World!](https://github.com/softalks/dsu.example/blob/main/bundle/src/main/java/com/softalks/osjee/example/Dynamic.java) servlet and deploy it to the directory [configured](https://felix.apache.org/documentation/subprojects/apache-felix-file-install.html) for bundle dropins
* [start](https://github.com/OpenLiberty/ci.maven/blob/main/docs/start.md#start) the server with a dropins aware OSGi framework attached to the `/dynamic` context path

To update the [dynamic](https://en.wikipedia.org/wiki/Dynamic_software_updating) servlet code you just need to rebuild run the command `mvn clean package` from the `/bundle` directory of the project

To update the static servlet code you need to rebuild the corresponding WAR file:
```
cd contexts/static
mvn clean package
cd ..
```
