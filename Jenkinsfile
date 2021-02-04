pipeline {
  agent any
  environment {
    PROJECT_NAME = 'davidperez01/EurekaServer'
  }
  
  stages {
    stage('Clean') {
      agent any
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
        sh 'docker image build -t ${PROJECT_NAME} .'
      }
    }

    stage('Docker Register') {
      steps {
        echo 'Register Docker'
        echo 'Nombre del proyecto: ${PROJECT_NAME}'
      }
    }

  }
}
