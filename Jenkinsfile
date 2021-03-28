pipeline {
    agent any

    stages {
       stage('拉取代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '90aaa8ba-7bb7-4c2f-ba35-4bb98b40a8b6', url: 'git@github.com:wuzh825245622/demo.git']]])
            }
        }
        stage('打包项目') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('上传'){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: '测试机', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/app2/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/*.jar'), sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/app2/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'Dockerfile'), sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/app2/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'docker-compose.yml')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
        stage('上传2'){
            steps{
               sshPublisher(publishers: [sshPublisherDesc(configName: '测试机', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd /app2
docker build -t demo:1.3 .
''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
    post {
        always {
            emailext body: '${FILE,path="email.html"}',
            subject: '构建通知：${PROJECT_NAME} - BUILD # ${BUILD_NUMBER} - ${BUILD_STATUS}',
            to: 'wuzh6@asiainfo.com'
        }
    }
}
