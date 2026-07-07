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

    stage('Aggregate Serenity Report') {
  steps {
    sh 'mvn serenity:aggregate'
  }
}

    stage('Publish Serenity Report') {
  steps {
    script {
      publishHTML([
        reportDir: 'target/site/serenity',
        reportFiles: 'index.html',
        reportName: 'Serenity_20Report',
        keepAll: true,
        alwaysLinkToLastBuild: true,
        allowMissing: false,
        wrapperName: '',
        includes: '**/*'
      ])
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
