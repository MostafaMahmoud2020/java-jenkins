def call() {
    withCredentials([string(credentialsId: 'github-token', variable: 'GIT_TOKEN')]) {
        sh """
            rm -rf argocd-test
            git clone https://$GIT_TOKEN@github.com/MostafaMahmoud2020/argocd-test.git
            cd argocd-test
            sed -i 's|image: .*|image: mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER}|' deployment.yaml
            git config user.email "jenkins@example.com"
            git config user.name "Jenkins"
            git commit -am "Update image to mostafamahmoud0/test-java-app:v${env.BUILD_NUMBER}"
            git push origin main
        """
    }
}
