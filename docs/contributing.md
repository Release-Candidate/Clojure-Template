# Contributing

Any help is welcome!

If you encounter a problem using CLOJURE-TEMPLATE, a task is not as easy as you'd like it to be or you'd like something added to it: open an issue at GitHub, see section [Report Issues](#report-issues-bugs-and-feature-requests).

- [Contributing](#contributing)
  - [Report Issues (Bugs and Feature Requests)](#report-issues-bugs-and-feature-requests)
  - [Forking the Repository](#forking-the-repository)
    - [Github Documentation on Collaborating with Issues and Pull Requests](#github-documentation-on-collaborating-with-issues-and-pull-requests)
  - [Developing Clojure-Template](#developing-clojure-template)
    - [Changing and Generating Documentation](#changing-and-generating-documentation)
      - [Installing Dependencies](#installing-dependencies)
      - [MkDocs Files](#mkdocs-files)
      - [Read the Docs Configuration](#read-the-docs-configuration)
      - [GitHub Documentation](#github-documentation)
    - [Source Code](#source-code)
      - [Clojure](#clojure)
  - [GitHub Workflows](#github-workflows)
  - [GitHub Issue Templates](#github-issue-templates)
  - [Clojure sources](#clojure-sources)
    - [Build Targets](#build-targets)
  - [What is What? - List of all other Files](#what-is-what---list-of-all-other-files)

## Report Issues (Bugs and Feature Requests)

Please help making CLOJURE-TEMPLATE better by filing bug reports and feature requests.

- File a bug report at [GitHub bug report](https://github.com/Release-Candidate/Clojure-Template/issues/new?assignees=&labels=&template=bug_report.md&title=).
- Add a feature request at [GitHub feature request](https://github.com/Release-Candidate/Clojure-Template/issues/new?assignees=&labels=&template=feature_request.md&title=).
- Take a look at the [Issue Tracker at GitHub](https://github.com/Release-Candidate/Clojure-Template/issues)

## Forking the Repository

If you'd like to contribute directly, e.g. better the documentation, add another language or write some source code: fork Clojure-Template by clicking the `Fork` button in the upper right corner of the GitHub project website. Check out your fork of Clojure-Template using the URL from the `Code` button of your fork on Github. The URL should be something like github.com/YOUR_USERNAME/Clojure-Template.git.

Details about how to fork a repository on Github are [here](https://docs.github.com/en/github/getting-started-with-github/fork-a-repo).

Make your changes, push them to your forked repository and make a pull-request (e.g. using the Pull request-button above and right of GitHubs source file view).

See [GitHub on Pull-Requests](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/proposing-changes-to-your-work-with-pull-requests) and another [How-To](https://github.com/MarcDiethelm/contributing/blob/master/README.md).

### Github Documentation on Collaborating with Issues and Pull Requests

See GitHub's documentation about how to contribute for details: [Collaborating with issues and pull requests](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests).

## Developing Clojure-Template

### Changing and Generating Documentation

#### Installing Dependencies

To generate the documentation using MkDocs, a virtual Python environment is needed. First you need to install Python, if you don't have it installed already - either from your distributions repository, using the XCode or [Homebrew](https://brew.sh/) version, or getting it from [Python.org](https://www.python.org/downloads/).

See

- [Using Python on Windows](https://docs.python.org/3/using/windows.html)
- [Using Python on a Macintosh](https://docs.python.org/3/using/mac.html)
- [Using Python on Unix Platforms](https://docs.python.org/3/using/unix.html)

Install `pipenv` using the package manager pip

```shell
pip install pipenv
```

Now you're ready to download and install the needed packages using pipenv

```shell
pipenv install --dev
```

After that you can use MkDocs.

Call

```shell
pipenv run mkdocs serve
```

in the root directory of Clojure-Template and connect to the running web server at [http://127.0.0.1:8000](http://127.0.0.1:8000).
This preview shows changes in realtime, so any changes to the markdown files in `docs` you see as preview as soon as you save the file.

#### MkDocs Files

- `./Pipfile` - Packages needed by MkDocs to install using `pipenv` and the package `mkdocs` itself.
- `mkdocs.yml` - the MkDocs configuration, specially the configuration of the navigation sidebar in `nav` which you may need to edit

```yml
  nav:
  - Home: index.md
  - Project Links:
      - "Downloads": https://github.com/Release-Candidate/Clojure-Template/releases/latest
      - "GitHub Project Page": "https://github.com/Release-Candidate/Clojure-Template"
      - "Report a Bug or a Feature Request": "https://github.com/Release-Candidate/Clojure-Template/issues/new/choose"
      - "Issue Tracker at GitHub": "https://github.com/Release-Candidate/Clojure-Template/issues"
  - "Installation & Usage":
      - "Installation & Usage": usage.md
      - License: license.md
  - Contributing:
      - Contributing: contributing.md
```

- `docs/` - the markdown files that are used to generate the
   HTML sites

#### Read the Docs Configuration

- `.readthedocs.yaml` the configuration for Read the Docs
- `docs/requirements.txt` the packages needed by MkDocs
   when generating the documentation at Read the Docs.
   Locally needed packages are configured in `Pipfile`
- `./docs/index.md` - The documentation's home page.
- `./docs/usage.md` - Usage information.
- `./docs/contributing.md` - Information on how to contribute to the project.
- `./docs/license.md` - The license of the file

Read the Docs automatically generates the MkDocs documentation after each `git push`.

#### GitHub Documentation

The Markdown documentation for GitHub are the files [README.md](https://github.com/Release-Candidate/Clojure-Template/blob/main/README.md), [LICENSE](https://github.com/Release-Candidate/Clojure-Template/blob/main/LICENSE) and [CHANGELOG.md](https://github.com/Release-Candidate/Clojure-Template/blob/main/CHANGELOG.md) in the project root directory.

### Source Code

Before you can use the configured Tools of this project, you have to download and install the needed tools.

#### Clojure

To install Clojure see the [official website](https://clojure.org/guides/install_clojure).

## GitHub Workflows

These are the GitHub workflows defined in the directory `.github/workflows`

- `release.yml` builds the überjar and
  generates a new GitHub release with this überjar appended. Runs automatically after tagging
  the source with a release tag of the form `v?.?.?`. Appends the newest entry in [CHANGELOG.md](https://github.com/Release-Candidate/Clojure-Template/blob/main/CHANGELOG.md) to the release - using the clojure program [parse_changelog.clj](https://github.com/Release-Candidate/Clojure-Template/blob/main/parse_changelog.clj).
  See the [releases on GitHub](https://github.com/Release-Candidate/Clojure-Template/releases) as an example
- `lint.yml` - Runs the linters - clj-kondo and Eastwood on the source files in the directories `src` and `test`.
- `test.yml` - Runs the tests

## GitHub Issue Templates

Issue templates for GitHub in `.github/ISSUE_TEMPLATE/`

- `bug_report.md` Bug report template
- `feature_request.md` Feature request template

## Clojure sources

- `./build.clj` - The build script. Usage see next chapter [Build targets](#build-targets).
- `./deps.edn` - The project's configuration.
- `./src` - Contains all Clojure sources.
- `./test` - Contains the sources of all Clojure test cases.

### Build Targets

- Run the program: `clojure -X:run`
- Run linter clj-kondo: `clojure -M:clj-kondo`
- Run linter Eastwood: `clojure -M:eastwood`
- Run tests: `clojure -X:test`
- Run tests with JUnit output: `clojure -X:test-gh` (file `./test.xml`)
- Generate documentation using Mkdocs: `clojure -T:build doc`
- Generate coverage report: `clojure -X:coverage` (file `./target/coverage/lcov.info`)
- Generate Codecov coverage report: `clojure -X:codecov` (file `./target/coverage/codecov.json`)
- Build/generate an überjar: `clojure -T:build uber` (run with `java -jar ./target/clojure-template-VERSION-standalone.jar`)
- Clean the build/remove the directory `target`: `clojure -T:build clean`
- Generate file containing the latest changelog of file `./CHANGELOG.md`, comparing the version with the given version: `clojure -X:parse-changelog '{:version "1.2.3"}'` (file `./first_changelog.md`)

## What is What? - List of all other Files

A list of all the other files in this repository and what they do or configure.

- `./README.md` - The main documentation file.
- `./LICENSE` - The project's license file.
- `./CHANGELOG.md` - The project's changelog.
- `./Clojure-Template.code-workspace` - The Visual Studio Code workspace file.
- `./.clj-kondo/config.edn` - Configuration file for clj-kondo, the clojure linter
- `./.gitignore` - Ignore file for Git, every file that matches this ignore list is not going to be committed.
- `codecov.yml` - Configuration file for [Codecov](https://app.codecov.io/gh/Release-Candidate/Clojure-Template)
- `./parse_changelog.clj` - Program to parse the changelog for the latest version. Used by the `release` GitHub action (see [GitHub Workflows](#github-workflows))
