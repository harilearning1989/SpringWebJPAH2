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
     }
    stages{
       stage('Gradle'){
          steps{
             withEnv(["JAVA_HOME=${tool 'JAVA_HOME'}", "PATH=${tool 'JAVA_HOME'}/bin:${env.PATH}"]){
                git 'https://github.com/harilearning1989/spring-rest-crops.git'
                sh 'java -version'
                echo "Gradle"
                sh "${grdlCmd} -v"
                sh "${grdlCmd} clean build"
             }
          }
       }

       stage('Upload War To Nexus'){
            steps{
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'spring-rest-crops',
                        classifier: '',
                        file: 'build/libs/spring-rest-crops.jar',
                        type: 'jar']
                    ],
                    credentialsId: 'Nexus3',
                    groupId: 'com.web.demo',
                    nexusUrl: 'localhost:8081/',
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    repository: 'http://localhost:8081/repository/hari-release',
                    version: '0.0.1-SNAPSHOT'
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
	    always {
	        echo 'this will run success'
            junit skipPublishingChecks: true, testResults: '**/cpputest_*.xml'
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