@Library('my-library@master') _

pipeline {
    agent any

    stages {
        stage('Check SCM') {
            steps {
                checkScm()
            }
        }
        stage('Build App') {
            steps {
                buildApp()
            }
        }
        stage('Archive App') {
            steps {
                archiveApp()
            }
        }
        stage('Test App') {
            steps {
                testApp()
            }
        }
        stage('Docker Build') {
            steps {
                dockerBuild()
            }
        }
        stage('Docker Push') {
            steps {
                dockerPush()
            }
        }
    }
}

