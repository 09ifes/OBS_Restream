pipeline {
  agent any

  environment {
    MAVEN_OPTS = "-Xmx1024m"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        bat 'mvn clean verify'
      }
    }

    stage('Publish Serenity Report') {
      steps {
        publishHTML(target: [
          reportDir: 'target/site/serenity',
          reportFiles: 'index.html',
          reportName: 'Serenity Report'
        ])
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: 'target/site/serenity/**', fingerprint: true
      junit 'target/failsafe-reports/*.xml'
    }
  }
}