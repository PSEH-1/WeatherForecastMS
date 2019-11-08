node {
environment {
     registry = "sagdeshm1/weather-forecast-app"
     registryCredential = ‘dockerhub-credentials’
 }

    withMaven(maven:'mvn') {

        stage('Checkout') {
            git url: 'https://github.com/PSEH-1/WeatherForecastMS.git', credentialsId: 'github-credentials', branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

stage('Deploy Image') {
  steps{
    script {
      docker.withRegistry( '', registryCredential ) {
      docker build --no-cache -t weather-forecast-app .
      docker tag weather-forecast-app:latest sagdeshm1/weather-forecast-app:latest
        dockerImage.push()
      }
    }
  }
}

stage('Run of ec2 instance'){

def dockerRun = 'docker run -p 8080:8080' -d --name weather-forecast-app'
sshagent(['ec2-instance']) {
sh "ssh -o StrictHostKeyChecking=no ubuntu@18.217.14.48 ${dockerRun}"
}
}
    }

}