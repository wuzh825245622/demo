pipeline {
    agent any

    stages {
        stage('拉取代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '90aaa8ba-7bb7-4c2f-ba35-4bb98b40a8b6', url: 'git@github.com:wuzh825245622/demo.git']]])
            }
        }
        stage('打包项目') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
