pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages
            {
              stage('Build App')
              {
                steps
                 {
                  git branch: 'openshift-aws', url: 'https://github.com/harilearning1989/SpringWebJPAH2.git'
                  script {
                      def pom = readMavenPom file: 'pom.xml'
                      version = pom.version
                  }
                  sh "mvn clean install -DskipTests=true"
                }
              }
              stage('Test')
              {
                steps
                {
                  sh "${mvnCmd} test -Dspring.profiles.active=test"
                  //step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
                }
              }
}