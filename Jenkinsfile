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
	    stage('Maven'){
	        steps{
                withEnv(["JAVA_HOME=${tool 'JAVA_HOME'}", "PATH=${tool 'JAVA_HOME'}/bin:${env.PATH}"]){
                    git 'https://github.com/harilearning1989/spring-boot-hibernate-crud-demo.git'
                    sh 'java -version'
                    echo "Gradle"
                    sh "${grdlCmd} -v"

                    echo "Maven"
                    sh "${mvnCmd} -v"
                    sh "${mvnCmd} clean install -DskipTests=true"
                }
            }
	    }
	    stage('Upload War To Nexus'){
	        steps{
	            //echo "${POM_GROUPID}"
	            //echo "${POM_VERSION}"
	            //echo "${POM_ARTIFACTID}"
	            nexusArtifactUploader artifacts: [
	                [
	                    artifactId: 'spring-hibernate',
	                    classifier: '',
	                    file: 'target/spring-hibernate',
	                    type: 'war'
	                ]
                ],
                credentialsId: 'Nexus3',
                groupId: 'com.howtodoinjava',
                nexusUrl: 'localhost:8081/',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'repository/hari-release',
                version: '0.0.1-SNAPSHOT'
            }
        }
	}
}