pipeline {
    environment {
        imagename = "xeroxcom/nagios-sentry:latest"
        registryCredential = 'mikefinnx-dockerhub'
        dockerImage = ''
    }
    agent any
    tools {
        maven 'mvn-3.8.4'
    }
    stages {
        stage('Cloning Git') {
            steps {
                git([url: 'https://github.com/mikefinnxrx/cicd-demo-webapp.git', branch: 'master', credentialsId: 'mikefinnxrx-github'])
            }
        }

        stage('Building app') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build imagename
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                        dockerImage.push('latest')
                    }
                }
            }
        }
        stage('Remove Unused docker image') {
            steps{
                sh "docker rmi $imagename:$BUILD_NUMBER"
                sh "docker rmi $imagename:latest"
            }
        }
    }
}