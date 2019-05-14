# Resume Challenge App  
Android mobile application that visualizes a resume through Gists files as data origin.

## Architecture
Clean architecture is the architectural pattern being used through the application, Dagger is being used to inject dependencies through these layers, each layer is described briefly next.

- Data   
  The purpose of this layer is the data management and in this case a long with Retrofit library and its Gson converter the Gists files in JSON format populates domain objects.

- Domain  
  Layer responsible of business logic along with use cases provides model information to the presentation layer.

- Presentation  
  Layer responsible of the visual elements and interactions in the applications here are represented by Fragments and Presenters for each use case.

## Tests  
Unit tests are provided to verify each layer use cases. Libraries like junit, mockito and mockito-kotlin are being used.
