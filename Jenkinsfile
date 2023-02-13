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
                git credentialsId: 'GitHub', url: 'https://github.com/harilearning1989/SpringWebJPAH2.git'
                sh 'java -version'
                echo "Gradle"
                sh 'java -version'
                echo "Maven"
                sh "mvn -v"
                //sh "mvn clean build"
                sh "mvn clean install -DskipTests=true"
             }
          }
       }
    }
}