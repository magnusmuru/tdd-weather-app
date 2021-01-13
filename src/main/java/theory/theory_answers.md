### 1. Which of the following activities cannot be automated
- [ ] Test execution
- [X] Exploratory testing
- [X] Discussing testability issues
- [ ] Test data generation

### 2. How do we describe a good unit test?
- [ ] Flawless, Ready, Self-healing, True, Irresistible
- [ ] Red, Green, Refactor
- [X] Fast, Repeatable, Self-validating, Timely, Isolated
- [ ] Tests should be dependent on other tests

### 3. When is it a good idea to use XPath selectors
- [X] When CSS or other selectors are not an option or would be brittle and hard to maintain
- [ ] When we need to find an element based on parent/child/sibling relationship
- [ ] When an element is located deep within the HTML (or DOM) structure
- [ ] All the above

### 4. Describe the TDD process
Test Driven Development focus on the approach of writing the test first and then implementing code changes. TDD approach focuses on delivering clean code that supports better development by working in the following flow:
 1) Read and understand the required feature or bug.
 2) Write a unit test based on the requirement. The unit test will fail, as there is no implemented code to test yet. If necessary for the test compilation, implement minimally for the methods/classes that are being tested.
 3) Write the full implementation that fulfills the requirement. The implemented code should pass, else repeat this step.
 4) Refactor already written code, so it follows best practices of clean code.
 
 This approach is sometimes called Red-Green-Refactoring, which follows the status of the tests within the cycle.
 * Red indicates the phase where the code doesn't work, there is only a working test.
 * Green indicates the phase where everything is working, but not always the most efficient way.
 * Refactoring indicates the phase of refactoring the code which works since it is covered by tests. This allows changing and improvement already written code with confidence.

### 5. Write 2 test cases or scenarios for a String Calculator application, which has a method ```calculate()``` that takes a string of two numbers separated by a comma as input, and returns the sum.

- **Given** the input "8,4" **When** the method ```calculate()``` is called **Then** I should see "12" as a result.  
- **Given** the input "7,-5" **When** the method ```calculate()``` is called **Then** I should see "2" as a result.  
