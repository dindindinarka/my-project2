# Gatling Myservice Project

[[_TOC_]]

## CI

Simulations are run using [perf-ci-template](https://gitlab.tcsbank.ru/perf-core/perf-ci-template) and [gatling-docker-gun](https://gitlab.tcsbank.ru/perf-core/gatling-docker-gun)

All CI configuration can be found in [.gitlab-ci.yml](.gitlab-ci.yml)

## Launch and debug

### Project structure

```bash
src.test.resources - project resources
src.test.scala.name [myservice]: test.myservice.cases - simple cases
src.test.scala.name [myservice]: test.myservice.scenarios - common load scenarios assembled from simple cases
src.test.scala.name [myservice]: test.myservice - common test configs
```

### Debug

1. Debug test with 1 user, requires proxy on localhost:8888, eg using Fiddler or Wireshark

```bash
"Gatling / testOnly name [myservice]: test.myservice.Debug"
```

2. Run test from IDEA with breakpoints

```bash
name [myservice]: test.GatlingRunner
```

### Launch test

```bash
"Gatling / testOnly name [myservice]: test.myservice.MaxPerformance" - maximum performance test
"Gatling / testOnly name [myservice]: test.myservice.Stability" - stability test
```

### Pushing and MR (merge request) to repository

Pushing to repository **must** be done according to branch/commit naming convention (see [policy.yml](https://gitlab.tcsbank.ru/perf-core/gatling-template.g8/-/blob/master/src/main/g8/policy.yml) and [detailed description](https://wiki.tcsbank.ru/pages/viewpage.action?pageId=797085764)). 

Scala code **must** be formatted before pushing to repository:
```shell
sbt scalafmtSbt scalafmtAll
```

Some files could be ignored by `sbt scalafmtSbt scalafmtAll`, so do `scalafmtOnly ./project/relative_file_path.scala` in sbt shell.

Also, you can use [Scalafmt](https://www.jetbrains.com/help/idea/work-with-scala-formatter.html) formatter in IDEA as default formatter (Preferences > Editor > Code style > Scala > Formatter). It's recommended to turn on *Reformat on file save*.

When work in branch is done you should create *Merge request* with template `perf_test` in *Description* field and create a request in [#team-performance-ask](https://tinkoff.slack.com/archives/CEY0FJD5Y) channel.


## Links

Performance team slack channel: [#team-performance-ask](https://tinkoff.slack.com/archives/CEY0FJD5Y)

Simulation run notifications: [#performance-test-runs](https://tinkoff.slack.com/archives/C011K6YS1GS)

Performance testing projects: [repositories](https://devplatform.tcsbank.ru/performance/repositories)

Cosmos: [latest runs](https://devplatform.tcsbank.ru/performance/cosmos/latest)

Wiki info page: [Performance & Load](https://wiki.tcsbank.ru/pages/viewpage.action?pageId=19441513)

Performance CI template info: [perf-ci-template](https://gitlab.tcsbank.ru/perf-core/perf-ci-template)

Gatling Docker Gun info: [gatling-docker-gun](https://gitlab.tcsbank.ru/perf-core/gatling-docker-gun)
