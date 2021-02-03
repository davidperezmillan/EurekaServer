pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          agent any
          steps {
            echo 'Build......'
            deleteDir()
            sh 'mvn clean -DskipTests=true'
            sh 'mvn install -DskipTests=true'
          }
        }

        stage('Test Docker') {
          steps {
            sh 'docker ps'
          }
        }

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