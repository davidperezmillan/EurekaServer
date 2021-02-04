pipeline {
  agent any
  stages {
    stage('Clean') {
      parallel {
        stage('Clean') {
          agent any
          environment {
            name = 'davidperez01/EurekaServer'
          }
          steps {
            echo 'Clean mvn ${env.name}'
            sh 'mvn clean -DskipTests=true'
          }
        }

        stage('') {
          steps {
            echo '${env.name}'
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
        echo 'Test Project'
        sh 'mvn test'
      }
    }

    stage('Build & Docker') {
      steps {
        echo 'mvn Build'
        sh 'mvn install -DskipTests=true'
        echo 'Docker Imagen'
        sh 'docker image build -t ${env.name} .'
      }
    }

    stage('Docker Register') {
      steps {
        echo 'Register Docker'
        echo 'Nombre del proyecto: ${env.name}'
      }
    }

  }
  environment {
    name = 'davidperez01/EurekaServer'
  }
}