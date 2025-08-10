def call() {
    sh "docker build -t mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER} ."
    sh 'docker images'
}

