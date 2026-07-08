pipeline {
  agent any

  tools {
    maven 'Maven_3.8.1'
    jdk 'java_17'
  }

  environment {
    MAVEN_OPTS = "-Xmx1024m"
  }


  stages {

stage('Clean Workspace') {
  steps {
    deleteDir()
  }
}

    stage('Checkout') {
      steps {
        checkout scm
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
    catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
        sh 'mvn clean verify -Dlogin.config=login.properties'
    }
  }
}

   stage('Copy Serenity Report') {
    steps {
        sh """
            mkdir -p /var/lib/jenkins/serenity-reports/${BUILD_NUMBER}
            cp -r target/site/serenity/* /var/lib/jenkins/serenity-reports/${BUILD_NUMBER}/
        """
    }
}

    stage('Publish Serenity Link') {
    steps {
        script {
            def url = "https://samueljenkins.servemp3.com/serenity-reports/${BUILD_NUMBER}/index.html"
            echo "Serenity report available at: ${url}"
            currentBuild.description = "Serenity Report: ${url}"
        }
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
