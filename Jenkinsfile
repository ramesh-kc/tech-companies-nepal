pipeline {
   agent any

   tools {
      maven "Maven"
   }

   stages {
      stage('Build') {
         steps {
            git changelog: false, credentialsId: 'RameshGitHub', poll: false, url: 'https://github.com/ramesh-kc/tech-companies-nepal'
            sh "mvn clean install -U"
         }

         }
      }
   }
}
