# Changelog

## Unreleased (2021-07-01)

#### New Features

* include docker based build and refactor test
* use .cmdb as a directory for cmdb related information
* hide stack trace on stop exception
* custom exceptions and return codes
* add toConsole method [#45](https://github.com/hamlet-io/engine-core/issues/45)
* support pretty print for toCMDB method
* pin the version for the release
* Files/Directories only search optimisation
* bump freemarker version
* pin the version
* pin the version
* set Format to json by default
* use hamlet instead of codeontap
* (cmdb): methods to update a CMDB
* (cicd): setup github actions
#### Fixes

* default tags
* tag naming
* default tag for docker package
* (ci): update packaging process for artifacts ([#68](https://github.com/hamlet-io/engine-core/issues/68))
* (ci): invalid syntax in package workflow
* add .hamlet build info in docker image
* setup package version
* update engine version
* update artifact details
* (ci): test result description
* (ci): package syntax
* remove artifact upload on test
* push trigger
* create a file if it doesn't exest when call toCMDB
* add a test to cover rmCMDb specific file path
* adjust rmCMDB logic to remove a specified file
* method name for InitPluginsMethod
* ignore FileNotFoundException during wrapper parameters processing
* read Format parameter of toCMDB method
* add toConsole method to the freemarker input
* support a default value for sendTo
* mkdir method
* mkdir method
* mkdir method
* FilenameGlob processing
* (cmdb): always include isDirectory flag
* filesystem caching for all methods
* filesystem caching
* proper processing of IgnoreSubtreeAfterMatch flag
* nullpointer exception for getFileTree in case when there are CMDBs with common prefix
* comment out code that produces wrong JSON serialisation
* proper multiple plugin handling in mingw
* (plugin): multiple plugin handling in mingw
* (cmdb): fix mkdir method
* (logging): use Log4j2 for logging
* corrupting the plugin file system
* corrupting the plugin file system
#### Refactorings

* (ci): quality of life updates
#### Others

* remove prebuilt jar versions
* update version
* (deps): bump commons-io from 2.6 to 2.7 in /freemarker-wrapper
* update version
* bump a minor version
* version bump
* rename getPlugins() to getPluginLayers()
* (deps): bump jackson-databind in /freemarker-wrapper
* (dist): add 1.12.1-rc version and clean up old ones
* (freemarker): bump freemarker version
* remove verbose output from createTemplate exeuction
