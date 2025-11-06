pipeline {
  agent {
    docker {
      image 'maven:3.9.9-eclipse-temurin-21'
      args '-v $HOME/.m2:/root/.m2'
    }
  }

  options { timestamps() }

  parameters {
    string(name: 'TAGS', defaultValue: '@WebTest', description: 'Cucumber tags to run')
  }

  triggers {

    cron('0 20 * * 1')
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Run Tests') {
      steps {
        sh """
          mvn -q clean test \
            -Dtest=com.example.tests.web.cucumbertests.Runner \
            -Dcucumber.filter.tags="${TAGS}" \
            -Dcucumber.plugin='pretty,html:target/cucumber-report.html,json:target/cucumber.json'
        """
      }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts allowEmptyArchive: true, artifacts: 'target/cucumber-report.html,target/cucumber.json'
    }
  }
}
