# GuessingGame

Guess a number between one and a hundred for CPS410 pair programming practice

## Running tests

This project uses Maven. To compile and run the tests locally:

```bash
# run tests for the demo module
mvn -f demo/pom.xml test
```

Note: the Maven build output directory (`target/`, and `demo/target/`) is git-ignored because it contains generated files, compiled classes and machine-specific metadata (for example, incremental compiler state and test reports). Those files are recreated by Maven on each build and are intentionally not committed to the repository.
