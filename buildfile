# Maven 2 central repository (mirror)
repositories.remote << 'http://www.ibiblio.org/maven2/'

# jmona repository
repositories.remote << 'http://www.cs.tufts.edu/~jfinke02/repo'

# biojava repository
#repositories.remote << 'http://biojava.org/download/maven'

# jahmm repositoriy
#repositories.remote << 'http://jahmm.googlecode.com/svn/repo'

desc 'peyo'
define 'peyo' do
  project.group = 'peyo'
  project.version = '0.1-SNAPSHOT'
  compile.with \
  'log4j:log4j:jar:1.2.14',
  'jmona:jmona:jar:0.5-SNAPSHOT',
  #'be.ac.ulg.montefiore.run.jahmm:jahmm:jar:0.6.2',
  'org.biojava:biojava:jar:1.7.1',
  'org.apache.commons:commons-lang3:jar:3.0-SNAPSHOT'
  test.with \
  transitive('org.springframework:spring-test:jar:3.0.4.RELEASE'),
  transitive('org.springframework:spring-beans:jar:3.0.4.RELEASE')
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
