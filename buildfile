# Maven 2 central repository (mirror)
repositories.remote << 'http://www.ibiblio.org/maven2/'

desc 'peyo'
define 'peyo' do
  project.group = 'peyo'
  project.version = '0.1-SNAPSHOT'
  compile.with \
  'log4j:log4j:jar:1.2.14',
  test.with transitive('org.springframework:spring-test:jar:3.0.4.RELEASE')
  test.include '*AllTest'
  compile.options.deprecation = true
  compile.options.lint = true
  compile.options.source = 1.6
  compile.options.target = 1.6
  compile.options.warnings = true
  package :jar, :id => 'jmona'
  #package :sources
  #package :javadoc
end
