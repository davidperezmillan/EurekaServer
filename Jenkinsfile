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

    stage('Proccess') {
      agent any
      environment {
        registry = 'davidperez01/EurekaServer'
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Proccess'
      }
    }

    stage('Register') {
      steps {
        echo 'Register DockerHub....'
        sh '''docker image build -t davidperez01/eurekaserver:latest .
'''
      }
    }

  }
}