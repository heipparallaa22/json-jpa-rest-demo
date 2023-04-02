pipeline {
  agent any

  stages {
    stage('Clone Git Repository') {
      steps {
        git url: '<repository_url>', branch: '<branch_name>'
      }
    }
    stage('Execute SQL File') {
      steps {
        sh 'psql -h <hostname> -U <username> -d <database_name> -a -f /path/to/your/repository/file.sql'
      }
    }
  }
}