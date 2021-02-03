pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        echo 'Build......'
        sh 'mvn clean -DskipTests=true'
        sh 'mvn install -DskipTests=true'
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

    stage('Build Docker') {
      steps {
        echo 'BuildDockerHub....'
      }
    }

    stage('Register') {
      steps {
        echo 'Register Docker hub'
      }
    }

  }
}