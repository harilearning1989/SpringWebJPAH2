pipeline{
	agent any
	tools {
        gradle '7.5.1'
        maven '3.8.6'
    }
	triggers{
        	pollSCM '*/5 * * * *'
    	}
     environment {
		 FOO = "foo"
		 javaHome = tool name: 'JAVA_HOME', type: 'jdk'
		 javaCMD = "${javaHome}/bin/java"

         registry = "harilearning1989/spring-web-jpa"
         registryCredential = 'DockerHub'
         dockerImage = ''
     }
     stages {
        stage ('Build') {
            steps {
                sh 'mvn --version'
                //git 'https://github.com/harilearning1989/SpringWebJPAH2.git'

                git url: 'https://github.com/harilearning1989/SpringWebJPAH2.git', branch: 'main'
                // Change file permisson
                //sh "chmod +x -R ./jenkins"
                sh 'java -version'
                echo "Maven"
                sh "mvn -v"
                //sh "mvn clean build"
                sh "mvn clean install -DskipTests=true"
            }
        }
        stage('Building our image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Docker') {
        	steps {
        		sh "docker version" // DOCKER_CERT_PATH is automatically picked up by the Docker client
        	}
        }
    }
}