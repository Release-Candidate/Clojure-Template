# CLOJURE-TEMPLATE

[![GitHub](https://img.shields.io/github/license/Release-Candidate/clojure-template)](./LICENSE)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/Release-Candidate/Clojure-Template)](https://github.com/Release-Candidate/Clojure-Template/releases/latest)
[![Lint](https://github.com/Release-Candidate/Clojure-Template/actions/workflows/lint.yml/badge.svg)](https://github.com/Release-Candidate/Clojure-Template/actions/workflows/lint.yml)
[![Test](https://github.com/Release-Candidate/Clojure-Template/actions/workflows/tests.yml/badge.svg)](https://github.com/Release-Candidate/Clojure-Template/actions/workflows/tests.yml)
[![Codecov](https://img.shields.io/codecov/c/github/Release-Candidate/clojure-template)](https://app.codecov.io/gh/Release-Candidate/Clojure-Template)

A template for Clojure projects with GitHub integration, support for Codecov coverage integration. Uses deps.edn, Eftest, Humane Test Output, Expectations, Cloverage and test.check.

## Latest Release

See [latest](https://github.com/Release-Candidate/Clojure-Template/releases/latest).

## Changes

See file [CHANGELOG.md](CHANGELOG.md)

## Build Targets

- Run the program: `clojure -X:run`
- Run linter clj-kondo: `clojure -M:clj-kondo`
- Run linter Eastwood: `clojure -M:eastwood`
- Run tests: `clojure -X:test`
- Run tests with JUnit output: `clojure -X:test-gh` (file `./test.xml`)
- Generate coverage report: `clojure -X:coverage` (file `./target/coverage/lcov.info`)
- Generate Codecov coverage report: `clojure -X:codecov` (file `./target/coverage/codecov.json`)
- Build/generate an überjar: `clojure -T:build uber` (run with `java -jar ./target/clojure-template-VERSION-standalone.jar`)
- Clean the build/remove the directory `target`: `clojure -T:build clean`
- Generate file containing the latest changelog of file `./CHANGELOG.md`, comparing the version with the given version: `clojure -X:parse-changelog '{:version "1.2.3"}'` (file `./first_changelog.md`)

## License

CLOJURE-TEMPLATE is licensed under the MIT license, see file [LICENSE](LICENSE)
