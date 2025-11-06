pipeline {
  agent any

  tools { maven 'MavenTestsDemoQA' }

  parameters {
    string(name: 'CUCUMBER_TAGS', defaultValue: '', description: @WebTest)
  }

  triggers {
    cron('H 20 * * 1')
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Test (Maven)') {
      steps {
        sh '''
          mvn -V -B clean test \
            -Dcucumber.filter.tags="${CUCUMBER_TAGS}"
        '''
      }
    }
  }

  post {
    always {
      junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
      archiveArtifacts allowEmptyArchive: true, artifacts: 'target/**/*.html, target/**/*.json, target/**/*.xml'
    }
  }
}
