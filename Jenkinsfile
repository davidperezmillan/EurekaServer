pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        echo 'Build......'
        sh 'mvn clean -DskipTests=true'
      }
    }

    stage('Test') {
      agent any
      environment {
        registry = 'davidperez01/EurekaServer'
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Test'
        sh 'mvn test'
      }
    }

    stage('Docker Build') {
      steps {
        echo 'Docker build images'
        sh 'mvn install -DskipTests=true'
        sh 'docker image build -t nonave/eureka .'
      }
    }

    stage('Docker Register') {
      steps {
        echo 'Register Docker'
      }
    }

  }
}