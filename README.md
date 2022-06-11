# spring-boot-mockito-unittesting

- Basic Junit 5 testing
    - only maintainable for basic methods

- Stub Testing
    - MAJOR DISADVANTAGE: you need to create different stubs for every unit test. Ex: to test empty list you need to create new stub
    - MAJOR DISADVANTAGE: if you add another method to IDemoDataService, you need to create another set of stubs
    - DISADVANTAGE: you need to do business analysis to fill the stubs