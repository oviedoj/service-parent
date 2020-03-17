# service-parent
Dropwizard + Spring Archetype

## Getting Started

This is an archetype to use when working with spring and dropwizard applications. 
The reason to use dropwizard is its flexibility to add bundles

### Installing

Get the project and install it as a maven application

```
maven clean build install
```

Once the project is compiled and installed run the dropwizard server

```
com.cnbr.service.api.app.ServiceApp server <PATH to YAML CONF>
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used, with Bundles
* [Spring](https://spring.io/) - Manage Beans, DS, AOP in the App

## Authors

* **oviedoj** **neli**
