def call() {
    withCredentials([
        string(credentialsId: 'docker-username', variable: 'DOCKER_USER'),
        string(credentialsId: 'docker-password', variable: 'DOCKER_PASS')
    ]) {
        sh 'docker login -u "$DOCKER_USER" -p "$DOCKER_PASS"'
        sh "docker push mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER}"
    }
}

