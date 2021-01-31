pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Register DockerHUB') {
      agent any
      environment {
        registry = 'davidperez01/EurekaServer'
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Register'
        sh 'docker.build registry + ":$BUILD_NUMBER"'
      }
    }

  }
}