pipeline {
  agent any
  stages {
    stage('dev') {
      parallel {
        stage('dev') {
          steps {
            echo 'Start'
          }
        }
        stage('maven') {
          steps {
            sh 'mvn clean install -DskipTests'
          }
        }
      }
    }
    stage('test') {
      parallel {
        stage('test') {
          steps {
            echo 'test'
          }
        }
        stage('mvn test') {
          steps {
            sh 'echo success'
          }
        }
      }
    }
    stage('preprod') {
      parallel {
        stage('preprod') {
          steps {
            echo 'preprod'
          }
        }
        stage('maven ready') {
          steps {
            sh 'mvn clean install -DskipTests'
          }
        }
      }
    }
    stage('confirmation') {
      steps {
        input 'Confirm to deploy to prod?'
      }
    }
    stage('prod') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
  }
}