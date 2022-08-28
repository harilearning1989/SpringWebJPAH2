pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages{
        stage('Build App') {
            steps{
                  //git branch: 'openshift-aws', url: 'https://github.com/harilearning1989/SpringWebJPAH2.git'
                  git credentialsId: 'GitHub', url: 'https://github.com/harilearning1989/SpringWebJPAH2.git'
                  sh "mvn clean install -DskipTests=true"
            }
        }
    }
}