# spring-boot-mockito-unittesting

- Basic Junit 5 testing
    - only maintainable for basic methods

- Stub Testing
    - MAJOR DISADVANTAGE: you need to create different stubs for every unit test. Ex: to test empty list you need to create new stub
    - MAJOR DISADVANTAGE: if you add another method to IDemoDataService, you need to create another set of stubs
    - DISADVANTAGE: you need to do business analysis to fill the stubs

- `@Mock` creates a mock, and `@InjectMocks` creates an instance of the class and injects the mocks that are created with the `@Mock` annotations into this instance.

## Spy

- when you use mock, entire behaviour of that class is lost.
- a mock does not retain the behaviour of the original class.
- however spy keeps the behaviour of the original class and you can override class methods with `mockito.when`