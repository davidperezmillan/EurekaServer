pipeline {
  agent any
  stages {
    stage('Clean') {
      agent any
      environment {
        name = 'davidperez01/EurekaServer'
      }
      steps {
        echo 'Clean mvn'
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
        echo 'Test Project'
        sh 'mvn test'
      }
    }

    stage('Build & Docker') {
      steps {
        echo 'mvn Build'
        sh 'mvn install -DskipTests=true'
        echo 'Docker Imagen'
        sh 'docker image build -t davidperez01/eurekaserver .'
      }
    }

    stage('Docker Register') {
      steps {
        echo 'Register Docker'
        echo 'Nombre del proyecto: $name'
      }
    }

  }
  environment {
    name = 'davidperez01/eurekaserver'
  }
}