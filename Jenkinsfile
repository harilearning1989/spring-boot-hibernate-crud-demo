pipeline{
	agent any
	triggers{
	    pollSCM '*/5 * * * *'
	}
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
                    //git 'https://github.com/harilearning1989/spring-rest-crops.git'
                    sh 'java -version'
                    echo "Gradle"
                    sh "${grdlCmd} -v"
                    sh "${grdlCmd} clean build"
                }
            }
	    }
	}
}