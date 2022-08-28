pipeline{
	agent any
	tools {
        gradle '7.5.1'
        maven '3.8.6'
        docker 'latest'
    }
	triggers{
        	pollSCM '*/5 * * * *'
    	}
     environment {
		 FOO = "foo"
		 javaHome = tool name: 'JAVA_HOME', type: 'jdk'
		 javaCMD = "${javaHome}/bin/java"
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
        stage('Docker') {
        	steps {
        		sh "docker version" // DOCKER_CERT_PATH is automatically picked up by the Docker client
        	}
        }
    }
}