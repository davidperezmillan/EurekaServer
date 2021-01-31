pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'mvn clean -DskipTests=true'
        sh 'mvn install -DskipTests=true'
        echo 'Build......'
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

    stage('Register') {
      steps {
        echo 'Register DockerHub....'
      }
    }

  }
}