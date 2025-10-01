pipeline {
  agent any

  tools {
    maven 'Maven_3.8.1'
    jdk 'Java_11'
   }

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

    stage('Inject Credentials') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'restream-login', usernameVariable: 'EMAIL', passwordVariable: 'PASSWORD')]) {
          writeFile file: 'login.properties', text: """
            email=${EMAIL}
            password=${PASSWORD}
          """
        }
      }
    }

    stage('Run Tests') {
      steps {
        sh 'mvn verify -Dlogin.config=login.properties'
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