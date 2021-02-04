pipeline {
  agent any
  environment {
    name = 'davidperez01/zuulservice'
  }
  stages {
    stage('Clean') {
      agent any
      steps {
        echo "Nombre del proyecto: ${name}"
        echo 'Clean mvn'
        sh 'mvn clean -DskipTests=true'
      }
    }

    stage('Test') {
      agent any
      environment {
        registry = "${name}"
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
        sh "docker image build -t ${name} ."
      }
    }

    stage('Docker Register') {
      steps {
        echo 'Register Docker'
        echo "registry: ${registry}"
      }
    }

  }
}
