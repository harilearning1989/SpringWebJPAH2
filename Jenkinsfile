pipeline{
	agent any
	triggers{
        	pollSCM '*/5 * * * *'
    	}
	//tools {
		//echo "Tools"
		//'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
	//}
     environment {
		 FOO = "foo"
		 javaHome = tool name: 'JAVA_HOME', type: 'jdk'
		 javaCMD = "${javaHome}/bin/java"

		 mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
		 mvnCmd = "${mvnHome}/bin/mvn"

		 gradleHome = tool name: 'GRADLE_HOME', type: 'gradle'
		 grdlCmd = "${gradleHome}/bin/gradle"

		 registry = "harilearning1989/spring-web-jpa"
	     	//DOCKER_CERT_PATH = credentials('id-for-a-docker-cred')
         registryCredential = 'DockerRegistry'
         dockerImage = ''
     }
    stages{
       stage('Gradle'){
          steps{
             withEnv(["JAVA_HOME=${tool 'JAVA_HOME'}", "PATH=${tool 'JAVA_HOME'}/bin:${env.PATH}"]){
                git 'https://github.com/harilearning1989/SpringWebJPAH2.git'
                sh 'java -version'
                echo "Maven"
                sh "${mvnCmd} -v"
                sh "${mvnCmd} clean build"
             }
          }
       }
	   stage('Docker') {
		steps {
			sh "docker version" // DOCKER_CERT_PATH is automatically picked up by the Docker client
		}
	}
       stage('Build Docker Image')
       {
          steps
          {
				echo "Nothing"
             //bat 'docker build -t spring-rest-oracle-jquery .'
             //sh 'docker build -t harilearning1989/spring-rest-oracle-jquery:1.0.2 .'
             //sh 'docker build -t harilearning1989/spring-rest-oracle-jquery .'
          }
       }
	   stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
               }
            }
        }
		 stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
       stage('Push Docker Image')
       {
          steps
          {
			echo "Nothing"
             //bat 'docker push harilearning1989/spring-rest-maven'
             //sh 'docker tag spring-rest-oracle-jquery:1.0.0 harilearning1989/spring-rest-oracle-jquery:1.0.0'
             //sh 'docker push harilearning1989/spring-rest-oracle-jquery:1.0.2'
          }
       }
	   stage('Cleaning up') {
            steps {
				echo "CleanUp"
                //sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
       stage('compile')
       {
          steps
          {
             echo 'compiling the application'
          }
       }
       stage('build')
       {
          steps
          {
             echo 'building the application'
          }
       }
       stage('test')
       {
          steps
          {
             echo 'testing the application'
          }
       }
       stage('deploy')
       {
          steps
          {
             echo 'deploying the application'
          }
       }
    }
	post
	{
		always
		{
			echo 'this will run always'
		}
		success
		{
			echo 'this will run success'
		}
		failure
		{
			echo 'this will run failure'
		}
		unstable
		{
			echo 'this will run unstable'
		}
		changed
		{
			echo 'this will run changed'
		}
	}
}