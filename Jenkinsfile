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
        registry = 'docker_hub_account/repository_name'
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Register'
        sh 'docker.build registry + ":$BUILD_NUMBER"'
      }
    }

  }
}