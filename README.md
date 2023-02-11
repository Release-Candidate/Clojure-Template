# CLOJURE-TEMPLATE

[![GitHub](https://img.shields.io/github/license/Release-Candidate/clojure-template)](./LICENSE)
[![Codecov](https://img.shields.io/codecov/c/github/Release-Candidate/clojure-template)](https://app.codecov.io/gh/Release-Candidate/Clojure-Template)

A template for Clojure projects with GitHub integration, support for Codecov coverage integration. Uses deps.edn, Eftest, Humane Test Output, Expectations, Cloverage and test.check.

## Build Targets

- Run linter clj-kondo: `clojure -M:clj-kondo`
- Run linter Eastwood: `clojure -M:eastwood`
- Run tests: `clojure -X:test`
- Run tests with JUnit output: `clojure -X:test-gh` (file `./test.xml`)
- Generate coverage report: `clojure -X:coverage` (file `./target/coverage/lcov.info`)
- Generate Codecov coverage report: `clojure -X:codecov` (file `./target/coverage/codecov.json`)

## License

CLOJURE-TEMPLATE is licensed under the MIT license, see file [LICENSE](LICENSE)
